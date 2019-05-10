package com.easyhome.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.common.WorkOrderStatusConstants;
import com.easyhome.dao.TbMasterSignMapper;
import com.easyhome.dao.TbWorkOrderBookingMapper;
import com.easyhome.dao.TbWorkOrderExtMapper;
import com.easyhome.dao.TbWorkOrderMapper;
import com.easyhome.dao.TbWorkOrderMapperCustom;
import com.easyhome.dao.WorkOrderDao;
import com.easyhome.po.TbMasterSign;
import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.po.TbWorkOrderExample;
import com.easyhome.po.TbWorkOrderExt;
import com.easyhome.po.TbWorkOrderExtExample;
import com.easyhome.po.WorkOrder;
import com.easyhome.po.TbWorkOrderExample.Criteria;
import com.easyhome.service.WorkOrderService;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.DateUtil;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.BadgeRanking;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MasterBadge;
import com.easyhome.vo.PageBean;
import com.easyhome.vo.PageQuery;
import com.easyhome.vo.ReminderWorkOrder;
import com.easyhome.vo.ReminderWorkOrderQuery;
import com.easyhome.vo.SatisfiedByMasterCustom;
import com.easyhome.vo.SatisfiedByMasterQuery;
import com.easyhome.vo.SatisfiedByWokeOrderCustom;
import com.easyhome.vo.SatisfiedByWokeOrderQuery;
import com.google.gson.Gson;

/**
 * 
 * <p>
 * Title: TbWorkOrderBookingServiceImpl
 * </p>
 * <p>
 * Description: 工单预约服务类
 * </p>
 * 
 * @date 2016年5月11日 下午2:18:49
 * @version 1.0
 *
 */
@Service("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService {

	Log log = LogFactory.getLog(WorkOrderServiceImpl.class);

	@Autowired
	private TbWorkOrderBookingMapper tbWorkOrderBookingMapper;

	@Autowired
	private TbWorkOrderMapper tbWorkOrderMapper;

	@Autowired
	private TbWorkOrderMapperCustom tbWorkOrderMapperCustom;

	@Autowired
	private TbWorkOrderExtMapper tbWorkOrderExtMapper;
	
	@Autowired
	private TbMasterSignMapper tbMasterSignMapper;

	public TbWorkOrderBooking saveOrderBooking(String workorderid,
			String linkman, String address, String phone, String status,
			String reason, String date, String call) throws Exception {
		// 1.封装对象
		System.out.println(date);
		TbWorkOrderBooking twob = new TbWorkOrderBooking();
		twob.setAddress(address);
		if (Short.parseShort(status) == 0) {
			if (date.length() > 12) {
				if (date.split(":").length == 2) {
					date = date + ":00";
				}
			}
		}
		log.info(date);

		twob.setBookingTime(Short.parseShort(status) == 0 ? DateUtil
				.string2date(date) : new Date());
		
		if(Short.parseShort(status) == 0){
			log.info(DateUtil.string2date(date));
		}
		
		twob.setCallPhone(call);
		twob.setCreateTime(new Date());
		twob.setFid(UUID.randomUUID().toString());
		twob.setLinkMan(linkman);
		twob.setPhone(phone);
		twob.setStatus(Short.parseShort(status));
		twob.setRemark(reason);
		twob.setStatusDisplay(Short.parseShort(status) == 0 ? "成功" : "失败");
		twob.setWorkOrderId(workorderid);
		// 2.保存预定信息
		log.info("正在保存");
		int insert;
		try {
			insert = tbWorkOrderBookingMapper.insert(twob);
			if(insert>0){
				log.info("保存预约记录成功");
			}else{
				log.info("保存预约记录失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return twob;
	}

	public TbWorkOrder getBookOrderingByFId(String fid) throws Exception {
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(fid);
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public int sendBookInfoMsg(TbWorkOrder workOrder,
			TbWorkOrderBooking orderBooking) throws Exception {

		int reslut = -1;
		log.info("正在执行更新工单状态和短信发送操作！！！");
		try {
			// 客户电话
			String phone = workOrder.getCusTel();
			// 订单号码
			String orderSn = workOrder.getOutOrderSn();
			// 技师名称
			String masterName = workOrder.getMasterName();
			// 技师电话
			String masterPhone = workOrder.getMasterPhone();
			// 预约时间
			String bookTime = "";
			// 预约状态 0成功 1失败
			Short status = orderBooking.getStatus();
			// 购买渠道 天猫/京东
			String shop = "华耐";
			if (orderSn.startsWith("tm")) {
				shop = "天猫";
			} else if (orderSn.startsWith("jd")) {
				shop = "京东";
			}

			// 短信地址
			//String url = "http://218.104.170.69:8080/serve/app/send";

			// 1.属性准备
			int checkCode = 0; // 验证码
			String content = ""; // 预约短信内容
			TbWorkOrderExample example = new TbWorkOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andFidEqualTo(workOrder.getFid());
			if (status == 0) {

				// 3成功短信内容
				content = "尊敬的客户您好，您购买的订单编号为" + orderSn + "的洁具服务已安排"
						+ masterName + "师傅，联系电话" + masterPhone + "，您已成功预约"
						+ bookTime.substring(0, 10) + "上门服务，请您提前做好时间安排，"
						+ "师傅上门签到时请出示给技师验证码" + checkCode + "，您有任何问题也可致电全国"
						+ "客户服务热线4006120122。";

				log.info("预约成功！！！");

			} else {
				workOrder.setCheckCode("");
				workOrder.setStatusDisplay("预约失败");
				workOrder.setStatus(new BigDecimal(1));

				// 4失败短信内容
				content = "尊敬的客户您好，您购买的订单编号为" + orderSn + "的洁具服务已安排"
						+ masterName + "师傅，联系电话" + masterPhone
						+ "，请您在需要服务时提前和师傅联系预约上门时间，您有任何问题也可致电全国客户服务"
						+ "热线4006120122";

				log.info("预约失败！！！");
			}
			// 5更新工单状态
			int selective = tbWorkOrderMapper.updateByExampleSelective(
					workOrder, example);
			// TODO
			if (selective > 0) {
				log.info("更新工单状态成功！！！");
				Map<String, String> params = new HashMap<String, String>();
				params.put("mobile", phone);
				params.put("content", content);
				// 6执行发送操作
				log.info("正在执行短信发送操作！！！");
				//String post = HttpXmlClient.post(url, params);
				//log.info(post);
				reslut = 0;
				log.info("设置返回状态码为：" + reslut);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.info("发送失败");
		}
		log.info("最终返回状态码为：" + reslut);
		return reslut;
	}

	@Resource
	private WorkOrderDao workOrderDao;

	public BaseResponse findWorkOrder(String workNoOrcusTel, String masterId,
			Integer pagesize, Integer pageIndex,String version) {
		BaseResponse response = new BaseResponse();
		List<WorkOrder> result = null;
		String newestVersion = ResourcesUtil.getValue("config", "newestVersion");
		Double versionNow = Double.parseDouble(newestVersion);// 当前版本号
		Double versionPass=0.0;
		if(version == null || "".equals(version)){
			response.setInfo("当前版本较低,请更新版本！");
			response.setReturnCode(500);
		}else{
			 versionPass = Double.parseDouble(version);//传入版本号
		}
		if (versionPass >= versionNow) {
			try {

				if (workNoOrcusTel == "" || masterId == "") {
					response.setInfo(ReturnCode.NO_DATA);
					response.setReturnCode(ReturnCode.STATUS_403);
					result = new ArrayList<WorkOrder>();
					response.setData(result);
				}
				int rowStart = ((pageIndex - 1) * pagesize) + 1;
				int rowEnd = pageIndex * pagesize;
				result = workOrderDao.findWorkOrder(workNoOrcusTel, masterId,
						rowStart, rowEnd);
				response.setData(result);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo(ReturnCode.OK);
			} catch (Exception e) { // 异常处理

				e.printStackTrace();
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("获取信息异常！");
				result = new ArrayList<WorkOrder>();
				response.setData(result);
			}
		} else {
			response.setInfo("当前版本较低,请更新版本！");
			response.setReturnCode(500);
		}
		return response;		
	}

	@Override
	public boolean findWorkOrderByFid(String workorderid) {
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(workorderid);
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return true;
		}
		return false;
	}

	@Override
	public void updateAppraiseWorkOrder(String workorderid, Integer complete,
			Integer satisfaction1, Integer satisfaction2,
			Integer satisfaction3, Integer callback) {
		// TODO 校验
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(workorderid);
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			TbWorkOrder workOrder = list.get(0);
			workOrder.setEvalServiceComplete(new BigDecimal(complete));
			workOrder.setEvalPhoneBack(new BigDecimal(callback));
			workOrder.setSatisfaction1(new BigDecimal(satisfaction1));
			workOrder.setSatisfaction2(new BigDecimal(satisfaction2));
			workOrder.setSatisfaction3(new BigDecimal(satisfaction3));
			tbWorkOrderMapper.updateByExample(workOrder, example);
		}

	}

	@Override
	public void save(String workorderid, String address, Long time) {
		TbWorkOrderExt record = new TbWorkOrderExt();
		record.setAddress(address);
		record.setWorkOrderId(workorderid);
		record.setTime(new Date(time));
		tbWorkOrderExtMapper.insert(record);

	}

	@Override
	public MasterBadge getBadgeByMasterId(String masterId) throws Exception {
		return tbWorkOrderMapperCustom.getBadgeByMasterId(masterId);
	}

	@Override
	public List<BadgeRanking> findRankingList(String masterId) throws Exception {
		return tbWorkOrderMapperCustom.findRankingList(masterId);
	}

	@Override
	public PageBean getSatisfiedByOrder(SatisfiedByWokeOrderQuery query)
			throws Exception {

		// 1.获得总记录数
		int count = tbWorkOrderMapperCustom
				.calculateSatisfiedReportByOrderCount(query);
		// 2分页对象
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(count,
				query.getPageSize() == 0 ? 10 : query.getPageSize(),
				query.getCurrentPage() == 0 ? 1 : query.getCurrentPage());
		query.setPageQuery(pageQuery);
		// 3.数据列表
		List<SatisfiedByWokeOrderCustom> list = tbWorkOrderMapperCustom
				.calculateSatisfiedReportByOrderList(query);

		// 4.构造pageBean对象
		PageBean pageBean = new PageBean(query.getCurrentPage(),
				query.getPageSize() == 0 ? 10 : query.getPageSize(), list,
				count);
		return pageBean;
	}

	@Override
	public List<String> getProvince() {
		return tbWorkOrderMapperCustom.getProvince();
	}

	@Override
	public List<String> getOrganiza() {
		return tbWorkOrderMapperCustom.getOrganize();
	}

	@Override
	public PageBean getSatisfiedByMaster(SatisfiedByMasterQuery query)
			throws Exception {
		// 1.获得总记录数
		int count = tbWorkOrderMapperCustom
				.calculateSatisfiedByMasterCount(query);
		// 2分页对象
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(count,
				query.getPageSize() == 0 ? 10 : query.getPageSize(),
				query.getCurrentPage() == 0 ? 1 : query.getCurrentPage());
		query.setPageQuery(pageQuery);
		// 3.数据列表
		List<SatisfiedByMasterCustom> list = tbWorkOrderMapperCustom
				.calculateSatisfiedByMasterList(query);

		// 4.构造pageBean对象
		PageBean pageBean = new PageBean(query.getCurrentPage(),
				query.getPageSize(), list, count);
		return pageBean;
	}
	
	

	@Override
	public int updateWorkOrderStatusInfo(TbWorkOrder workOrder,
			TbWorkOrderBooking orderBooking,String date,String checkCode) throws Exception {

		TbWorkOrder order = new TbWorkOrder();
		if (workOrder != null && orderBooking != null) {
			// 工单预约状态
			Short status = orderBooking.getStatus();
			if (status == 0) {// 预约成功
				// 2生成验证码
				order.setCheckCode(checkCode);
				order.setStatusDisplay("待服务");
				order.setStatus(new BigDecimal(2));
				
				if (date.length() > 12) {
					if (date.split(":").length == 2) {
						date = date + ":00";
					}
				}
				order.setBookingTime(date.length()>12?DateUtil.string2date(date):null);
			} else {// 预约失败
				order.setCheckCode("");
				order.setStatusDisplay("预约失败");
				order.setStatus(new BigDecimal(1));
				order.setBookingTime(null);
			}
			TbWorkOrderExample example = new TbWorkOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andFidEqualTo(workOrder.getFid());
			
			//todo
			int selective = tbWorkOrderMapperCustom.updateByExampleSelective(
					order, example);
			if (selective > 0) {
				return 0;
			}
		}
		return -1;
	}

	/**
	 * 
	 * <p>description: 生成验证码</p>
	 * @return
	 * @date 2016年8月31日 下午2:47:19
	 */
	public int createCheckCode() {
		Random random = new Random();
		int checkCode = random.nextInt(9000) + 1000;
		return checkCode;
	}

	@Override
	public int sendBookMsg(TbWorkOrder order, String bookingTime,String status, String checkCode)
			throws Exception {
		// 短信发送地址
		String url = ResourcesUtil.getValue("config", "smsurl");
		int returnCode = -1;
		try {
			// 客户电话
			String phone = order.getCusTel();
			// 订单号码
			String orderSn = order.getOutOrderSn();
			// 技师名称
			String masterName = order.getMasterName();
			// 技师电话
			String masterPhone = order.getMasterPhone();
			// 预约时间
			String bookTime = bookingTime.length() > 10 ? bookingTime.substring(0, 10) : "";
			// 验证码
			//String checkCode = order.getCheckCode();

			String content = "";

			// 购买渠道 天猫/京东
			String shop = "华耐";
			if(orderSn!=null){
				if (orderSn.startsWith("tm")) {
					shop = "天猫";
				} else if (orderSn.startsWith("jd")) {
					shop = "京东";
				}
			}

			// 预约状态 0成功 1失败
			int msgStatus = Integer.parseInt(status);
			log.info("==================================================");
			log.info("==================================================");
			log.info("==================================================");
			log.info("======================预约状态" + status + "========================");
			log.info("==================================================");
			log.info("==================================================");
			if (msgStatus == 1) {// 预约失败
				// 4失败短信内容
				content = "尊敬的客户您好，您购买的订单编号" + orderSn + "洁具服务已安排"
						+ masterName + "师傅，联系电话" + masterPhone
						+ "，请您在需要服务时提前和师傅联系预约上门时间，您有任何问题也可致电全国客户服务"
						+ "热线4006120122";

			} else if (msgStatus == 0) {// 预约成功
				// 3成功短信内容
				content = "尊敬的客户您好，您购买的订单编号" + orderSn + "洁具服务已安排"
						+ masterName + "师傅，联系电话" + masterPhone + "，您已成功预约"
						+ bookTime.substring(0, 10) + "上门服务，请您提前做好时间安排，"
						+ "师傅上门签到时请出示给技师验证码" + checkCode + "，您有任何问题也可致电全国"
						+ "客户服务热线4006120122。";
			}
			if(!"".equals(content)){
				Map<String, String> params = new HashMap<String, String>();
				params.put("mobile", phone);
				params.put("content", content);
				//String post = HttpXmlClient.post(url, params);
				//log.info(post);
				returnCode = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnCode;
	}

	@Override
	public BaseResponse reSendSmsCode(String workorderid, String phone) {
		BaseResponse response = new BaseResponse();
		try {
			if (Util.isEmpty(workorderid, phone)) {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("电话号码不正确");
			} else {
				TbWorkOrder workorder = tbWorkOrderMapper
						.selectWorkOrderById(workorderid);
				if (workorder != null) {
					String checkCode = workorder.getCheckCode();
					if(!Util.isEmpty(checkCode)){
						//String content = "请您妥善保存服务确认码" + checkCode + ",并在服务完成后提供给师傅。";
						String content = checkCode;
						AliyunSMS.sendMsgToPhone(phone, "SMS_137421430", content);
					}else{
						response.setReturnCode(ReturnCode.STATUS_400);
						response.setInfo("请重新预约");
					}
				}else{
					response.setReturnCode(ReturnCode.STATUS_400);
					response.setInfo("工单信息异常");
				}
			}
		} catch (Exception e) {
			log.info("重发短信异常",e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("服务器异常");
		}
		return response;
	}

	@Override
	public int saveAppraise(TbWorkOrder tbWorkOrder, String workOrderId) throws Exception {
		try {
			TbWorkOrderExample example = new TbWorkOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andFidEqualTo(workOrderId);
			return tbWorkOrderMapper.updateByExampleSelective(tbWorkOrder, example);
		} catch (Exception e) {
			return 0;
		}
		
	}

	@Override
	public List<SatisfiedByWokeOrderCustom> getSatisfiedByOrderAll(SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery)
			throws Exception {
		satisfiedByWokeOrderQuery.setPageQuery(null);
		return tbWorkOrderMapperCustom.calculateSatisfiedReportByOrderList(satisfiedByWokeOrderQuery);
	}

	@Override
	public List<SatisfiedByMasterCustom> getSatisfiedByMasterAll(SatisfiedByMasterQuery satisfiedByMasterQuery)
			throws Exception {
		satisfiedByMasterQuery.setPageQuery(null);
		return tbWorkOrderMapperCustom.calculateSatisfiedByMasterList(satisfiedByMasterQuery);
	}

	@Override
	public boolean findWorkOrderAppraise(String workOrderId) throws Exception {
		TbWorkOrderExtExample example = new TbWorkOrderExtExample();
		com.easyhome.po.TbWorkOrderExtExample.Criteria criteria = example.createCriteria();
		criteria.andWorkOrderIdEqualTo(workOrderId);
		List<TbWorkOrderExt> list = tbWorkOrderExtMapper.selectByExample(example);
		
		if(list.size()>0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public PageBean findReminderWorkOrder(ReminderWorkOrderQuery query) throws Exception {
		// 1.总记录数
		int count = tbWorkOrderMapperCustom.findReminderWorkOrderCount(query);
		
		// 2分页对象
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(count,
				query.getPageSize() == 0 ? 10 : query.getPageSize(),
				query.getCurrentPage() == 0 ? 1 : query.getCurrentPage());
		query.setPageQuery(pageQuery);
		
		// 3.数据列表
		List<ReminderWorkOrder> orderList = tbWorkOrderMapperCustom.findReminderWorkOrderList(query);
		
		// 4.构造pageBean对象
		PageBean pageBean = new PageBean(query.getCurrentPage(),
				query.getPageSize(), orderList, count);
		log.info("成功调用催单服务");
		return pageBean;
	}

	@Override
	public TbWorkOrder getOneWorkOrder(String workOrderId) throws Exception {
		TbWorkOrderExample example = new TbWorkOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andFidEqualTo(workOrderId);
		List<TbWorkOrder> list = tbWorkOrderMapper.selectByExample(example);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int saveTbMasterSign(TbMasterSign sign) throws Exception{
		return tbMasterSignMapper.insertSelective(sign);
	}

	@Override
	public int updateWorkOrder(TbWorkOrder workOrder, TbWorkOrderExample example) {
		return tbWorkOrderMapper.updateByExampleSelective(workOrder, example);
	}

	@Override
	public Map<String, Object> signService(
			String workorderid, 
			String signerid, 
			String type, 
			String signer, 
			String lat,
			String lng, 
			String code, 
			String address) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		//判断是否传值
		if(!"".equals(workorderid) || !"".equals(signerid)){
			try {
				TbWorkOrder workOrder = this.getOneWorkOrder(workorderid);
				if(workOrder!=null){
					log.info("成功获取工单"+workOrder);
					//保存签到信息
					TbMasterSign sign = new TbMasterSign();
					sign.setAddress(address);
					sign.setCode(code);
					sign.setFid(UUID.randomUUID().toString());
					sign.setLat(lat);
					sign.setLng(lng);
					sign.setSigner(signer);
					sign.setSignerId(signerid);
					sign.setSignTime(new Date());
					sign.setType(type);
					sign.setWorkOrderId(workorderid);
					int signCode = this.saveTbMasterSign(sign);
					if(signCode>0){
						log.info("签到成功");
						//更新工单状态
						TbWorkOrder t = new TbWorkOrder();
						TbWorkOrderExample example = new TbWorkOrderExample();
						Criteria criteria = example.createCriteria();
						criteria.andFidEqualTo(workorderid);
						t.setStatus(new BigDecimal(3));
						t.setStatusDisplay("服务中");
						t.setSingTime(new Date());
						int updateWorkOrder = this.updateWorkOrder(t, example);
						if(updateWorkOrder>0){
							log.info("更新工单状态成功...");
							map.put("errCode", 0);
							map.put("errMsg", "签到成功！");
							map.put("result", "");
						}
					}else{
						log.info("签到失败");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				map.put("errCode", -1);
				map.put("errMsg", e.getMessage());
				map.put("result", "");
			}
		}
		return map;
	}

	@Override
	public String partlyCompleted(String data) throws Exception {
		BaseResponse br = new BaseResponse();
		//1.解析data数据
		Gson gson = new Gson();
		try {
			//WorkOrderPartlyCompletedRequest wopcr = gson.fromJson(data, WorkOrderPartlyCompletedRequest.class);
			String result = OmsConnectUtil.getData("appFinishReport", data);
//			Map<String,Object> params = new HashMap<String, Object>();
//			params.put("data",data);
//			String result = OmsConnectUtil.getData("appFinishReport", params);
			
			log.info(result);
			String replace = result.replace("errCode", "returnCode").replace("errMsg", "info");
			log.info(replace);
			return replace;
		} catch (Exception e) {
			e.printStackTrace();
			br.setReturnCode(500);
			br.setInfo("解析失败");
		}
		return gson.toJson(br);
	}

	@Override
	public void sendSginMsg(String workorderid) throws Exception {
		try {
			
			//获取工单信息
			TbWorkOrder workOrder = this.getOneWorkOrder(workorderid);
			if(workOrder!=null){
				if(!"".equals(workOrder.getMasterPhone()) 
						&& workOrder.getMasterPhone() !=null 
						&& ((!"".equals(workOrder.getOutOrderSn()) && workOrder.getOutOrderSn()!=null) 
								|| (!"".equals(workOrder.getIsTmallOrder()) && workOrder.getIsTmallOrder()!=null))
						){//天猫订单
					
						//为天猫订单发送短信
					    if(workOrder.getOutOrderSn().startsWith("tm") || workOrder.getIsTmallOrder() == new BigDecimal(1)){
						String orderSn = workOrder.getOutOrderSn();
						
						if(orderSn!=null &&!"".equals(orderSn) && orderSn.startsWith("tm")){
							int index = orderSn.indexOf(".");
							orderSn = orderSn.substring(index+1);
							
							//短信发送地址
							String url = Util.getProperty("smsurl");
							Map<String, String> params = new HashMap<String, String>();
							params.put("mobile", workOrder.getMasterPhone());
							params.put("content", "工单号："+workOrder.getWorkNo()+",商品订单号："+orderSn+",客户电话:"+workOrder.getCusTel()+","
									+ "当无法获取核销码时，请使用订单号进行核销。");
							//String post = HttpXmlClient.post(url, params);
							String post = null;
							log.info("短信提交成功，返回码：" + post);
						}
					}
					log.info("订单来源不是天猫");
				}
			}else{
				log.info("订单不存在");
			}
		} catch (Exception e) {
			log.info("短信提交失败");
			e.printStackTrace();
		}
	}

	@Override
	public String findCheckCode(String workNo) {
		try {
			List<String> list = tbWorkOrderMapperCustom.findCheckCodeByWorkNo(workNo);
			if(list!=null && list.size()==1){
				return list.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BaseResponse batchUpdateWorkStatus(List<String> workOrderNos,int status) {
		BaseResponse response = new BaseResponse();
		try{
			String forDisplay = forDisplay(status);
			if(forDisplay.length()==0){
				response.setReturnCode(ReturnCode.STATUS_500);
				response.setInfo("工单状态不存在");
				return response;
			}
			int batchUpdateWorkOrder = tbWorkOrderMapper.batchUpdateWorkOrder(workOrderNos, status,forDisplay );
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo("工单状态更新成功");
			response.setData(batchUpdateWorkOrder);
			return response;
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("工单状态更新失败");
			log.info("工单状态更新失败"+e);
			return response;
		}
	}

	private String forDisplay(int status) {
		String display="";
		switch (status) {
		case -1:
			display=WorkOrderStatusConstants.STATUS__1_DISPLAY;
			break;
		case 0:
			display=WorkOrderStatusConstants.STATUS_0_DISPLAY;
			break;
		case 1:
			display=WorkOrderStatusConstants.STATUS_1_DISPLAY;
			break;
		case 2:
			display=WorkOrderStatusConstants.STATUS_2_DISPLAY;
			break;
		case 3:
			display=WorkOrderStatusConstants.STATUS_3_DISPLAY;
			break;
		case 4:
			display=WorkOrderStatusConstants.STATUS_4_DISPLAY;
			break;
		case 5:
			display=WorkOrderStatusConstants.STATUS_5_DISPLAY;
			break;
		case 6:
			display=WorkOrderStatusConstants.STATUS_6_DISPLAY;
			break;
		case 7:
			display=WorkOrderStatusConstants.STATUS_7_DISPLAY;
			break;
			
		case 8:
			display=WorkOrderStatusConstants.STATUS_8_DISPLAY;
			break;
		default:
			break;
		}
		return display;
	}
	
	@Override
	public String getPrivacyNumber(String data) throws Exception {
		BaseResponse br = new BaseResponse();
		//1.解析data数据
		Gson gson = new Gson();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workorderid", data);			
		String dataJson = gson.toJson(params);
		try {
			String result = OmsConnectUtil.getData("getPrivacyNumber", dataJson);
			log.info(result);
			String replace = result.replace("errCode", "returnCode").replace("errMsg", "info");
			log.info(replace);
			return replace;
		} catch (Exception e) {
			e.printStackTrace();
			br.setReturnCode(500);
			br.setInfo("解析失败");
		}
		return gson.toJson(br);
	}
}

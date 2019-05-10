package com.easyhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.OrderDateQueryService;
import com.easyhome.service.WorkOrderService;
import com.easyhome.service.impl.WorkOrderServiceImpl;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.ReminderWorkOrderQuery;

@Controller
@RequestMapping("/workOrder")
public class WorkOrderController {
	
	Log log = LogFactory.getLog(WorkOrderServiceImpl.class);
	
	@Resource
	private WorkOrderService workOrderService;
	
	@RequestMapping(value={"/searchWorkOrder"})
	@ResponseBody
	public BaseResponse findWork_order(String searchWords,String masterid,Integer pagesize,Integer pageIndex,String version){
		BaseResponse response=workOrderService.findWorkOrder(searchWords, masterid,pagesize,pageIndex,version);
		return response;
	}

	/**
	 * 
	 * <p> Description: 获取催单列表</p>
	 * 
	 * @date 2016年6月3日 下午6:07:45
	 * @version 1.0
	 * @param query
	 * @return
	 */
	@RequestMapping(value={"/reminderList"})
	@ResponseBody
	public BaseResponse reminderList(ReminderWorkOrderQuery query){
		BaseResponse br = new BaseResponse();
		try {
			br.setInfo("获取成功");
			br.setReturnCode(ReturnCode.STATUS_200);
			br.setData(workOrderService.findReminderWorkOrder(query));
			log.info("催单接口调用成功");
		} catch (Exception e) {
			br.setInfo("获取失败");
			br.setReturnCode(ReturnCode.STATUS_500);
			log.info("催单接口调用失败",e);
		}
		return br;
	}
	
	/**
	 * 
	 * <p> Description: 完工汇报，上传图片</p>
	 * 
	 * @date 2016年6月18日 上午11:10:07
	 * @version 1.0
	 * @param workorderid
	 * @param masterid
	 * @param mastername
	 * @param remark
	 * @param workorderitemid
	 * @param phone
	 * @param name
	 * @param address
	 * @param image
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/addCompleteInfo"},method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse addCompleteInfo(@RequestParam(defaultValue = "") String workorderid,
			@RequestParam(defaultValue = "") String masterid, @RequestParam(defaultValue = "") String mastername,
			@RequestParam(defaultValue = "") String remark, @RequestParam(defaultValue = "") String workorderitemid,
			@RequestParam(defaultValue = "") String phone, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") String address, @RequestParam(defaultValue = "") String image,
			HttpServletRequest request) {
		log.info("workorderid:"+workorderid);
		log.info("masterid:"+masterid);
		log.info("mastername:"+mastername);
		log.info("remark:"+remark);
		log.info("workorderitemid:"+workorderitemid);
		log.info("phone:"+phone);
		log.info("name:"+name);
		log.info("address:"+address);
		log.info("image:"+image);
		
		BaseResponse br = new BaseResponse();
		String[] split = image.split("|");
		for (int i =0;i<split.length;i++) {
			String path = request.getSession().getServletContext().getRealPath("/view/upload/"+i);
		}
		try {
			br.setReturnCode(200);
			br.setInfo("工单状态变更完毕");
			br.setData("SUCCESS");
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
		}
		return br;
	}
	
	/**
	 * 
	 * <p> Description: 上门签到接口</p>
	 * 
	 * @date 2016年6月23日 下午3:19:24
	 * @version 1.0
	 * @param workorderid
	 * @param signerid
	 * @param type
	 * @param signer
	 * @param lat
	 * @param lng
	 * @param code
	 * @param address
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/sign")
	@ResponseBody
	public Map<String, Object> signService(
			@RequestParam(defaultValue="") String workorderid,//工单号
			@RequestParam(defaultValue="") String signerid, //签到人id/技师id
			@RequestParam(defaultValue="") String type,//签到类型
			@RequestParam(defaultValue="") String signer, //签到人
			@RequestParam(defaultValue="") String lat, //精度
			@RequestParam(defaultValue="") String lng, //维度
			@RequestParam(defaultValue="") String code, //签到码
			@RequestParam(defaultValue="") String address //签到地址
			) throws Exception{
		log.info("workorderid:"+workorderid);
		log.info("signerid:"+signerid);
		log.info("type:"+type);
		log.info("signer:"+signer);
		log.info("lat:"+lat);
		log.info("lng:"+lng);
		log.info("code:"+code);
		log.info("address:"+address);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			map = workOrderService.signService(workorderid, signerid, type, signer, lat, lng, code, address);
			Integer errCode = (Integer) map.get("errCode");
			if(errCode==0){//发送短信
				workOrderService.sendSginMsg(workorderid);
			}
		} catch (Exception e) {
			map.put("errCode", -1);
			map.put("errMsg", e.getMessage());
			map.put("result", "");
		}
		
		return map;
	}
	
	/**
	 * 
	 * <p>description: 查找验证码</p>
	 * @param workNo
	 * @return
	 * @date 2016年7月27日 下午8:50:05
	 */
	@RequestMapping("/findCheckCode")
	@ResponseBody
	public String findCheckCode(@RequestParam(defaultValue="") String workNo) throws Exception{
		return workOrderService.findCheckCode(workNo);
	}
	
	/**
	 * 
	 * <p>description: 批量更新工单状态</p>
	 * @param workNos
	 * @param status
	 * @return
	 * @date 2016年11月1日 下午3:50:05
	 */
	@RequestMapping("/batchUpdateWorkOrder")
	@ResponseBody
	public BaseResponse batchUpdateWorkOrder(@RequestParam(defaultValue="") List<String> workNos,@RequestParam(defaultValue="-2")int status) throws Exception{
		return workOrderService.batchUpdateWorkStatus(workNos,status);
	}
	
	/**
     * 工单日历
     */
	@Resource
	private OrderDateQueryService orderDateQueryService;

	@RequestMapping(value = "/month", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse orderDateQueryByMonth(String masterId, String bymonth) {
		BaseResponse response = orderDateQueryService.findWorkOrderListByMonth(masterId, bymonth);
		return response;
	}
        
	@RequestMapping(value = "/day", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse orderDateQueryByDay(String masterId, String byday, String version) {
		BaseResponse response = orderDateQueryService.findWorkOrderListByDay(masterId, byday, version);
		return response;
	}
	
}

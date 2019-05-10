package com.easyhome.service;

import java.util.List;
import java.util.Map;

import com.easyhome.po.TbMasterSign;
import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.po.TbWorkOrderExample;
import com.easyhome.vo.BadgeRanking;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.MasterBadge;
import com.easyhome.vo.PageBean;
import com.easyhome.vo.ReminderWorkOrderQuery;
import com.easyhome.vo.SatisfiedByMasterCustom;
import com.easyhome.vo.SatisfiedByMasterQuery;
import com.easyhome.vo.SatisfiedByWokeOrderCustom;
import com.easyhome.vo.SatisfiedByWokeOrderQuery;

/**
 * 
 * <p>
 * Title: TbWorkOrderBookingService
 * </p>
 * <p>
 * Description: 工单预定服务接口
 * </p>
 * 
 * @date 2016年5月11日 下午2:15:19
 * @version 1.0
 *
 */
public interface WorkOrderService {

	/**
	 * 
	 * <p>
	 * Description: 保存预约工单
	 * </p>
	 * 
	 * @date 2016年5月11日 下午2:39:41
	 * @version 1.0
	 * @param workorderid
	 * @param linkman
	 * @param address
	 * @param phone
	 * @param status
	 * @param reason
	 * @param date
	 * @param call
	 * @return
	 * @throws Exception
	 */
	public TbWorkOrderBooking saveOrderBooking(String workorderid,
			String linkman, String address, String phone, String status,
			String reason, String date, String call) throws Exception;

	/**
	 * 
	 * <p>
	 * Description: 通过工单号查询工单信息
	 * </p>
	 * 
	 * @date 2016年5月11日 下午2:57:58
	 * @version 1.0
	 * @param fid
	 * @return
	 * @throws Exception
	 */
	public TbWorkOrder getBookOrderingByFId(String fid) throws Exception;

	/**
	 * 
	 * <p>
	 * Description: 发送短信信息
	 * </p>
	 * 
	 * @date 2016年5月11日 下午3:51:33
	 * @version 1.0
	 * @param
	 * @return
	 */
	@Deprecated
	public int sendBookInfoMsg(TbWorkOrder workOrder,
			TbWorkOrderBooking orderBooking) throws Exception;

	BaseResponse findWorkOrder(String workNoOrcusTel, String masterId,
			Integer pagesize, Integer pageIndex,String version);

	/**
	 * 
	 * <p> Description: 通过fid查找WorkOrder</p>
	 * 
	 * @date 2016年5月18日 下午3:00:38
	 * @version 1.0
	 * @param workorderid
	 * @return
	 */
	public boolean findWorkOrderByFid(String workorderid);

	/**
	 * 
	 * <p> Description: 更新工单评价信息</p>
	 * 
	 * @date 2016年5月18日 下午3:50:39
	 * @version 1.0
	 * @param workorderid
	 * @param complete
	 * @param satisfaction1
	 * @param satisfaction2
	 * @param satisfaction3
	 * @param callback
	 */
	public void updateAppraiseWorkOrder(String workorderid, Integer complete, Integer satisfaction1,
			Integer satisfaction2, Integer satisfaction3, Integer callback);

	/**
	 * 
	 * <p> Description: 保存二维码信息</p>
	 * 
	 * @date 2016年5月18日 下午4:17:12
	 * @version 1.0
	 * @param workorderid
	 * @param address
	 * @param time
	 */
	public void save(String workorderid, String address, Long time);
	
	
	/**
	 * 
	 * <p> Description: 获取技师的徽章详情</p>
	 * 
	 * @date 2016年5月23日 下午3:35:10
	 * @version 1.0
	 * @param masterId
	 * @return
	 */
	public MasterBadge getBadgeByMasterId(String masterId) throws Exception;
	
	/**
	 * 
	 * <p> Description: 查询徽章排行榜</p>
	 * 
	 * @date 2016年5月23日 下午5:16:26
	 * @version 1.0
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	public List<BadgeRanking> findRankingList(String masterId) throws Exception;
	
	/**
	 * 
	 * <p> Description: 查询以工单为维度的满意度报表</p>
	 * 
	 * @date 2016年5月26日 下午2:03:41
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 * @throws Exception
	 */
	public PageBean getSatisfiedByOrder(SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery) throws Exception;
	
	/**
	 * 
	 * <p> Description: 获取省份列表</p>
	 * 
	 * @date 2016年5月27日 下午1:39:43
	 * @version 1.0
	 * @return
	 */
	public List<String> getProvince();
	
	/**
	 * 
	 * <p> Description: 获取调度平台列表</p>
	 * 
	 * @date 2016年5月27日 下午1:39:58
	 * @version 1.0
	 * @return
	 */
	public List<String> getOrganiza();
	
	/**
	 * 
	 * <p> Description: 获取技师的满意度</p>
	 * 
	 * @date 2016年5月27日 下午4:33:15
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 * @throws Exception
	 */
	public PageBean getSatisfiedByMaster(SatisfiedByMasterQuery satisfiedByMasterQuery) throws Exception;

	/**
	 * 
	 * <p> Description: 更新工单状态</p>
	 * 
	 * @date 2016年5月28日 下午2:01:48
	 * @version 1.0
	 * @param workOrder
	 * @param orderBooking
	 * @return
	 */
	public int updateWorkOrderStatusInfo(TbWorkOrder workOrder, TbWorkOrderBooking orderBooking,String date,String checkCode) throws Exception;

	/**
	 * 
	 * <p> Description: 发送短信</p>
	 * 
	 * @date 2016年5月28日 下午2:19:48
	 * @version 1.0
	 * @param order
	 * @param bookingTime
	 * @param status 
	 * @param checkCode 
	 * @return
	 * @throws Exception
	 */
	public int sendBookMsg(TbWorkOrder order, String bookingTime, String status, String checkCode) throws Exception;
	
	public BaseResponse reSendSmsCode(String workorderid,String phone);
	
	/**
	 * 
	 * <p> Description: 根据工单ID也就是工单表中的fid更新数据</p>
	 * 
	 * @date 2016年5月30日 下午5:02:27
	 * @version 1.0
	 * @param tbWorkOrder 工单中部分字段信息
	 * @param workOrderId 工单的FID
	 * @return
	 * @throws Exception
	 */
	public int saveAppraise(TbWorkOrder tbWorkOrder,String workOrderId) throws Exception;

	/**
	 * 
	 * <p> Description: 查询工单满意度报表,全体</p>
	 * 
	 * @date 2016年5月31日 上午10:46:04
	 * @version 1.0
	 * @param satisfiedByWokeOrderQuery
	 * @return
	 * @throws Exception
	 */
	public List<SatisfiedByWokeOrderCustom> getSatisfiedByOrderAll(SatisfiedByWokeOrderQuery satisfiedByWokeOrderQuery) throws Exception;

	/**
	 * 
	 * <p> Description: 查询技师满意度报表,全体</p>
	 * 
	 * @date 2016年5月31日 上午10:53:38
	 * @version 1.0
	 * @param satisfiedByMasterQuery
	 * @return
	 * @throws Exception
	 */
	public List<SatisfiedByMasterCustom> getSatisfiedByMasterAll(SatisfiedByMasterQuery satisfiedByMasterQuery) throws Exception;

	/**
	 * 
	 * <p> Description: 通过工单id查询工单是否评价</p>
	 * 
	 * @date 2016年6月1日 下午2:04:25
	 * @version 1.0
	 * @param workOrderId
	 * @return
	 * @throws Exception
	 */
	public boolean findWorkOrderAppraise(String workOrderId) throws Exception;
	
	/**
	 * 
	 * <p> Description: 催单列表</p>
	 * 
	 * @date 2016年6月3日 下午5:53:05
	 * @version 1.0
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public PageBean findReminderWorkOrder(ReminderWorkOrderQuery query) throws Exception;

	/**
	 * 
	 * <p> Description: 查找一条工单</p>
	 * 
	 * @date 2016年6月15日 下午4:03:52
	 * @version 1.0
	 * @param workOrderId
	 * @return
	 */
	public TbWorkOrder getOneWorkOrder(String workOrderId) throws Exception;

	/**
	 * 
	 * <p> Description: 保存签到信息</p>
	 * 
	 * @date 2016年6月23日 下午3:46:11
	 * @version 1.0
	 * @param sign
	 * @return
	 * @throws Exception
	 */
	public int saveTbMasterSign(TbMasterSign sign) throws Exception;

	/**
	 * 
	 * <p> Description: 更新工单</p>
	 * 
	 * @date 2016年6月23日 下午4:00:26
	 * @version 1.0
	 * @param workOrder
	 * @param example
	 * @return
	 */
	public int updateWorkOrder(TbWorkOrder workOrder, TbWorkOrderExample example);

	/**
	 * 
	 * <p> Description: 保存签到信息</p>
	 * 
	 * @date 2016年6月23日 下午4:12:25
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
	 */
	public Map<String, Object> signService(
			String workorderid, 
			String signerid, 
			String type, 
			String signer, 
			String lat,
			String lng, 
			String code, 
			String address) throws Exception;

	/**
	 * 
	 * <p> Description: 部分完工汇报</p>
	 * 
	 * @date 2016年6月23日 下午5:07:04
	 * @version 1.0
	 * @param data
	 * @return
	 */
	public String partlyCompleted(String data) throws Exception;

	/**
	 * 
	 * <p> Description: 发送签到短信</p>
	 * 
	 * @date 2016年6月24日 上午11:05:48
	 * @version 1.0
	 * @param workorderid
	 */
	public void sendSginMsg(String workorderid) throws Exception;

	/**
	 * 
	 * <p>description: 查找验证码</p>
	 * @param workNo
	 * @return
	 * @date 2016年7月27日 下午8:51:37
	 */
	public String findCheckCode(String workNo);

	/**
	 * 
	 * <p>description: 生成验证码</p>
	 * @return
	 * @date 2016年8月31日 下午2:48:02
	 */
	public int createCheckCode();
	/**
	 * 
	 * <p>description: 更新工单状态</p>
	 * @return
	 * @date 2016年11月1日 下午2:48:02
	 */
	public BaseResponse batchUpdateWorkStatus(List<String> workOrderNos,int status);
	
	public String getPrivacyNumber(String data) throws Exception;
	
	
}

package com.easyhome.service.tms;

/**
 * 
 * <p>title: AppServiceI</p>
 * <p>description: APP服务接口-工人</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月27日 下午5:37:53
 */
public interface AppServiceI {

	/**
	 * 
	 * <p>description: 工单列表</p>
	 * @param status
	 * @param workId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @throws Exception
	 * @date 2016年7月27日 下午7:18:27
	 */
	String workOrderList(int status, String workId, int pageSize, int currentPage) throws Exception;
	
	
	/**
	 * 
	 * <p>description: 工单详情</p>
	 * @param workOrderId
	 * @param workOrderOwnnerId
	 * @return
	 * @date 2016年7月27日 下午7:14:52
	 */
	String getWorkOrderDetail(String workOrderId, String workOrderOwnnerId) throws Exception;


	/**
	 * 
	 * <p>description: 工人预约</p>
	 * @param omsMasterId
	 * @param workorderid
	 * @param linkman
	 * @param address
	 * @param phone
	 * @param status
	 * @param reason
	 * @param date
	 * @param call
	 * @return
	 * @date 2016年7月27日 下午7:29:01
	 */
	String saveBooking(String workId,String omsMasterId, String workorderid, String linkman, String address, String phone, int status,
			String reason, String date, String call) throws Exception;


	/**
	 * 
	 * <p>description: 工人签到</p>
	 * @param omsMasterId
	 * @param workorderid
	 * @param signerid
	 * @param signer
	 * @param type
	 * @param lat
	 * @param lng
	 * @param code
	 * @param address
	 * @param phone
	 * @return
	 * @date 2016年7月27日 下午7:33:21
	 */
	String saveSign(String workId,String omsMasterId, String workorderid, String signerid, String signer, String type, String lat,
			String lng, String code, String address, String phone) throws Exception;

	/**
	 * 
	 * <p>description: 工人完工汇报</p>
	 * @param data
	 * @param workId
	 * @param workorderid
	 * @return
	 * @date 2016年7月27日 下午7:39:29
	 */
	String saveCompelete(String data, String workId, String workorderid) throws Exception;


	/**
	 * 
	 * <p>description: 工单列表</p>
	 * @param searchWords
	 * @param omsMasterId
	 * @param pageIndex
	 * @param pagesize
	 * @return
	 * @date 2016年7月27日 下午8:08:50
	 */
	String searchWorkOrder(String searchWords, String omsMasterId, String workId,Integer pageIndex, Integer pagesize) throws Exception;

	

}

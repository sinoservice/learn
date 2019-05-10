package com.easyhome.service.tms;

import com.easyhome.vo.tms.RequestModel;

/**
 * 
 * <p>标题: TmsAppServiceI</p>
 * <p>描述: tmsapp服务接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年11月10日 下午4:00:07</p>
 * <p>版本: 1.0</p>
 */
public interface TmsAppServiceI {

	/**
	 * 
	 * <p>description: 检查App版本更新</p>
	 * @return
	 * @date 2016年11月10日 下午4:03:15
	 */
	String checkAppVersion() throws Exception;

	/**
	 * 
	* @Title: downloadApp 
	* @Description: TODO 下载app
	* @param  @return
	* @param  @throws Exception 
	* @return BaseResponse    
	* @throws 
	* @date 2016年11月16日 下午3:52:48
	 */
	String downloadApp() throws Exception;

	//1.登录
	String login(String driverPhone,String password) throws Exception;
	
	//2.发送短信验证码
	String appSendVerificateCode(String driverPhone) throws Exception;
	

	//3.忘记密码
	String appForgetPassword(String driverPhone,String verificateCode,String newPassword)throws Exception;
	
	//4.最近发货发车列表
	String appGetRecentDispatchOrder(String driverCode,String driverPhone,int pageindex,int pagesize)
    throws Exception;
	
	//5.统计各类订单/运单数量
	String appGetMyDeliveryCensus(String driverCode,String driverPhone) throws Exception;

	//6.运单列表
	String appGetDispatchList(String driverCode,String driverPhone,String dispatchOrderNO,
			String isReservedSuccess,int pageindex,int pagesize ) throws Exception;

	//7.订单列表
	String appGetOrderList(String driverCode,String driverPhone,String dispatchOrderNo,String orderStatus) throws Exception;
	

	//8.订单详情
	String appGetOrderDetail(String driverCode,String driverPhone,String dispatchOrderNo,String orderId) throws Exception;
	
	//9.司机预约
	String appDispatchAppointTime(String orderId,String dispatchOrderNo,String driverCode,String reserveStatus,
			String reserveOpeName,String reserveTime,String reserveTimeDuring,String failReasonCode,String reserveRemark) throws Exception;
	
	//10.发车单是否继续配送
	String appContinueToDelivery(String dispatchOrderNo,String continueFlag,String driverCode,String driverPhone,
			String operateRemark) throws Exception; 

	//11.到车确认/发车确认接口
	String appUpdateDispatchStatus(String dispatchOrderNo,String operateType,String driverCode,String driverPhone,
			String operateRemark) throws Exception;
	
	//12.查询待签收/已签收/异常签收的订单列表接口
	String appGetDispatchReceipt(String driverCode,String driverPhone,String receiptType,int pageindex,
			int pagesize) throws Exception;

	//13.订单签收/整单拒收/部分签收
	String appOrderSign(String requestJson) throws Exception;

	//14.签收/异常签收详情
	String appGetReceiptDetail(String driverCode,String driverPhone,String receiptOrderId) throws Exception;
	
	//15.数据字典接口
	String appGetDataDictionary(String dataType) throws Exception;
	
	//16.发车单下订单统计
	String appDispatchOrderCount(String dispatchOrderNo, String driverCode) throws Exception;
	
	//17.测试图片存储质量
	String testImgQuality(String img) throws Exception;

	/**
	 * 获取技师的预警总数
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	String getCountByMaster(String masterId,String version) throws Exception;

	/**
	 * 获取预警记录列表
	 * @param masterId
	 * @param type
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	String queryWarnningRecord(String masterId, String type, int startIndex, int pageSize,String version) throws Exception;

	/**
	 * 
	* @Title: operateLogService 
	* @Description: TODO  日志记录接口
	* @param  @param model
	* @param  @param body
	* @param  @return 
	* @return String    
	* @throws 
	* @date 2016年12月12日 下午2:28:38
	 */
	String saveLogs(RequestModel model);
	
	/**
	 * 预警提示
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	String queryWarnningNotice(String masterId) throws Exception;

	/**
	 * 解除预警
	 * @param masterId
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	String warnningRemove(String masterId, String flag) throws Exception;
}

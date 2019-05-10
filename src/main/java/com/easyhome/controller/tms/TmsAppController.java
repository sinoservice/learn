package com.easyhome.controller.tms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.tms.TmsAppServiceI;

/**
 * 
 * <p>标题: TmsAppController</p>
 * <p>描述: 移动tms视图控制器</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年11月10日 下午3:43:54</p>
 * <p>版本: 1.0</p>
 */
@Controller
@RequestMapping("/tmsApp")
public class TmsAppController {
	
	@Autowired
	private TmsAppServiceI tmsAppService;
	
	/**
	 * 
	 * <p>description: 检查更新接口</p>
	 * @return
	 * @date 2016年11月10日 下午4:15:57
	 * @throws Exception 
	 */
	@RequestMapping(value="/checkAppVersion",method=RequestMethod.POST)
	@ResponseBody
	public String checkAppVersion() throws Exception{
		return tmsAppService.checkAppVersion();
	}
	
	/**
	 * 
	 * <p>description: 下载app</p>
	 * @return
	 * @date 2016年11月10日 下午4:43:10
	 * @throws Exception 
	 */
	@RequestMapping("/downloadApp")
	@ResponseBody
	public String downloadApp() throws Exception{
		return tmsAppService.downloadApp();
	}
	
	/**
	 * 
	* @Title: loginApp 
	* @Description: TODO 登录
	* @param  @param driverPhone
	* @param  @param password
	* @param  @return
	* @param  @throws Exception 
	* @return BaseResponse    
	* @throws 
	* @date 2016年11月17日 上午11:51:43
	 */
	@RequestMapping("/loginApp")
	@ResponseBody
	public String loginApp(String driverPhone,String password) throws Exception{
		return tmsAppService.login(driverPhone, password);
	}
//====================
	
	//发送验证码
	@RequestMapping("/appSendVerificateCode")
	@ResponseBody
	public String appSendVerificateCode(String driverPhone) throws Exception{
		return tmsAppService.appSendVerificateCode(driverPhone);
	}
	

	//忘记密码
	@RequestMapping("/appForgetPassword")
	@ResponseBody
	public String appForgetPassword(String driverPhone, String verificateCode, String newPassword
			) throws Exception{
		return tmsAppService.appForgetPassword(driverPhone, verificateCode, newPassword);
	}

	//最近发货发车列表
	@RequestMapping("/appGetRecentDispatchOrder")
	@ResponseBody
	public String appGetRecentDispatchOrder(String driverCode, String driverPhone, int pageindex, int pagesize) throws Exception{
		return tmsAppService.appGetRecentDispatchOrder(driverCode, driverPhone, pageindex, pagesize);
	}
	
	//统计各类订单/运单数量
	@RequestMapping("/appGetMyDeliveryCensus")
	@ResponseBody
	public String appGetMyDeliveryCensus(String driverCode, String driverPhone) throws Exception{
		return tmsAppService.appGetMyDeliveryCensus(driverCode, driverPhone);
	}
	

	//运单列表
	@RequestMapping("/appGetDispatchList")
	@ResponseBody
	public String appGetDispatchList(String driverCode, String driverPhone, String dispatchOrderNO,
			String isReservedSuccess, int pageindex, int pagesize) throws Exception{
		return tmsAppService.appGetDispatchList(driverCode, driverPhone, dispatchOrderNO, isReservedSuccess, pageindex, pagesize);
	}
	
	//订单列表
	@RequestMapping("/appGetOrderList")
	@ResponseBody
	public String appGetOrderList(String driverCode,String driverPhone,String dispatchOrderNo,
			String orderStatus) throws Exception{
		return tmsAppService.appGetOrderList(driverCode, driverPhone, dispatchOrderNo, orderStatus);
	}

	//查询待签收/已签收/异常签收的订单列表
	@RequestMapping("/appGetDispatchReceipt")
	@ResponseBody
	public String appGetDispatchReceipt(String driverCode, String driverPhone, String receiptType, int pageindex,int pagesize) throws Exception {
		return tmsAppService.appGetDispatchReceipt(driverCode, driverPhone, receiptType, pageindex, pagesize);
	}
	
	//订单详情
	@RequestMapping("/appGetOrderDetail")
	@ResponseBody
	public String appGetOrderDetail(String driverCode, String driverPhone, String dispatchOrderNo, String orderId)
			throws Exception {
		return tmsAppService.appGetOrderDetail(driverCode, driverPhone, dispatchOrderNo, orderId);
	}
	

	//司机预约
	@RequestMapping("/appDispatchAppointTime")
	@ResponseBody
	public String appDispatchAppointTime(String orderId, String dispatchOrderNo, String driverCode,
	String reserveStatus, String reserveOpeName, String reserveTime,String reserveTimeDuring, String failReasonCode,
	String reserveRemark) throws Exception {
		return tmsAppService.appDispatchAppointTime(orderId, dispatchOrderNo, driverCode, reserveStatus, reserveOpeName, reserveTime, reserveTimeDuring, failReasonCode, reserveRemark);
	}

	//发车单是否继续配送
	@RequestMapping("/appContinueToDelivery")
	@ResponseBody
	public String appContinueToDelivery(String dispatchOrderNo,String continueFlag,String driverCode,String driverPhone,
			String operateRemark) throws Exception{
		return tmsAppService.appContinueToDelivery(dispatchOrderNo, continueFlag, driverCode, driverPhone, operateRemark);
	}

	// 到车确认/发车确认
	@RequestMapping("/appUpdateDispatchStatus")
	@ResponseBody
	public String appUpdateDispatchStatus(String dispatchOrderNo, String operateType, String driverCode,
		String driverPhone, String operateRemark) throws Exception {
		return tmsAppService.appUpdateDispatchStatus(dispatchOrderNo, operateType, driverCode, driverPhone,operateRemark);
	}
	
	// 签收/异常签收详情
	@RequestMapping("/appGetReceiptDetail")
	@ResponseBody
	public String appGetReceiptDetail(String driverCode, String driverPhone, String receiptOrderId)
			throws Exception {
		return tmsAppService.appGetReceiptDetail(driverCode, driverPhone, receiptOrderId);
	}

	// 订单签收/整单拒收/部分签收
	@RequestMapping("/appOrderSign")
	@ResponseBody
	public String appOrderSign(String requestJson) throws Exception {
		return tmsAppService.appOrderSign(requestJson);
	}
	
	//数据字典
	@RequestMapping("/appGetDataDictionary")
	@ResponseBody
	public String appGetDataDictionary(String dataType) throws Exception{
	    return tmsAppService.appGetDataDictionary(dataType);	
	}	
	
	//发车单下订单统计
	@RequestMapping("/appDispatchOrderCount")
	@ResponseBody
	public String appDispatchOrderCount(String dispatchOrderNo, String driverCode) throws Exception{
		return tmsAppService.appDispatchOrderCount(dispatchOrderNo, driverCode);
	}
	
	//图片存储测试接口
	@RequestMapping("/testImgQuality")
	@ResponseBody
	public String testImgQuality(String img) throws Exception{
		return tmsAppService.testImgQuality(img);
	}
	
	
	/**
	 * 预警个数查询
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCountByMaster")
	@ResponseBody
	public String getCountByMaster(String masterId,String version) throws Exception {
		return tmsAppService.getCountByMaster(masterId,version);
	}
	
	/**
	 * 预警记录查询
	 * @param masterId
	 * @param type
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryWarnningRecord")
	@ResponseBody
	public String queryWarnningRecord(String masterId, String type, int startIndex, int pageSize,String version) throws Exception {
		return tmsAppService.queryWarnningRecord(masterId, type, startIndex, pageSize,version);
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(String name,String id){
		return "hello!";
	}
	
	/**
	 * 查询预警提示
	 * @param masterId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryWarnningNotice")
	@ResponseBody
	public String queryWarnningNotice(String masterId) throws Exception {
		return tmsAppService.queryWarnningNotice(masterId);
	}
	
	
	/**
	 * 接触预警
	 * @param masterId
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/warnningRemove")
	@ResponseBody
	public String warnningRemove(String masterId, String flag) throws Exception {
		return tmsAppService.warnningRemove(masterId, flag);
	}
}

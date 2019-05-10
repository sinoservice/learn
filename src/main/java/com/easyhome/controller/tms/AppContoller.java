package com.easyhome.controller.tms;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.tms.AppServiceI;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

/**
 * 
 * <p>title: AppContoller</p>
 * <p>description: 加盟商平台，工人app接口提供视图</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月27日 下午5:17:38
 */
@Controller
@RequestMapping("/app")
public class AppContoller {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppContoller.class);

	@Autowired
	private AppServiceI appService;
	
	/**
	 * 
	 * <p>description: 工人工单列表</p>
	 * @param status
	 * @param workId
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @date 2016年7月27日 下午5:34:09
	 */
	@RequestMapping("/findOrderList")
	@ResponseBody
	public String workOrderList(@RequestParam(defaultValue="") int status,//工单状态
			@RequestParam(defaultValue="") String workId, //工人id
			@RequestParam(defaultValue="10") int pageSize, //每页记录数
			@RequestParam(defaultValue="1") int currentPage //当前页码
			){
		logger.info("status:"+status);
		logger.info("workId:"+workId);
		logger.info("pageSize:"+pageSize);
		logger.info("currentPage:"+currentPage);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			return appService.workOrderList(status, workId,pageSize,currentPage);
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
	/**
	 * 
	 * <p>description: 工单详情</p>
	 * @param workOrderId
	 * @param workOrderOwnnerId
	 * @return
	 * @throws Exception
	 * @date 2016年7月27日 下午6:52:11
	 */
	@RequestMapping("/getWorkOrderDetail")
	@ResponseBody
	public String getWorkOrderDetail(@RequestParam(defaultValue="") String workOrderId,@RequestParam(defaultValue="")  String workOrderOwnnerId) throws Exception{
		logger.info("workOrderId:"+workOrderId);
		logger.info("workOrderOwnnerId:"+workOrderOwnnerId);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			return appService.getWorkOrderDetail(workOrderId, workOrderOwnnerId);
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
	/**
	 * 
	 * <p>description: 工单预约</p>
	 * @param workId
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
	 * @throws Exception
	 * @date 2016年7月27日 下午7:44:00
	 */
	@RequestMapping("/booking")
	@ResponseBody
	public String booking(
			@RequestParam(defaultValue="") String workId, //工人id
			@RequestParam(defaultValue="") String omsMasterId,//技师id
			@RequestParam(defaultValue="") String workorderid,//工单ID
			@RequestParam(defaultValue="") String linkman,//安装联系人
			@RequestParam(defaultValue="") String address,//安装联系人地址
			@RequestParam(defaultValue="") String phone,//安装联系人电话
			@RequestParam(defaultValue="1") int status,// 预约状态：失败-0 成功-1
			@RequestParam(defaultValue="") String reason,//预约失败原因
			@RequestParam(defaultValue="") String date,//预约日期
			@RequestParam(defaultValue="") String call//是否拨打了电话
	) throws Exception{
		logger.info("workId:"+workId);
		logger.info("omsMasterId:"+omsMasterId);
		logger.info("workorderid:"+workorderid);
		logger.info("linkman:"+linkman);
		logger.info("address:"+address);
		logger.info("phone:"+phone);
		logger.info("status:"+status);
		logger.info("reason:"+reason);
		logger.info("date:"+date);
		logger.info("call:"+call);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			return appService.saveBooking(workId,omsMasterId,workorderid,linkman,address,phone,status,reason,date,call);
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
	/**
	 * 
	 * <p>description: 工人签到</p>
	 * @param workId
	 * @param omsMasterId
	 * @param workorderid
	 * @param signerid
	 * @param Signer
	 * @param type
	 * @param Lat
	 * @param lng
	 * @param code
	 * @param address
	 * @param phone
	 * @return
	 * @throws Exception
	 * @date 2016年7月27日 下午7:44:24
	 */
	@RequestMapping("/sign")
	@ResponseBody
	public String sign(
			@RequestParam(defaultValue="") String workId, //工人id
			@RequestParam(defaultValue="") String omsMasterId,
			@RequestParam(defaultValue="") String workorderid,//工单id
			@RequestParam(defaultValue="") String signerid,//签到人ID
			@RequestParam(defaultValue="") String Signer,//签到人
			@RequestParam(defaultValue="") String type,//签到方式APP签到
			@RequestParam(defaultValue="") String Lat,//经度
			@RequestParam(defaultValue="") String lng,//纬度
			@RequestParam(defaultValue="") String code,//短信验证码
			@RequestParam(defaultValue="") String address,//地址
			@RequestParam(defaultValue="") String phone//电话
			) throws Exception{
		logger.info("workId:"+workId);
		logger.info("omsMasterId:"+omsMasterId);
		logger.info("workorderid:"+workorderid);
		logger.info("signerid:"+signerid);
		logger.info("Signer:"+Signer);
		logger.info("workId:"+workId);
		logger.info("type:"+type);
		logger.info("Lat:"+Lat);
		logger.info("lng:"+lng);
		logger.info("code:"+code);
		logger.info("address:"+address);
		logger.info("phone:"+phone);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String returnCode = appService.saveSign(workId,omsMasterId,workorderid,signerid,Signer,type,Lat,lng,code,address,phone);
			return returnCode;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
	/**
	 * 
	 * <p>description: 工人完工汇报</p>
	 * @param data
	 * @param workId
	 * @param workorderid
	 * @return
	 * @throws Exception
	 * @date 2016年7月27日 下午7:44:42
	 */
	@RequestMapping("/compelete")
	@ResponseBody
	public String compelete(String data,String workId,String workorderid) throws Exception{
		logger.info("workId:"+workId);
		logger.info("workorderid:"+workorderid);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			return appService.saveCompelete(data,workId,workorderid);
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
	/**
	 * 
	 * <p>description: TODO</p>
	 * @param data
	 * @param workId
	 * @param workorderid
	 * @return
	 * @throws Exception
	 * @date 2016年7月27日 下午8:07:41
	 */
	@RequestMapping("/searchWorkOrder")
	@ResponseBody
	public String searchWorkOrder(@RequestParam(defaultValue="") String searchWords,
			@RequestParam(defaultValue="") String omsMasterId,
			@RequestParam(defaultValue="") String workId,
			@RequestParam(defaultValue="") Integer pageIndex,
			@RequestParam(defaultValue="") Integer pagesize) throws Exception{
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			return appService.searchWorkOrder(searchWords,omsMasterId,workId,pageIndex,pagesize);
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("请求失败");
		}
		return gson.toJson(br);
	}
	
}

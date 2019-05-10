package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.TamllOrderUpdate;
import com.easyhome.service.oms.AppTamllOrderServiceI;
/**
 * 
* @ClassName: AppTamllOrderController 
* @Description: TODO 喵师傅接口升级
* @date 2017年2月9日 下午6:47:55 
*
 */
@Controller
@RequestMapping("/tamll/order")
public class AppTamllOrderController {
	
	@Resource
	private AppTamllOrderServiceI appTamllOrderServiceI;
	
	/**
	 * 
	* @Title: appBespokeDispatchRecordList 
	* @Description: TODO 预约记录列表
	* @param workorderid
	* @param masterid
	* @return 
	* String    
	* @throws 
	* @date 2017年2月9日 下午6:47:34
	 */
	@RequestMapping("/appBespokeDispatchRecordList")
	@ResponseBody
	public String appBespokeDispatchRecordList(String workorderid,String masterid){
		return appTamllOrderServiceI.appBespokeDispatchRecordList(workorderid, masterid);
	}
	
	/**
	 * 
	* @Title: appTmallBespokeDispatch 
	* @Description: TODO 天猫单预约接口
	* @param orderUpdate
	* @return 
	* String    
	* @throws 
	* @date 2017年2月9日 下午6:50:27
	 */
	@RequestMapping("/appTmallBespokeDispatch")
	@ResponseBody
	public String appTmallBespokeDispatch(TamllOrderUpdate orderUpdate){
		return appTamllOrderServiceI.appTmallBespokeDispatch(orderUpdate);
	}
	
	@RequestMapping("/appBespokeDispatchTwiceReservationTimeRecordList")
	@ResponseBody
	public String appBespokeDispatchTwiceReservationTimeRecordList(String masterid){
		return appTamllOrderServiceI.appBespokeDispatchTwiceReservationTimeRecordList(masterid);
	}
}

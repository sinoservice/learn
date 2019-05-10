package com.easyhome.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.TbWorkOrder;
import com.easyhome.po.TbWorkOrderBooking;
import com.easyhome.service.WorkOrderService;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * <p> Title: BookingController</p>
 * <p> Description: 工单预约控制器</p>
 * 
 * @date 2016年5月10日 下午5:08:17
 * @version 1.0
 *
 */

@Controller
@RequestMapping("/booking")
public class BookingController {
	/**
	 * Logger for this class
	 */
	Log log = LogFactory.getLog(BookingController.class);
	
	@Autowired
	private WorkOrderService workOrderService;


	/**
	 * 
	 * <p> Description: 工单预定</p>
	 * 
	 * @date 2016年5月10日 下午5:14:01
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
	@RequestMapping(value="/work")
	public @ResponseBody Map<String, Object> book(
			String workorderid,
			String linkman,
			String address,
			String phone,
			String status,
			String reason,
			String date,
			String call
			,HttpServletRequest request) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		log.info("====================输入参数====================");
		log.info("workorderid"+workorderid);
		log.info("linkman:"+linkman);
		log.info("address:"+address);
		log.info("status:"+status);
		log.info("phone"+phone);
		log.info("reason"+reason);
		log.info("date"+date);
		log.info("call:"+call);
		TbWorkOrder workOrder = null;
		int reslutCode = -1;
		String checkCode = "";
		String version = request.getHeader("version");
		if(!Util.isEmpty(version)){
			try {
				//2.07
				Double d = Double.valueOf(version);
				if(d>=2.07){
					
				}else{
					result.put("errCode", reslutCode);
					result.put("errMsg", "请更新为最新版本使用！");
					return result;
				}
			} catch (Exception e) {
				log.error("提示升级版本异常",e);
				result.put("errCode", reslutCode);
				result.put("errMsg", "请更新为最新版本使用！");
				return result;
			}
		}else{
			//为空
			result.put("errCode", reslutCode);
			result.put("errMsg", "请更新为最新版本使用！");
			return result;
		}
		
		try {
			
			//1.查询工单是否存在，如果存在则执行后续操作，如果不存在则不保存
			workOrder = workOrderService.getBookOrderingByFId(workorderid);
			if(workOrder != null && workorderid.equals(workOrder.getFid())){
				log.info("工单存在,准备执行保存预约信息操作！！！");
				
				//2.接受参数并调用APP后台
				try {
					TbWorkOrderBooking orderBooking = workOrderService.saveOrderBooking(workorderid, linkman, address, phone, status, reason, date, call);
					if(orderBooking != null){
						log.info("保存预约信息,工单保存成功获得返回值！！！");
						log.info("正在准备保存预约信息操作！！！");
						
						try {
							checkCode = this.workOrderService.createCheckCode()+"";
							reslutCode = workOrderService.updateWorkOrderStatusInfo(workOrder,orderBooking,date,checkCode);
							if(reslutCode == 0){
								//4.设置响应值
								result.put("errMsg", "保存成功");
								log.info("工单状态更新成功：" + reslutCode);
							}else{
								log.info("工单状态更新失败：" + reslutCode);
							}
						} catch (Exception e) {
						}
					}else{
						result.put("errMsg", "保存失败");
						log.info("保存预约信息,预约保存失败！！！");
					}
				} catch (Exception e) {
					result.put("errMsg", "保存失败");
					log.info("保存预约信息,预约保存失败！！！");
				}
			}else{
				result.put("errMsg", "保存失败");
				log.info("工单不存在,操作终止！！！");
			}
			
		} catch (Exception e) {
			result.put("errMsg", "保存失败");
		}
		
		//发送短信
		TbWorkOrder order = workOrderService.getBookOrderingByFId(workorderid);
		if(order != null){
			//为客户发送短信
			int msgCode = workOrderService.sendBookMsg(workOrder,date,status,checkCode);
			workOrderService.sendSginMsg(workorderid);
			if(msgCode == 0){
				log.info("短信发送成功");
			}else{
				log.info("短信发送失败");
			}
		}
		result.put("errCode", reslutCode);
		result.put("result", "{ }");
		return result;
	}
	
	
	@RequestMapping(value="/re_send_sms_code")
	@ResponseBody
	public BaseResponse reSendSmsCode(String workorderid,String phone){
		log.info("重发签到码：workorderid="+workorderid+",phone="+phone);
		return workOrderService.reSendSmsCode(workorderid, phone);
	}
	
	
}

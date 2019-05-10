package com.easyhome.controller;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.TbWorkOrder;
import com.easyhome.service.AppraiseService;
import com.easyhome.service.WorkOrderService;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/appraise")
public class AppraiseController {
	
	Log log = LogFactory.getLog(AppraiseController.class);
	
	@Resource
	private AppraiseService service;
	
	@Autowired
	private WorkOrderService workOrderService;

	@RequestMapping(value="/addAppraise",method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse execute(String workorderid,Integer evalServiceComplete,Integer evalDelivery,Integer evalInstall,Integer evalPhoneBack){
		BaseResponse response=service.addAppraise(workorderid,evalServiceComplete, evalDelivery, evalInstall, evalPhoneBack);
		return response;
	}
	@RequestMapping(value="/getAppraise",method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse execute(String workorderid){
		BaseResponse response=service.findAppraiseMessage(workorderid);
		   return response;       	
	}
	@RequestMapping(value="/addAddress",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse execute(String workorderid,String address){
		BaseResponse response=service.addMessage(workorderid, address);
		return response;
	}
	
	/**
	 * 
	 * <p> Description: 保存评价页面</p>
	 * 
	 * @date 2016年5月30日 下午5:26:40
	 * @version 1.0
	 * @param workOrderId 工单id
	 * @param address 二维码生成地址
	 * @param date 二维码生成时间
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/save/{workOrderId}",method=RequestMethod.GET)
	public String save(@PathVariable String workOrderId) throws Exception{
		//int appraise = workOrderService.saveAppraise(tbWorkOrder, workOrderId);
		//如果已经评价
//		boolean i = workOrderService.findWorkOrderAppraise(workOrderId);
//		if(i){
//			return "appraise/save";
//		}else{
//			return "appraise/success";
//		}
		return "appraise/save";
	}
	
	/**
	 * 
	 * <p> Description: 保存评价信息</p>
	 * 
	 * @date 2016年6月1日 下午2:01:36
	 * @version 1.0
	 * @param workOrderId 工单id
	 * @param address 二维码生成地址
	 * @param date 二维码生成时间
	 * @param evalServiceComplete
	 * @param evalPhoneBack
	 * @param satisfaction1
	 * @param satisfaction2
	 * @param satisfaction3
	 * @param customerEval
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/save/{workOrderId}",method=RequestMethod.POST)
	public String save(
			@PathVariable(value="workOrderId") String workOrderId,
			@RequestParam(defaultValue="0") int evalServiceComplete,
			@RequestParam(defaultValue="0") int evalPhoneBack,
			@RequestParam(defaultValue="0") int satisfaction1,
			@RequestParam(defaultValue="0") int satisfaction2,
			@RequestParam(defaultValue="0") int satisfaction3,
			@RequestParam(defaultValue="") String customerEval) throws Exception{
		log.info("workOrderId:"+workOrderId);
		log.info("evalServiceComplete"+evalServiceComplete);
		log.info("evalPhoneBack:"+evalPhoneBack);
		log.info("satisfaction1:"+satisfaction1);
		log.info("satisfaction2:"+satisfaction2);
		log.info("satisfaction3:"+satisfaction3);
		log.info("customerEval:"+customerEval);
		
		TbWorkOrder tbWorkOrder = new TbWorkOrder();
		tbWorkOrder.setEvalServiceComplete(new BigDecimal(evalServiceComplete ==0 ? 0:evalServiceComplete));
		tbWorkOrder.setEvalPhoneBack(new BigDecimal(evalPhoneBack==0 ? 0:evalPhoneBack));
		tbWorkOrder.setSatisfaction1(new BigDecimal(satisfaction1==0 ? 0:satisfaction1));
		tbWorkOrder.setSatisfaction2(new BigDecimal(satisfaction2==0 ? 0:satisfaction2));
		tbWorkOrder.setSatisfaction3(new BigDecimal(satisfaction3==0 ? 0:satisfaction3));
		tbWorkOrder.setCustomerEval(customerEval);
		
		if(tbWorkOrder.getSatisfaction1().intValue()>=3 &&
			tbWorkOrder.getSatisfaction2().intValue()>=3 &&
			tbWorkOrder.getSatisfaction3().intValue()>=3){
			tbWorkOrder.setStatus(new BigDecimal(5));//待结算
			tbWorkOrder.setStatusDisplay("待结算");
			tbWorkOrder.setServiceFeedback("正常");
		}else{
			tbWorkOrder.setStatus(new BigDecimal(6));//已回访
			tbWorkOrder.setStatusDisplay("已回访");
			tbWorkOrder.setServiceFeedback("异常");
		}
		tbWorkOrder.setFeedbackTime(new Date());//回访时间
		tbWorkOrder.setFeedbackValidity("回访成功");//回访有效性
		tbWorkOrder.setFeedbackMan("扫码回访");
		int appraise = workOrderService.saveAppraise(tbWorkOrder , workOrderId);
		
		//发送完成评价短信短信
		if(appraise>0){
			log.info("扫码评价成功");
			
			//查找工单信息
			if(!"".equals(workOrderId) && workOrderId != null){
				TbWorkOrder t = workOrderService.getOneWorkOrder(workOrderId);
				if(t!=null){
					String phone = t.getCusTel();
					if(phone!=null && !"".equals(phone)){
						try {
							/*
							String url = ResourcesUtil.getValue("config", "smsurl");
							String content = "尊敬的CUSTOM客户您好，您的订单ORDER已服务完毕并完成服务评价，请您确认，如有疑问请联系全国服务热线4006120122，祝您生活愉快！";
							content = content.replace("CUSTOM", t.getCusName()).replace("ORDER", t.getOutOrderSn());
							Map<String, String> params = new HashMap<String, String>();
							params.put("mobile", phone);
							params.put("content", content);
							String post = HttpXmlClient.post(url, params);
							*/
							String content = t.getCusName()+"@"+t.getOutOrderSn();
							AliyunSMS.sendMsgToPhone(phone, "SMS_137426529", content);
							log.info("短信发送成功");
							log.info("短信结果码："+content);
						} catch (Exception e) {
							log.info("短信发送失败：",e);
						}
					}
				}
			}
		}
		return "appraise/success";
	}
	
	
	@RequestMapping("/saveAppraise")
	@ResponseBody
	public BaseResponse saveAppraise(
			String workOrderId,
			@RequestParam(defaultValue="0") int evalServiceComplete,
			@RequestParam(defaultValue="0") int evalPhoneBack,
			@RequestParam(defaultValue="0") int satisfaction1,
			@RequestParam(defaultValue="0") int satisfaction2,
			@RequestParam(defaultValue="0") int satisfaction3,
			@RequestParam(defaultValue="") String customerEval) throws Exception{
		
		BaseResponse br = new BaseResponse();
		
		log.info("evalServiceComplete:"+evalServiceComplete);
		log.info("evalPhoneBack:"+evalPhoneBack);
		log.info("satisfaction1:"+satisfaction1);
		log.info("satisfaction2:"+satisfaction2);
		log.info("satisfaction3:"+satisfaction3);
		log.info("workOrderId:"+workOrderId);
		log.info("customerEval:"+customerEval);
		
		TbWorkOrder tbWorkOrder = new TbWorkOrder();
		tbWorkOrder.setEvalServiceComplete(new BigDecimal(evalServiceComplete ==0 ? 0:evalServiceComplete));
		tbWorkOrder.setEvalPhoneBack(new BigDecimal(evalPhoneBack==0 ? 0:evalPhoneBack));
		tbWorkOrder.setSatisfaction1(new BigDecimal(satisfaction1==0 ? 0:satisfaction1));
		tbWorkOrder.setSatisfaction2(new BigDecimal(satisfaction2==0 ? 0:satisfaction2));
		tbWorkOrder.setSatisfaction3(new BigDecimal(satisfaction3==0 ? 0:satisfaction3));
		tbWorkOrder.setCustomerEval(customerEval);
		
		if(tbWorkOrder.getSatisfaction1().intValue()>=3 &&
			tbWorkOrder.getSatisfaction2().intValue()>=3 &&
			tbWorkOrder.getSatisfaction3().intValue()>=3){
			tbWorkOrder.setStatus(new BigDecimal(5));//待结算
			tbWorkOrder.setStatusDisplay("待结算");
			tbWorkOrder.setServiceFeedback("正常");
		}else{
			tbWorkOrder.setStatus(new BigDecimal(6));//已回访
			tbWorkOrder.setStatusDisplay("已回访");
			tbWorkOrder.setServiceFeedback("异常");
		}
		tbWorkOrder.setFeedbackTime(new Date());//回访时间
		tbWorkOrder.setFeedbackValidity("回访成功");//回访有效性
		tbWorkOrder.setFeedbackMan("扫码回访");
		int appraise = workOrderService.saveAppraise(tbWorkOrder , workOrderId);
		
		//发送完成评价短信短信
		if(appraise>0){
			log.info("扫码评价成功");
			
			//查找工单信息
			if(!"".equals(workOrderId) && workOrderId != null){
				TbWorkOrder t = workOrderService.getOneWorkOrder(workOrderId);
				if(t!=null){
					String phone = t.getCusTel();
					if(phone!=null && !"".equals(phone)){
						try {
							/*
							String url = ResourcesUtil.getValue("config", "smsurl");
							String content = "尊敬的CUSTOM客户您好，您的订单ORDER已服务完毕并完成服务评价，请您确认，如有疑问请联系全国服务热线4006120122，祝您生活愉快！";
							content = content.replace("CUSTOM", t.getCusName()).replace("ORDER", t.getOutOrderSn());
							Map<String, String> params = new HashMap<String, String>();
							params.put("mobile", phone);
							params.put("content", content);
							String post = HttpXmlClient.post(url, params);
							*/
							String content = t.getCusName()+"@"+t.getOutOrderSn();
							AliyunSMS.sendMsgToPhone(phone, "SMS_137426529", content);
							br.setReturnCode(200);
							br.setInfo("请求成功，短信已发生到客户手机");
							log.info("短信发送成功");
							log.info("短信结果码："+content);
							br.setData("SUCCESS");
						} catch (Exception e) {
							br.setReturnCode(500);
							br.setInfo("请求失败");
							br.setData("FAIL");
							log.info("短信发送失败：",e);
						}
					}
				}
			}
		}
		return br;
	}

}
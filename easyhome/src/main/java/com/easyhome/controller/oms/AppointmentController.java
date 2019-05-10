package com.easyhome.controller.oms;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.AppointmentRequest;
import com.easyhome.service.oms.AppointmentService;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/oms/worker")
public class AppointmentController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentServiceI;
	
	/**
	 * 
	 * <p> Description: 工单预约</p>
	 * 
	 * @date 2016年7月5日 上午10:21:29
	 * @version 1.0
	 * @param request
	 * @return
	 */
	@RequestMapping("/appoint")
	@ResponseBody
	public String appointExcute(AppointmentRequest request){
		long start = System.currentTimeMillis();
		logger.info("开始预约："+request);
		String appiontWorkerInfo = appointmentServiceI.appiontWorker(request);
		long end = System.currentTimeMillis();
		
		OmsConstant.BOOKING_COUNT ++;
		Long count = OmsConstant.BOOKING_COUNT;
		
		logger.info("第：" + count + "次执行预约..");
		logger.info("预约结束，预约耗时：" + (end - start));
		return appiontWorkerInfo;
		
	}
	
	@RequestMapping(value="/re_send_chock_code")
	@ResponseBody
	public BaseResponse reSendSmsCode(String code,String phone){
		BaseResponse br = new BaseResponse();
		try {
			return appointmentServiceI.reSendSmsCode(code, phone);
		} catch (Exception e) {
			br.setInfo("发送失败");
			br.setReturnCode(500);
		}
		return br;
	}
}

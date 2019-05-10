package com.easyhome.controller.oms;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.oms.AddressSignRequest;
import com.easyhome.po.oms.SignRequest;
import com.easyhome.service.oms.AddressSignService;
import com.easyhome.service.oms.SignService;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/oms/workor")
public class SignRequestController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SignRequestController.class);
	
	@Autowired
	private SignService signRequestServiceI;
	
	@Autowired
	private AddressSignService addressSignService;
	
	
	/**
	 * 
	 * <p> Description: 上门签到</p>
	 * 
	 * @date 2016年7月5日 上午10:05:13
	 * @version 1.0
	 * @param request
	 * @return
	 */
	@RequestMapping("/sign")
	@ResponseBody
	public String signExcue(SignRequest request){
//		logger.info("签到参数："+request);
//		logger.info("签到人："+request.getSigner());
//		logger.info("验证码："+request.getCode());
//		logger.info("签到人ID："+request.getSignerid());
		long start = System.currentTimeMillis();
		logger.info("开始预约");
		String response = signRequestServiceI.signWorker(request);
		long end = System.currentTimeMillis();
		
		OmsConstant.SGIN_COUNT ++;
		Long count = OmsConstant.SGIN_COUNT;
		
		logger.info("第：" + count + "次执行签到..");
		
		logger.info("预约结束，耗时：" +(end - start));
		return response;
	}
	
	/**
	 * 
	 * <p> Description: 验证码签到</p>
	 * 
	 * @date 2016年7月5日 上午10:05:30
	 * @version 1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/messageSign")
	@ResponseBody
	public BaseResponse messageSignExcue(SignRequest request){
      BaseResponse response =		signRequestServiceI.signWorkerByMessage(request);
      return response;
	}
	
	/**
	 * 
	 * <p> Description: 确定位置</p>
	 * 
	 * @date 2016年7月5日 上午10:07:36
	 * @version 1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addressSign")
	@ResponseBody
	public BaseResponse addressSign(AddressSignRequest request){
		BaseResponse response = addressSignService.addressSign(request);
		return response;
		
	}
	

}

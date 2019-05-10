package com.easyhome.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.po.Sms;
import com.easyhome.service.SmsService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/sms")
public class SmsController {

	Log log = LogFactory.getLog(SmsController.class);

	@Resource
	private SmsService smsService;

	@RequestMapping(value = "/getSms/{fid}", method = RequestMethod.GET)
	public BaseResponse getAddressInfo(@PathVariable("fid")String fid) {
		log.info("[getSms]fid:" + fid);
		BaseResponse response = new BaseResponse();
		try {
			Sms sms = smsService.getSmsById(fid);
			response.setData(sms);
			response.setReturnCode(ReturnCode.STATUS_200);
			response.setInfo(ReturnCode.OK);
		} catch (Exception e) {
			log.error("获取消息异常", e);
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo(ReturnCode.FAIL);
		}
		return response;
	}

}

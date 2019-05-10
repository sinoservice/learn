package com.easyhome.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.AppMessageService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/version")
public class UpdateVersionController {
	Log log = LogFactory.getLog(UpdateVersionController.class);
	@Resource
	private AppMessageService appMessageService;

	// @RequestMapping("/addVersion")
	// public BaseResponse execute(String appVersion,String model,String
	// androidVersion,String masterId,String phone){
	// BaseResponse response=appMessageService.save(appVersion, model,
	// androidVersion, masterId,phone);
	// return response;
	// }
	@RequestMapping("/updateVersion")
	public BaseResponse execute(HttpServletRequest request) {
		String phone = request.getParameter("phone");
		String appVersion = request.getParameter("version");
		log.info("phone=" + phone + ",appVersion=" + appVersion);
		BaseResponse response = appMessageService.UpdateVersion(phone,
				appVersion);
		return response;
	}
}

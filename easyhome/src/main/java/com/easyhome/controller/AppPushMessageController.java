package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.AppMessageService;
import com.easyhome.vo.BaseResponse;
@RestController
@RequestMapping("/appMessage")
public class AppPushMessageController {
	@Resource
	private AppMessageService appMessageService;
	
	@RequestMapping("/findAppMessage")
	public BaseResponse findMessage(String userid,Integer pageindex,Integer pagesize,Integer status){
	BaseResponse response=appMessageService.findAppMessage(userid, pageindex, pagesize,status);
	return response;
	}

}

package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.UserService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService service;

	@RequestMapping("/Login")
	public BaseResponse login(String phone,String password){
		BaseResponse response=service.checkLogin(phone, password);	
		return response;
	}
	@RequestMapping("/ModifyPassword")
	public BaseResponse update(String fid,String oldpassword,String password){
		BaseResponse response=service.ModifyPassword(fid, oldpassword, password);
		return response;
	}
	@RequestMapping("/updatePasswordByPhone")
	public BaseResponse updatePasswordByPhone(String phone,String password,String captcha){
		BaseResponse response=service.AlterPassword(phone, password, captcha);
		return response;
	}
}

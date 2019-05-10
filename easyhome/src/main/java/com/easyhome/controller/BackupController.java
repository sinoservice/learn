package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.BackupService;
import com.easyhome.vo.BaseResponse;
@RestController
@RequestMapping("/backup")
public class BackupController {
	@Resource
	private BackupService backupService;
	@RequestMapping(value="/find",method = RequestMethod.POST)
	public BaseResponse execute(String workNo){
		BaseResponse response = backupService.findWorkOrder(workNo);
		return response;
	}
}
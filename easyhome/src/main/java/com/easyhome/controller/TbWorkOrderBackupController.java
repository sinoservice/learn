package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.MasterIdMessageService;
import com.easyhome.vo.BaseResponse;

@Controller
@RequestMapping("/masterid")
public class TbWorkOrderBackupController {
        
	@Resource
	private MasterIdMessageService masterIdMessage;
	
	@RequestMapping(value="/searchMissingOrder")
	@ResponseBody
	public BaseResponse execute(String masterId,Integer pagesize,Integer pageIndex){
		BaseResponse response =	masterIdMessage.findWorkOrder(masterId, pagesize, pageIndex);
		return response;
	}
	
}

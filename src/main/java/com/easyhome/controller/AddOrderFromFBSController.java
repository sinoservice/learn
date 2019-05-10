package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.AddOrderFromFBSService;
import com.easyhome.vo.BaseResponse;
@Controller
@RequestMapping("/ordertoapp")
public class AddOrderFromFBSController {
	@Resource
	private AddOrderFromFBSService addOrderFromFBSService;
	/**
	 * 添加FBS订单到app后台
	 * @param orderNo
	 * @return
	 */
	@RequestMapping("/addordertoapp")
	@ResponseBody
	public BaseResponse addOrder(String orderNo){
		BaseResponse response=addOrderFromFBSService.addOrderFromFBS(orderNo);
		return response;
		}
}

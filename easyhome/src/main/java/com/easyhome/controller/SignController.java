package com.easyhome.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.SignService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/sign")
public class SignController {
	Log log = LogFactory.getLog(SignController.class);
	@Resource
	private SignService signService;

	@RequestMapping(value = "/coordinate", method = RequestMethod.POST)
	public BaseResponse getCoordinate(String address) {
		return signService.getCoordinate(address);
	}
}

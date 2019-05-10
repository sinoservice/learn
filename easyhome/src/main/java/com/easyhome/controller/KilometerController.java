package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.KilometerService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/kilometer")
public class KilometerController {
	@Resource
	private KilometerService kilometerService;
	@RequestMapping("/addStart")
	public BaseResponse addStart(String driverNo, String driverId, double startKilometer,String startUrl){
		BaseResponse response=kilometerService.saveStart(driverNo, driverId, startKilometer, startUrl);
		return response;
	}
	@RequestMapping("/addEnd")
	public BaseResponse addEnd(double endKilometer, String endUrl){
		BaseResponse response=kilometerService.saveEnd(endKilometer, endUrl);
		return response;
	}

}

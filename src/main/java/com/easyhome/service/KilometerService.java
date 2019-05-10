package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface KilometerService {

	BaseResponse saveStart(String driverNo, String driverId, double startKilometer,String startUrl);
	BaseResponse saveEnd(double endKilometer, String endUrl);
	
}

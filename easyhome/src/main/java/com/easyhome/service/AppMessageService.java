package com.easyhome.service;
import com.easyhome.vo.BaseResponse;
public interface AppMessageService {
	 BaseResponse save(String appVersion,String model,String androidVersion,String masterId,String phone);
	 BaseResponse UpdateVersion(String phone,String appVersion);
	 BaseResponse findAppMessage(String userid,Integer pageindex,Integer pagesize,Integer status);
}

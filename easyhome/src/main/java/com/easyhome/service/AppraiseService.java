package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface AppraiseService {

	public BaseResponse addAppraise(String workorderid,Integer evalServiceComplete,Integer evalDelivery,Integer evalInstall,Integer evalPhoneBack);
	public BaseResponse findAppraiseMessage(String workorderid);
	public BaseResponse addMessage(String workorderid,String address);
	
}

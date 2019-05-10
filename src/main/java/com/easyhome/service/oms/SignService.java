package com.easyhome.service.oms;

import com.easyhome.po.oms.SignRequest;
import com.easyhome.vo.BaseResponse;

public interface SignService {
   
	//上门签到
	public String signWorker(SignRequest sign);
	
	//短信签到
	public BaseResponse signWorkerByMessage(SignRequest signByMessage);
	
}

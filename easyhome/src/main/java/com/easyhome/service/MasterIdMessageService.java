package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface MasterIdMessageService {
	BaseResponse findWorkOrder(String masterId,
			Integer pagesize, Integer pageIndex);

}

package com.easyhome.service.oms.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.easyhome.po.oms.WorkorPopupRequest;
import com.easyhome.service.oms.WorkorPopupService;
import com.easyhome.vo.BaseResponse;

@Service
public class WorkorPopupServiceImpl implements WorkorPopupService {

	/**
	 * 放弃工单弹出框
	 * 必须传的参数：CategoryCode
	 */

	public BaseResponse quitWorkor(WorkorPopupRequest request) {
		BaseResponse response = new BaseResponse();
		
		WorkorPopupRequest workorPopup = new WorkorPopupRequest();
		
		if(request.getCategoryCode()==null||"".equals(request.getCategoryCode())){
			 response.setInfo("请输入放弃工单的类别码");
			 response.setReturnCode(400);
			 return response;
		}
		String fid = UUID.randomUUID().toString();
		workorPopup.setFID(fid);
		workorPopup.setCategoryCode("321556724578");
		workorPopup.setCode("1362897687");
		workorPopup.setParentId("1882525678");
		workorPopup.setSortnum("13683236609");
		workorPopup.setStatus(1);
		workorPopup.setTitle("放弃工单详情");
		workorPopup.setChildren("6969369");
		response.setInfo("放弃工单详情");
		response.setData(workorPopup);
		response.setReturnCode(200);
		return response;
	}

}

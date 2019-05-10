package com.easyhome.service.oms.impl;

import org.springframework.stereotype.Service;

import com.easyhome.po.oms.AddressSignRequest;
import com.easyhome.service.oms.AddressSignService;
import com.easyhome.vo.BaseResponse;

@Service
public class AddressSignServiceImpl implements AddressSignService {
	/**
	 *  @param lat:纬度
	 *
	    @param lon:经度
	 */
	@Override
	public BaseResponse addressSign(AddressSignRequest request) {
		BaseResponse  response = new BaseResponse();
		AddressSignRequest addressSign  = new AddressSignRequest();
		if(request.getAddress()==null||"".equals(request.getAddress())){
			response.setInfo("请确定您所在的位置");
			response.setReturnCode(400);
			return response;
		}
		addressSign.setLat(60.8);
		addressSign.setLon(90.8);
		addressSign.setConfigDis(85);
		addressSign.setAddress(request.getAddress());
		response.setReturnCode(200);
		response.setData(addressSign);
		response.setInfo("获取位置信息成功");
		return response;
	}

}

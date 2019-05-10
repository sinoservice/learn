package com.easyhome.service.oms.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.service.oms.CodeService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.vo.CodeResponse;
@Service("codeService")
public class CodeServiceImpl implements CodeService{

	@Override
	public CodeResponse findCode(String phone) {
		CodeResponse response=new CodeResponse();
		String url="http://app.51eaju.com:82/APP/SendSms";
		Map<String,String> params =new HashMap<>();
		params.put("phone", phone);
		String code=HttpXmlClient.post(url, params);
//		response.setCode(code);
//		response.setErrCode(0);
//		response.setErrMsg("");
//		response.setResult("");
		return response;
	}
}

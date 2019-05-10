package com.easyhome.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.AppGetRewardAndPunish;
import com.easyhome.service.AppGetRewardAndPunishService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service("appGetRewardAndPunishService")
public class AppGetRewardAndPunishServiceImpl implements AppGetRewardAndPunishService{

	private static final Logger logger = Logger.getLogger(AppGetRewardAndPunishServiceImpl.class);
	
	@Override
	public String appGetRewardAndPunish(AppGetRewardAndPunish request) {
		
		Gson gson = new Gson();
		try {
			String data = OmsConnectUtil.getData("appGetRewardAndPunish", gson.toJson(request));
			 data = data.replace("data", "result");
			return data;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}

}

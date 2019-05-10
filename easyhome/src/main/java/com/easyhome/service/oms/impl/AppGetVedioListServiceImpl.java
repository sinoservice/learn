package com.easyhome.service.oms.impl;

import org.springframework.stereotype.Service;

import com.easyhome.po.oms.AppGetVedioList;
import com.easyhome.service.oms.AppGetVedioListService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service("appGetVedioListService")
public class AppGetVedioListServiceImpl implements AppGetVedioListService{

	//private static  final Logger logger =Logger.getLogger(AppGetVedioListServiceImpl.class);
	@Override
	/***
	 * 视频查询
	 */
	public String appGetVedioList(AppGetVedioList request) {
		Gson gson = new Gson();
		
		try {
			String data = OmsConnectUtil.getData("appGetVedioList", gson.toJson(request));
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

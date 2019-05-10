package com.easyhome.service.dms.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.service.dms.FindStatusQueryService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.OrderResult;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class FindStatusQueryServiceImpl implements FindStatusQueryService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FindStatusQueryServiceImpl.class);

	@Override
	public String FindStatusQuery(String omsMasterId, String date, String version) {		
		Gson gson = new Gson();
		OrderResult or = new OrderResult();
		String newestVersion = ResourcesUtil.getValue("config", "newestVersion");
		Double versionNow = Double.parseDouble(newestVersion);// 当前版本号
		Double versionPass=0.0;
		String result = "";
		if(version == null || "".equals(version)){
			or.setErrMsg("当前版本较低,请更新版本！");
			or.setErrCode(ReturnCode.STATUS_500);
			result = gson.toJson(or);
			return result;
		}else{
			 versionPass = Double.parseDouble(version);//传入版本号
		}
		if (versionPass >= versionNow) {
			try {
				String url = Util.getProperty("dmsurl");
				url = url + "/dispatch";
				Map<String, String> params = new HashMap<String, String>();
				params.put("omsMasterId", omsMasterId);
				params.put("date", date);
				String data = gson.toJson(params);
				Map<String, String> param = new HashMap<String, String>();
				param.put("data", data);
				param.put("method", "FindStatusQuery");
				result = HttpXmlClient.post(url, param);
				logger.info("查询成功");
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("服务器异常", e);
			}
		} else {
			or.setErrMsg("当前版本较低,请更新版本！");
			or.setErrCode(ReturnCode.STATUS_500);
			result = gson.toJson(or);
			return result;
		}
		return result;
	}

	@Override
	public String findMonthStatus(String omsMasterId, String date) {
		Gson gson = new Gson();
		String result = "";
		try {
			String url = Util.getProperty("dmsurl");
			url = url + "/dispatch";
			Map<String, String> params = new HashMap<String, String>();
			params.put("omsMasterId", omsMasterId);
			params.put("date", date);
			String data = gson.toJson(params);
			Map<String, String> param = new HashMap<String, String>();
			param.put("data", data);
			param.put("method", "findMonthStatus");
			result = HttpXmlClient.post(url, param);
			logger.info("查询成功");
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			logger.error("服务器异常", e);
		}
		return result;
	}

}

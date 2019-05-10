package com.easyhome.service.fws.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.dao.AppMessageDao;
import com.easyhome.po.Version;
import com.easyhome.service.fws.SupplyServiceI;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service
public class SupplyServiceImpl implements SupplyServiceI {
	private static final Logger logger = Logger.getLogger(SupplyServiceImpl.class);

	@Resource
	private AppMessageDao appMessageDao;
	private static final Gson gson = new Gson();
	private static BaseResponse response = new BaseResponse();

	/**
	 * 发送验证码
	 */
	@Override
	public BaseResponse sendCode(HttpServletRequest request, String phone) {
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "master";
			Map<String, String> param = new HashMap<String, String>();
			param.put("ebtePhoneNo", phone);
			String json = gson.toJson(param);
			Map<String, String> par = new HashMap<String, String>();
			par.put("data", json);
			par.put("method", "findPhone");
			// 请求方法
			String string = HttpXmlClient.post(url, par);
			response = gson.fromJson(string, BaseResponse.class);

			//url = ResourcesUtil.getValue("config", "smsurl");
			if (response.getReturnCode() == 200) {
				int code = (int) ((Math.random() * 9 + 1) * 100000);
				
				//String content = "验证码:" + code + "," + "有效期为30分钟。";
				HttpSession session = request.getSession();
				session.setAttribute("code", code);
				/*
				Map<String, String> params = new HashMap<String, String>();
				params.put("mobile", phone);
				params.put("content", content);
				String post = HttpXmlClient.post(url, params);
				*/
				String content = code+"";
				AliyunSMS.sendMsgToPhone(phone, "SMS_137416477", content);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo("发送成功");
				response.setData(content);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 版本升级
	 */
	@Override
	public BaseResponse UpdateVersion(String phone, String appVersion) {
		try {
			// 判断是否是灰度发布用户
			Version version_2 = appMessageDao.findVersion(4);// 灰度发布版本
			Version version_1 = appMessageDao.findVersion(3);// 普通升级版本
			// 灰度用户升级
			if (version_2 != null) {
				String app_version_2 = version_2.getAppVersion();
				double new_version_2 = Double.parseDouble(app_version_2);
				double old_version = Double.parseDouble(appVersion);
				List<String> user = appMessageDao.findPhone();
				// 是灰度发布用户，不是最新版本，提示更新
				if (user.contains(phone) == true) {
					if (new_version_2 > old_version) {
						version_2.setFlag(1);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_2);
						response.setInfo(ReturnCode.OK);
						logger.info("灰度用户更新成功");
					} else {
						version_2.setFlag(0);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_2);
						response.setInfo("不需要升级");
						logger.info("不需要升级");
					}
				} else {
					// 不是灰度发布用户，检查版本是否是最新版本
					String app_version_1 = version_1.getAppVersion();
					double new_version_1 = Double.parseDouble(app_version_1);
					if (new_version_1 > old_version) {
						version_1.setFlag(1);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_1);
						response.setInfo(ReturnCode.OK);
						logger.info("大众版本更新成功");
					} else {
						version_1.setFlag(0);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_1);
						response.setInfo(ReturnCode.OK);
						logger.info("不需要升级");
					}
				}
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo(ReturnCode.FAIL);
			logger.error("获取数据异常！", e);
		}
		return response;
	}
}

package com.easyhome.controller.oms;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.utils.AliyunSMS;

/**
 * 
 */
@RestController
@RequestMapping("/oms/code")
public class CodeController {
	private static final Logger logger = Logger.getLogger(CodeController.class);

	@RequestMapping("/getCode")
	public Map<String, Object> getCode(String phone) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String code = random(4);
			/*
			String url = Util.getProperty("smsurl");
			Map<String, String> params = new HashMap<String, String>();
			params.put("mobile", phone);
			params.put("content", "您好，您本次注册的验证码为："+code+",请妥善保管");
			String post = HttpXmlClient.post(url, params);
			*/
			AliyunSMS.sendMsgToPhone(phone, "SMS_137421474", code);
			
			result.put("errCode", "0");
			result.put("errMsg", "");
			result.put("CODE",code);
		} catch (Exception e) {
			logger.error("获取验证码异常", e);
			result.put("errCode", "-1");
			result.put("errMsg", "获取验证码异常");
		}
		return result;
	}

	public String random(int num) {
		Random random = new Random();
		// 初始化种子
		String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		int number = str.length;
		// 接收随机字符
		String text = "";
		// 随机产生4个字符的字符串
		for (int i = 0; i < num; i++) {
			text += str[random.nextInt(number)];
		}
		return text;
	}
}

package com.easyhome.service.oms.impl;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.po.oms.AppointmentRequest;
import com.easyhome.service.oms.AppointmentService;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppointmentServiceImpl.class);

	public String appiontWorker(AppointmentRequest request){
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		
		try {
			String date = request.getDate()==null?"":request.getDate();
			//设置请求参数
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("masterid", request.getOmsMasterId());
			params.put("workorderid", request.getWorkorderid());
			params.put("linkman",request.getLinkman());
			params.put("address",request.getAddress());
			params.put("phone",request.getPhone());
			params.put("status",request.getStatus());
			params.put("reason",request.getReason());
			params.put("date",date);
			params.put("call",request.getCall());
			params.put("timeQuantum",request.getTimeQuantum());
			String resultJson = OmsConnectUtil.getData("appBespokeDispatch", params);
			//接口改造
			logger.info(resultJson);
			String json = resultJson.replace("errCode", "returnCode").replace("errMsg", "info");
			logger.info(json);
			return json;
		} catch (Exception e) {
			response.setInfo("服务端异常");
			response.setReturnCode(500);
			e.printStackTrace();
		}
		return gson.toJson(response);
	}

	@Override
	public BaseResponse reSendSmsCode(String code, String phone) {
		BaseResponse br = new BaseResponse();
		br.setReturnCode(500);
		br.setInfo("位置错误异常");
		//发送短信验证码
		try {
			if(code!=null && !"".equals(code) && phone!=null && !"".equals(phone)){
				/*
				String url = Util.getProperty("smsurl");
				Map<String, String> msg = new HashMap<String, String>();
				msg.put("mobile", phone);
				msg.put("content", "请您妥善保存服务确认码 "+code+",并在服务完成后提供给师傅。");
				String post = HttpXmlClient.post(url, msg);
				logger.info("短信发送结果：" + post);
				*/
				String content = code;
				AliyunSMS.sendMsgToPhone(phone, "SMS_137421430", content);
				br.setReturnCode(200);
				br.setInfo("发送验证码成功");
				
				br.setReturnCode(200);
				br.setInfo("发送验证码成功");
			}
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("服务端异常");
		}
		
		return br;
	}

}

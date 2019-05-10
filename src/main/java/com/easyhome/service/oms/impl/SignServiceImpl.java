package com.easyhome.service.oms.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.oms.SignRequest;
import com.easyhome.service.oms.SignService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Service
public class SignServiceImpl implements SignService {

	private static final Logger logger = Logger.getLogger(SignServiceImpl.class);

	@Override
	public String signWorker(SignRequest sign) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		response.setInfo("未知异常");
		response.setReturnCode(500);
		if(sign.getWorkorderid()==null||"".equals(sign.getWorkorderid())){
			response.setInfo("请输入工单ID");
			response.setReturnCode(400);
		}else if(sign.getOmsMasterId()==null||"".equals(sign.getOmsMasterId())){
			response.setInfo("请输入签到人的ID");
			response.setReturnCode(400);
		}else{
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("masterid",sign.getOmsMasterId());
			params.put("workorderid", sign.getWorkorderid());
			params.put("signerid",sign.getOmsMasterId());
			params.put("signer",sign.getSigner());
			params.put("type",sign.getType());
			params.put("lat",sign.getLat());
			params.put("lng",sign.getLng());
			params.put("code",sign.getCode());
			params.put("address",sign.getAddress());
			
			logger.info("===========================================================");
			logger.info(gson.toJson(params));
			logger.info("===========================================================");
			
			String resultJson = OmsConnectUtil.getData("appHomeSign", params);
			
			logger.info("===========================================================");
			logger.info(resultJson);
			logger.info("===========================================================");
			//数据修正
			String json = resultJson.replace("errCode", "returnCode").replace("errMsg", "info");
			logger.info(json);
			return json;
		}

		return gson.toJson(response);
	}

	@Override
	public BaseResponse signWorkerByMessage(SignRequest signByMessage) {
		Gson gson = new Gson();
		BaseResponse response = new BaseResponse();
		//未输入工号
		if(signByMessage.getWorkorderid()==null||"".equals(signByMessage.getWorkorderid())){
			response.setInfo("请输入工单ID");
			response.setReturnCode(400);
			return response;
		}
		
		//未输入电话
		if(signByMessage.getPhone()==null||"".equals(signByMessage.getPhone())){
			response.setInfo("请输入电话");
			response.setReturnCode(400);
			return response;
		}
		String mobile=signByMessage.getPhone();
		
		String content="签到验证码："+getResetPwd()+"。技师上门签到时请出示给技师验证。";
		String result = null;
		try{
			Map<String, Object> params = new HashMap<String,Object>();
			params.put("masterid",signByMessage.getOmsMasterId());
			params.put("workorderid", signByMessage.getWorkorderid());//对调后添加的参数
			params.put("phone", mobile);
			params.put("content", content);
		   String data = OmsConnectUtil.getData("appSendMsgToPhone", params);

		   response.setReturnCode(ReturnCode.STATUS_200);
		   response.setInfo("短信验证码发送成功");
		     logger.info("接口返回数据："+data);
		}catch(Exception e){  
			logger.error("短信接口连接失败",e); 
			response.setReturnCode(ReturnCode.STATUS_400);
         	response.setInfo("短信发送失败，请稍后重试");
		}
		return response;
	}
	
	public static String getResetPwd(){
		Random random = new Random();
		String result = "";
		for(int i=0;i<4;i++){
			result+=random.nextInt(10);
			
		}
		return result;
	}

	

}

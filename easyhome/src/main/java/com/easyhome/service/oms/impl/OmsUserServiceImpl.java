package com.easyhome.service.oms.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.po.TbAppUser;
import com.easyhome.po.TbMaster;
import com.easyhome.po.oms.AlterPasswordRequest;
import com.easyhome.po.oms.AppIncomeListRequestEntity;
import com.easyhome.po.oms.AppUpdateMasterPicRequestEntity;
import com.easyhome.po.oms.AppUpdatePhoneRequest;
import com.easyhome.po.oms.LoginRequest;
import com.easyhome.po.oms.RegisterRequest;
import com.easyhome.po.oms.UpdatePasswordRequest;
import com.easyhome.po.oms.VisitorBean;
import com.easyhome.service.UserService;
import com.easyhome.service.oms.OmsUserService;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.MD5;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.utils.Util;
import com.easyhome.vo.AutherizedInfoResponse;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.OrderResult;
import com.easyhome.vo.oms.LoginResponseOms;
import com.easyhome.vo.oms.LoginResponseResultCustom;
import com.easyhome.vo.oms.LoginResponseResultOms;
import com.easyhome.vo.oms.LoginResponseSoms;
import com.google.gson.Gson;

@Service("omsUserService")
public class OmsUserServiceImpl implements OmsUserService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsUserServiceImpl.class);
	
	@Autowired
	private UserService userService;

	
	@SuppressWarnings("unused")
	@Override
	public BaseResponse login(LoginRequest request) {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		
		
		try {
			if(!Util.isEmpty(request.getPhone(),request.getPassword())){
				logger.info("登录手机号码：" + request.getPhone());
				
				LoginResponseSoms lr = new LoginResponseSoms();
				
				String loginJson = getOmsLoginInfo(request);
				logger.info("登录数据："+loginJson);
				
				//解析数据
				LoginResponseResultCustom lc = new LoginResponseResultCustom();
				LoginResponseOms fromJson = gson.fromJson(loginJson, LoginResponseOms.class);
				
				if(fromJson!=null && ("0".equals(fromJson.errCode) || "2".equals(fromJson.errCode)||"200".equals(fromJson.errCode))){//登录成功
					return parseBaseResponse(br, loginJson, lc, fromJson);
				}else{//登录失败
					br.setReturnCode(499);
					br.setInfo(fromJson.errMsg);
				}
				
			}else{
				br.setReturnCode(400);
				br.setInfo("账号或密码不能为空");
			}
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("数据获取异常");
			logger.error("数据获取异常",e);
		}
		return br;
	}


	/**
	 * 
	 * <p>description: 解析并构造返回数据</p>
	 * @param br
	 * @param loginJson
	 * @param lc
	 * @param fromJson
	 * @return
	 * @date 2016年8月2日 下午5:32:10
	 */
	private BaseResponse parseBaseResponse(BaseResponse br, String loginJson, LoginResponseResultCustom lc,
			LoginResponseOms fromJson) {
		
		LoginResponseResultOms result = fromJson.result;
		
		try {
			//构造返回对象
			lc.DRIVER_ID = result.DRIVER_ID;
			lc.OMS_FID = result.FID;
			lc.IS_MODIFY_PWD = result.IS_MODIFY_PWD;
			lc.NAME = result.NAME;
			lc.PHONE = result.PHONE;
			lc.PLAT_FROM_ID = result.PLAT_FROM_ID;
			lc.PLAT_FROM_NAME = result.PLAT_FROM_NAME;
			lc.USER_TYPE = result.USER_TYPE;
			lc.OMS_MASTER_ID = result.MASTER_ID;
			lc.authenticateCode = result.authenticateCode;
			lc.enableCode = result.enableCode;
			lc.isReviewFlag = result.isReviewFlag;
			lc.supplierCode = result.supplierCode;
			try {
				
				logger.info("手机号码"+result.PHONE);
				
				TbAppUser appUser = userService.findTbAppUserByPhone(result.PHONE);
				
				//登录表信息存在取登录表中的数据，不存在则取技师表中的数据，都不存在则写0
				if(appUser!=null){ //登录表信息存在
					lc.MASTER_ID = appUser.getMasterId();
					lc.FID = appUser.getFid();
				}else{ //登录表信息不存在
					TbMaster master = userService.findMasterByPhone(result.PHONE);
					if(master!=null){
						lc.MASTER_ID = master.getFid();
					}else{
						lc.MASTER_ID = "0";
					}
					
					lc.FID = "0";
				}
			} catch (Exception e) {
				lc.MASTER_ID = "0";
				lc.FID = "0";
			}
			br.setReturnCode(200);
			br.setInfo(fromJson.errMsg);
			br.setData(lc);
			logger.info("登录成功");
			logger.info("登录数据："+loginJson);
			return br;
		} finally { //加速内存回收
			loginJson = null;
			lc = null;
			fromJson = null;
			result = null;
			br = null;
		}
	}


	/**
	 * 
	 * <p>description: 获取oms登录数据</p>
	 * @param request
	 * @return
	 * @date 2016年8月2日 下午5:26:38
	 */
	private String getOmsLoginInfo(LoginRequest request) {
		String methodName="appUserLogin";
		//设置参数
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("phone", request.getPhone());
		String password = MD5.MD5Encode(request.getPassword()).substring(8, 24);
		data.put("password", password);
		//请求数据
		String loginJson = OmsConnectUtil.getData(methodName, data);
		return loginJson;
	}
	
	
	/**
	 * 注册
	 */
	public OrderResult register(RegisterRequest request) {
		OrderResult result=new OrderResult();
		Map<String ,String>map=new HashMap<>();
		try {
			if(request!=null){
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("phone",request.getPhone());
				params.put("sex",request.getSex());
				params.put("name",request.getName());
				params.put("verificatecode",request.getCode());
				params.put("masterfrom",request.getFrom());
				params.put("age",request.getAge());
				params.put("chat",request.getChat());
				params.put("identitycard",request.getIdentitycard());
				params.put("city",request.getArea());
				params.put("worktype",request.getWorktypes());
				
				// fix bug#570
				params.put("team", request.getTeam());//是否带队
				params.put("teamnum", request.getTeamnum());//带队人数
				params.put("cityDeliveryStatus", request.getCityDeliveryStatus());//是否同城配送
				params.put("cartype", request.getCartype());//车型
				
				params.put("havecar","是".equals(request.getCar())?"1":"0");
				params.put("havetools","有".equals(request.getTools())?"1":"0");
				params.put("havainsurance","有".equals(request.getInsurance())?"1":"0");
				params.put("servicearea",request.getDistrict());
				params.put("bankaccount",request.getBankaccount());
				params.put("bank_name",request.getBankname());
				params.put("branch",request.getBranch());
				params.put("banknumber",request.getBanknumber());
				params.put("soslinkman",request.getSoslinkman());
				params.put("relationship",request.getRelationship());
				params.put("provincename", request.getProvincename());
				params.put("cityname", request.getCityname());
				String [] districtname = request.getDistrictname().split(",");
				params.put("districtname",districtname);
				params.put("linkphone",request.getLinkphone());
				params.put("image1",request.getImages1());
				params.put("image2",request.getImages2());
				params.put("image3",request.getImages3());
				params.put("remark",request.getRemark());
				params.put("referee",request.getReferee());
				params.put("refer_phone",request.getRefereephone());
				params.put("password",request.getPassword());
				params.put("area",request.getArea());
				String methodName="appUserRegister";
				String data = OmsConnectUtil.getData(methodName, params);
				logger.debug("============================== 注册数据结果数据 ===============================");
				logger.debug(data);
				if(data!=null){
					JSONObject resultJson = JSONObject.fromObject(data);
					if(resultJson.containsKey("errCode")){
						int errCode = resultJson.getInt("errCode");
						if(errCode == 0){
							JSONObject res = resultJson.getJSONObject("result");
							map.put("MASTER_NO",res.getString("ebteWorkNo"));
							result.setErrCode(0);
							result.setErrMsg("注册成功");
							result.setResult(map);
							logger.info("注册成功");
						}else{
							result.setErrCode(-1);
							result.setErrMsg(resultJson.getString("errMsg"));
							result.setResult(0);
							logger.info("重复注册");
						}
					}else{
						result.setErrCode(-1);
						result.setErrMsg(resultJson.getString("errMsg"));
						result.setResult(0);
						logger.info("请检查后重新输入");
					}
				}else{
					result.setErrCode(-1);
					result.setErrMsg("获取结果异常");
					result.setResult(0);
					logger.info("请检查后重新输入");
				}
				
			}else{
				result.setErrCode(-1);
				result.setErrMsg("请检查后重新输入");
				result.setResult(0);
				logger.info("请检查后重新输入");
			}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常",e);
		}
		return result;
	}
	
	/**
	 * 更新用户身份证、头像照片
	 */
	public String updateMasterPic(AppUpdateMasterPicRequestEntity request) {
		OrderResult result = new OrderResult();
		Gson gson = new Gson();
		try {
			return OmsConnectUtil.getData("appUpdateMasterPic", gson.toJson(request));
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("请求失败");
			return gson.toJson(result);
		}
	}
	
	/**
	 * 修改密码
	 */
	public String updatePassword(UpdatePasswordRequest request){
		logger.info(request);
		Gson gson = new Gson();
		OrderResult result=new OrderResult();
		try {
				Map<String ,Object> params=new HashMap<String ,Object>();
				String md5_pwd = MD5.MD5Encode(request.getOldPassword()).substring(8,24);
				String new_pwd = MD5.MD5Encode(request.getPassword()).substring(8,24);
				params.put("userid", request.getUserid());
				params.put("oldpassword", md5_pwd);
				params.put("password", new_pwd);
				String methodName="appChangePassword";
				String data = OmsConnectUtil.getData(methodName, params);
				logger.info(data);
				return data;
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常",e);
		}
		return gson.toJson(result);
	}
	/**
	 * 忘记密码
	 */
	@Override
	public String AlterPassword(AlterPasswordRequest request) {
		OrderResult result=new OrderResult();
		Gson gson = new Gson();
		try {
			if(/*request.getPassword()!=null 
			 && !"".equals(request.getPassword())
			 &&*/ request.getCode()!=null 
			 && !"".equals(request.getCode())){
				Map<String ,Object> params=new HashMap<String ,Object>();
				String md5_pwd = MD5.MD5Encode(request.getPassword()).substring(8,24);
				params.put("phone", request.getPhone());
				params.put("code", request.getCode());
				params.put("password", md5_pwd);
				params.put("isPassword", request.getIsPassword());
				String methodName="appForgetPassword";
				String data = OmsConnectUtil.getData(methodName, params);
				logger.info(data);
				return data;
				}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常",e);
		}
		return gson.toJson(result);
	}


	@Override
	public String getForgetPassCheckCode(String phone, String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		try {
			//保存验证码
			Map<String, Object> params = new HashMap<String, Object>();

			Random random = new Random();
			String authcode="";
			for (int i=0;i<6;i++)
			{
				authcode+=random.nextInt(10);
			}
			params.put("phone", phone);
			params.put("code", authcode);
			String data = OmsConnectUtil.getData("appRecVerificateCode", params);
			
			/*//发送短信验证码
			if(code!=null && !"".equals(code)){
				
				String url = Util.getProperty("smsurl");
				Map<String, String> msg = new HashMap<String, String>();
				msg.put("mobile", phone);
				msg.put("content", "您的验证码为："+code+" 请勿告诉他人");
				String post = HttpXmlClient.post(url, msg);
				
				AliyunSMS.sendMsgToPhone(phone, "SMS_137421474", code);
				logger.info("短信发送结果：" + code);
				logger.info(data);
			}*/
			return data;
		} catch (Exception e) {
			map.put("errCode", "500");
			map.put("errMsg", "发送验证码失败，请稍后重试");
		}
		return gson.toJson(map);
	}


	@Override
	public String sendRegisterCheckCode(String phone) {
		//保存验证码
		Gson gson = new Gson();
		OrderResult or = new OrderResult();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("phone", phone);
			String data = OmsConnectUtil.getData("appRegSendCodeToPhone", params);
			return data;
		} catch (Exception e) {
			or.setErrCode(-1);
			or.setErrMsg("获取验证码异常");
		}
		
		return gson.toJson(or);
	}


	/*@Override
	public String masterIncome(String masterId, String month) {
		//保存验证码
		Gson gson = new Gson();
		OrderResult or = new OrderResult();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterId", masterId);
			params.put("month", month);
			String data = OmsConnectUtil.getData("masterIncome", params);
			return data;
		} catch (Exception e) {
			or.setErrCode(-1);
			or.setErrMsg("获取收益数据失败");
		}
		return gson.toJson(or);
	}*/
	/**
	 * 我的钱包
	 * @param request
	 * @return
	 */
	@Override
	public String masterIncome(AppIncomeListRequestEntity request) {
		Gson gson = new Gson();
		try {
			String data = OmsConnectUtil.getData("masterIncome", gson.toJson(request));
			data = data.replace("errCode", "returnCode").replace("errMsg", "info").replace("result", "data");
			return data;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}

	@Override
	public String appChangePhoneNumber(AppUpdatePhoneRequest request) {
		logger.info(request);
		Gson gson = new Gson();
		OrderResult result=new OrderResult();
		try {
			Map<String ,Object> params=new HashMap<String ,Object>();
			params.put("masterid", request.getMasterid());//技师代码
			params.put("phoneno", request.getPhoneno());//注册手机号
			params.put("authcode", request.getAuthcode());//验证码
			String methodName="appChangePhone";
			String data = OmsConnectUtil.getData(methodName, params);
			logger.info(data);
			return data;
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常",e);
		}
		return gson.toJson(result);
	}


	/***
	 * 注册或修改手机号时发送验证码
	 * @param request
	 * @return
	 */
	@Override
	public String appGetAuthCodeapp(VisitorBean request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		try {
			//保存验证码
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("phoneno", request.getPhoneno());
			Random random = new Random();
			String authcode="";
			for (int i=0;i<6;i++)
			{
				authcode+=random.nextInt(10);
			}
			params.put("authcode", authcode);
			params.put("type", request.getType());
			
			String data = OmsConnectUtil.getData("appGetAuthCodeapp", params);
			
			return data;
		} catch (Exception e) {
			map.put("returnCode", "-1");
			map.put("info", "发送验证码失败，请稍后重试");
		}
		return gson.toJson(map);
	}
	



	@Override
	public BaseResponse appVisitorRegister(
			VisitorBean visitorBean) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData("");
		if(!Util.isEmpty(visitorBean.getPhoneno(),visitorBean.getPassword(),
				visitorBean.getAuthcode())){
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("phoneno", visitorBean.getPhoneno());
			params.put("password", MD5.MD5Encode(visitorBean.getPassword()).substring(8, 24));
			params.put("authcode", visitorBean.getAuthcode());
			String methodName = "appVisitorRegister";
			String data = OmsConnectUtil.getData(methodName, params);
			if(data != null){
				JSONObject resultJson = JSONObject.fromObject(data);
				baseResponse.setReturnCode(resultJson.getInt("returnCode"));
				baseResponse.setInfo(resultJson.getString("info"));
			}else{
				baseResponse.setReturnCode(-1);
				baseResponse.setInfo("注册失败");
			}
		}else{
			baseResponse.setReturnCode(-1);
			baseResponse.setInfo("注册手机号或登录密码或验证码不能为空");
		}
		return baseResponse;
	}

	/**
	 * 查看技师是否审核
	 * @param masterid
	 * @return
	 */
	@Override
	public AutherizedInfoResponse appGetAutherizedInfo(String masterid) {
	 
		AutherizedInfoResponse autherizedInfoResult=new AutherizedInfoResponse();
		 
		if(!Util.isEmpty(masterid)) {
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterid", masterid);
			String methodName = "appGetAutherizedInfo";
			String data = OmsConnectUtil.getData(methodName, params);
			if(data != null){
				JSONObject resultJson = JSONObject.fromObject(data);
				
				autherizedInfoResult.setReturnCode(resultJson.getInt("returnCode"));
				autherizedInfoResult.setInfo(resultJson.getString("info"));
				//autherizedInfoResult.setIsReviewFlag(resultJson.getString("isReviewFlag"));
				Map<String,Object> result = new HashMap<String,Object>();
				result.put("isReviewFlag", resultJson.getString("isReviewFlag"));
				
				autherizedInfoResult.setResult(result);
			} 
		}else {
			autherizedInfoResult.setReturnCode(-1);
			autherizedInfoResult.setInfo("技师代码不能为空");
		}
		
		return autherizedInfoResult;
	}


}
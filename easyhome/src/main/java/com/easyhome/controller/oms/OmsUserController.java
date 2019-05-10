package com.easyhome.controller.oms;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.po.oms.AlterPasswordRequest;
import com.easyhome.po.oms.AppIncomeListRequestEntity;
import com.easyhome.po.oms.AppUpdateMasterPicRequestEntity;
import com.easyhome.po.oms.LoginRequest;
import com.easyhome.po.oms.RegisterRequest;
import com.easyhome.po.oms.UpdatePasswordRequest;
import com.easyhome.po.oms.AppUpdatePhoneRequest;
import com.easyhome.po.oms.VisitorBean;
import com.easyhome.service.oms.OmsUserService;
import com.easyhome.vo.AutherizedInfoResponse;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.OrderResult;
import com.google.gson.Gson;

/**
 * <p>title: OmsUserController</p>
 * <p>description: APP用户操作控制器</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月15日 上午9:41:25
 */
@RestController
@RequestMapping("/oms/user")
public class OmsUserController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsUserController.class);

	@Resource
	private OmsUserService omsUserService;
	
	/**
	 * 登录
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping("/Login")
	public BaseResponse login(LoginRequest request){
		BaseResponse br = new BaseResponse();
		try {
			br = omsUserService.login(request);
		} catch (Exception e) {
			br.setInfo("未知错误异常");
			br.setReturnCode(500);
		}
		return br;
	}
	
	/**
	 * 注册
	 * @param request
	 * @return
	 */
	@RequestMapping("/register")
	public OrderResult register(RegisterRequest request){
		OrderResult OrderResult = omsUserService.register(request);
		return OrderResult;
	}
	/**
	 * 查看技师审核状态
	 * @param masterid
	 * @return
	 */
	@RequestMapping("/appGetAutherizedInfo")
	public AutherizedInfoResponse appGetAutherizedInfo(String masterId){
		AutherizedInfoResponse OrderResult = omsUserService.appGetAutherizedInfo(masterId);
		return  OrderResult;
	}
	
	/**
	 * 更新用户身份证、头像照片
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateMasterPic")
	public String updateMasterPic(AppUpdateMasterPicRequestEntity request) {
		return omsUserService.updateMasterPic(request);
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("/updatePassword")
	public String updatePassword(UpdatePasswordRequest request){
		String OrderResult=omsUserService.updatePassword(request);
		return OrderResult;
	}
	
	/**
	 * 忘记密码
	 * @param phone
	 * @param password
	 * @param captcha
	 * @return
	 */
	@RequestMapping("/AlterPassword")
	public String AlterPassword(AlterPasswordRequest request) {
		String OrderResult=omsUserService.AlterPassword(request);	
		return OrderResult;
	}
	
	/**
	 * <p> Description: 忘记密码发送验证码</p>
	 * 
	 * @date 2016年7月6日 上午12:33:06
	 * @version 1.0
	 * @param phone
	 * @param code
	 * @return
	 */
	@RequestMapping("/getForgetPassCheckCode")
	public String getForgetPassCheckCode(String phone,String code){
		String result = omsUserService.getForgetPassCheckCode(phone,code);
		return result;
	}
	
	/**
	 * <p> Description: 注册短信</p>
	 * 
	 * @date 2016年7月10日 上午10:22:30
	 * @version 1.0
	 * @param phone
	 * @return
	 */
	@RequestMapping("/sendRegisterCheckCode")
	public String sendRegisterCheckCode(String phone){
		logger.info("注册手机："+phone);
		OrderResult or = new OrderResult();
		Gson gson = new Gson();
		try {
			String orr = omsUserService.sendRegisterCheckCode(phone);
			logger.info(orr);
			return orr;
		} catch (Exception e) {
			or.setErrCode(-1);
			or.setErrMsg("未知错误异常");
		}
		return gson.toJson(or);
	}
	
	/*@RequestMapping("/masterIncome")
	public String masterIncome(String masterId,String month){
		logger.info("技师id："+masterId);
		logger.info("请求月份："+month);
		OrderResult or = new OrderResult();
		Gson gson = new Gson();
		try {
			String orr = omsUserService.masterIncome(masterId,month);
			logger.info(orr);
			return orr;
		} catch (Exception e) {
			or.setErrCode(-1);
			or.setErrMsg("未知错误异常");
		}
		return gson.toJson(or);
	}*/
	/**
	 * 我的钱包
	 * @param request
	 * @return
	 */
	@RequestMapping("/masterIncome")
	public String masterIncome(AppIncomeListRequestEntity request) {
		return omsUserService.masterIncome(request);
	}
	
	/**
	 * 技师修改手机号
	 * @param request
	 * @return
	 */
	@RequestMapping("/appChangePhoneNumber")
	public String appChangePhoneNumber(AppUpdatePhoneRequest request) {
		return omsUserService.appChangePhoneNumber(request);
	}
 
	/***
	 * 注册或修改手机号时发送验证码
	 * @param request
	 * @return
	 */
	@RequestMapping("/appGetAuthCode")
	public String appGetAuthCodeapp(VisitorBean request) {
		
		return omsUserService.appGetAuthCodeapp(request);
	}
 
	/**
	 * app技师注册
	 * @param visitorBean
	 * @return
	 */
	@RequestMapping(value="/appVisitorRegister")
	public BaseResponse appVisitorRegister(VisitorBean visitorBean){
		return omsUserService.appVisitorRegister(visitorBean);
	}
 
}
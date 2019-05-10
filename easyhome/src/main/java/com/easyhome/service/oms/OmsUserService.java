package com.easyhome.service.oms;

import com.easyhome.po.oms.AlterPasswordRequest;
import com.easyhome.po.oms.AppIncomeListRequestEntity;
import com.easyhome.po.oms.AppUpdateMasterPicRequestEntity;
import com.easyhome.po.oms.LoginRequest;
import com.easyhome.po.oms.RegisterRequest;
import com.easyhome.po.oms.UpdatePasswordRequest;
import com.easyhome.po.oms.AppUpdatePhoneRequest;
import com.easyhome.po.oms.VisitorBean;
import com.easyhome.vo.AutherizedInfoResponse;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.OrderResult;


/**
 * 
 * <p> Title: OmsUserService</p>
 * <p> Description: oms用户操作</p>
 * 
 * @date 2016年7月2日 上午11:57:12
 * @version 1.0
 *
 */
public interface OmsUserService {

	/**
	 * <p> Description: oms对接登录</p>
	 * 
	 * @date 2016年7月2日 上午11:56:58
	 * @version 1.0
	 * @param request
	 * @return
	 */
	BaseResponse login(LoginRequest request);

	OrderResult register(RegisterRequest request);
	
	AutherizedInfoResponse appGetAutherizedInfo(String masterid);
	
	/**
	 * 更新用户身份证、头像照片
	 * @param request
	 * @return
	 */
	String updateMasterPic(AppUpdateMasterPicRequestEntity request);

	String updatePassword(UpdatePasswordRequest request);

	String AlterPassword(AlterPasswordRequest request);
	/**
	 * 
	 * <p> Description: 忘记密码发送短信</p>
	 * 
	 * @date 2016年7月6日 上午12:38:30
	 * @version 1.0
	 * @param phone
	 * @param code
	 * @return
	 */
	String getForgetPassCheckCode(String phone, String code);
	
	/**
	 * 
	 * <p> Description: 发送注册验证码</p>
	 * 
	 * @date 2016年7月10日 上午10:23:49
	 * @version 1.0
	 * @param phone
	 * @return
	 */
	String sendRegisterCheckCode(String phone);
	
	/**
	 * 获取技师收益OMS
	 * @param masterId
	 * @param month
	 * @return
	 */
	/*String masterIncome(String masterId, String month);*/
	/**
	 * 我的钱包
	 * @param request
	 * @return
	 */
	String masterIncome(AppIncomeListRequestEntity request);
	/***
	 * 注册或修改手机号时发送验证码
	 * @param request
	 * @return
	 */
	String appGetAuthCodeapp(VisitorBean request);
	/**
	 * app 技师注册
	 * @param visitorRegisterBean
	 * @return
	 */
	BaseResponse appVisitorRegister(VisitorBean visitorBean);
	
	/**
	 * 技师修改手机号
	 * @param request
	 * @return
	 */
	String appChangePhoneNumber(AppUpdatePhoneRequest request);
	
}


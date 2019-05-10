package com.easyhome.service.fws;

import javax.servlet.http.HttpServletRequest;

import com.easyhome.vo.BaseResponse;

public interface SupplyServiceI {
	/**
	 * 
	* @Title: sendCode 
	* @Description: TODO 
	* @param request 发送短信验证码
	* @param phone
	* @return 
	* BaseResponse    
	* @throws 
	* @date 2017年6月6日 上午10:39:58
	 */
	BaseResponse sendCode(HttpServletRequest request, String phone);
	
	/**
	 * 
	* @Title: UpdateVersion 
	* @Description: TODO 版本升级更新
	* @param phone
	* @param appVersion
	* @return 
	* BaseResponse    
	* @throws 
	* @date 2017年6月6日 上午10:41:23
	 */
	BaseResponse UpdateVersion(String phone,String appVersion);
}

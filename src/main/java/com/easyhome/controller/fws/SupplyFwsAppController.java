package com.easyhome.controller.fws;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;
/**
 * 
* @ClassName: SupplyFwsAppController 
* @Description: TODO 服务商App补充接口控制层
* @date 2017年5月24日 下午2:13:00 
*
 */
@Controller
@RequestMapping(value="/fwsApp")
public class SupplyFwsAppController extends BaseFwsController{
	private static final Logger logger = Logger.getLogger(SupplyFwsAppController.class);
	
	/**
	 * 
	* @Title: findCaptcha 
	* @Description: TODO 发送验证码
	* @param request
	* @param phone
	* @return
	* @throws Exception 
	* BaseResponse    
	* @throws 
	* @date 2017年5月26日 下午5:08:10
	 */
	@ResponseBody
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public BaseResponse findCaptcha(HttpServletRequest request, String phone) throws Exception {
		BaseResponse response = this.supplyServiceI.sendCode(request, phone);
		return response;
	}
	/**
	 * 
	* @Title: execute 
	* @Description: TODO 服务商App版本升级
	* @param request
	* @return 
	* BaseResponse    
	* @throws 
	* @date 2017年5月26日 下午5:08:24
	 */
	@ResponseBody
	@RequestMapping(value="/updateVersion")
	public BaseResponse execute(HttpServletRequest request) {
		Gson gson = new Gson();
		String phone = request.getParameter("phone");
		String appVersion = request.getParameter("version");
		logger.info("phone=" + phone + ",appVersion=" + appVersion);
		BaseResponse response = supplyServiceI.UpdateVersion(phone,appVersion);
		logger.info("返回结果："+gson.toJson(response));
		return response;
	}
}

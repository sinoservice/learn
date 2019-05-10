package com.easyhome.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.easyhome.utils.Signature;
import com.easyhome.utils.Util;

public class AuthInterceptor implements HandlerInterceptor {

	Log log = LogFactory.getLog(AuthInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {

		boolean result = false;
		String model = request.getHeader("model");
		String release = request.getHeader("release");
		String version = request.getHeader("version");
		String sign = request.getHeader("sign");
		String phone = request.getHeader("phone");
		Map<String, Object> params = request.getParameterMap();
		String serverSign = Signature.getSign(params);
		String isTestServer = Util.getProperty("isTestServer");
		log.info("model:" + model + ",release=" + release + ",version="
				+ version + ",sign=" + sign + ",serverSign=" + serverSign+",phone="+phone);
		if (!Util.isEmpty(isTestServer) && "true".equals(isTestServer)) {
			result = true;
		} else {
			if (Util.isEmpty(version, model, release, sign)) {
				log.info("旧版本请求数据后期处理");
				// result = false;
			} else {
				if (sign.equals(serverSign)) {
					// 保存数据
					result = true;
				}
			}
		}

		return result;
	}

}

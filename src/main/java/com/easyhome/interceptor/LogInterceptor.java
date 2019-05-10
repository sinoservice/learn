package com.easyhome.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.easyhome.vo.tms.RequestModel;
import com.google.gson.Gson;

/**
 * 
 * @ClassName: LogInterceptor
 * @Description: TODO 日志拦截器
 * @date 2016年12月8日 下午3:12:59
 *
 */
public class LogInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(LogInterceptor.class);
	private static final String PARAMS = "";

	/**
	 * 获取请求的参数,设置处理请求的毫秒数,并放入线程局部变量中。
	 * 当执行完毕后,在MyResponseBodyAdvice中获取ResponseBody返回值和线程局部变量的值
	 * 做操作日志记录处理,此方法省去在每一个Controller方法中显示的调用保存操作日志
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {

			Gson gson = new Gson();
			HandlerMethod handlerMethod = (HandlerMethod) handler;

			// 获取参数
			String queryString = request.getQueryString();

			// 获取uri
			String uri = request.getRequestURI();

			System.out.println(uri);

			// 获取当前动作
			String method = uri.substring(25, uri.length());
		    System.out.println("调用的方法为"+method);

			// 获取url
			String url = request.getRequestURL().toString();

			// 拼接最终的url
			String lastUrl = url + "?" + queryString;

			// 获取参数
			Enumeration enu = request.getParameterNames();
			Map<String, String> map = new HashMap<String, String>();
			while (enu.hasMoreElements()) {
				String paraName = (String) enu.nextElement();
				System.out.println(paraName + ": " + request.getParameter(paraName));
				map.put(paraName, request.getParameter(paraName));
			}

			// model--将所要拦截的数据设置进去
			RequestModel requestModel = new RequestModel();
			requestModel.setParams(queryString);
			requestModel.setMethod(method);
			requestModel.setUrl(lastUrl);
			requestModel.setParams(gson.toJson(map));
			if(uri.contains("dms")){
				requestModel.setSysId("DMS系统");
			}else if(uri.contains("tmsApp")){
				requestModel.setSysId("TMS系统");
			}else if(uri.contains("oms")){
				requestModel.setSysId("OMS系统");
			}else{
				requestModel.setSysId("其他系统");
			}
			RequestModel.setRequestModel(requestModel);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		// Do Nothing.
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// Do Nothing.
	}
}

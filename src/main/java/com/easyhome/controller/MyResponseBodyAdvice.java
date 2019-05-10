package com.easyhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.easyhome.service.tms.TmsAppServiceI;
import com.easyhome.vo.tms.RequestModel;

//@ControllerAdvice(basePackageClasses={TmsAppController.class})
public class MyResponseBodyAdvice implements ResponseBodyAdvice<String> {

	@Autowired
	private TmsAppServiceI tmsAppService;
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

		// nothing to do
		return true;
	}

	@Override
	public String beforeBodyWrite(String result, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
       
		// 获取在ApiInterceptor对指定请求参数放如到线程局部变量的对象
		RequestModel model = RequestModel.getRequestModel();
		
		if(model != null){
			if(result != null){
				model.setResponse(result);
			}	
			
			// 移除线程局部变量,释放内存
			RequestModel.removeRequestModel();
			
			
			try {
				
				// 保存日志 调用霄鹏接口
				tmsAppService.saveLogs(model);
			} catch (Exception e) {
				//e.printStackTrace();
			}			
		}	
		return result;
	}

}

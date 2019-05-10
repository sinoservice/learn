package com.easyhome.vo.tms;

import java.io.Serializable;

public class RequestModel implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 * @date 2016年12月8日 下午2:40:13
	 */

	private static final long serialVersionUID = 1L;

	private static final ThreadLocal<RequestModel> REQUEST_MODEL = new ThreadLocal<>();
	 
	private String params;//请求参数
	
	private String url;//请求路径
	
	private String method;//请求方法
	
	private String response;//返回数据
	
	private String sysId;//系统标识

	public static RequestModel getRequestModel() {
		return REQUEST_MODEL.get();
	}

	public static void setRequestModel(RequestModel request) {
		REQUEST_MODEL.set(request);
	}

	public static void removeRequestModel() {
		REQUEST_MODEL.remove();
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}	
	
}

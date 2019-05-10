package com.easyhome.vo;

import java.util.List;

public class Result extends OrderResult{
	private Object complete;
	
	private List<Object> detail;

	public Object getComplete() {
		return complete;
	}

	public void setComplete(Object complete) {
		this.complete = complete;
	}

	public List<Object> getDetail() {
		return detail;
	}

	public void setDetail(List<Object> detail) {
		this.detail = detail;
	}
	
}

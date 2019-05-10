package com.easyhome.vo;

import java.util.List;

public class MyResponse extends BaseResponse{
    public List<Object> detail;
	public List<Object> getDetail() {
		return detail;
	}

	public void setDetail(List<Object> detail) {
		this.detail = detail;
	}

}

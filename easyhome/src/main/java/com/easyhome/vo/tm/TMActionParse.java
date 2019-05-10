package com.easyhome.vo.tm;

import java.util.List;

/**
 * 天猫订单解析
 *
 */
public class TMActionParse {

	private int returnCode;
	
	private String info;
	
	private List<TmOrderDetail> data;

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<TmOrderDetail> getData() {
		return data;
	}

	public void setData(List<TmOrderDetail> data) {
		this.data = data;
	}
	
}

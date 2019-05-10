package com.easyhome.po.oms;

import java.util.List;

public class WorkOrderComplate {

	private String time;
	
	private String remark;
	
	private List<Object> detail;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Object> getDetail() {
		return detail;
	}

	public void setDetail(List<Object> detail) {
		this.detail = detail;
	}
	
}

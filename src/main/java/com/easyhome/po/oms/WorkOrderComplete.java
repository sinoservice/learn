package com.easyhome.po.oms;

import java.util.List;

public class WorkOrderComplete {

	private String remark;
	
	private String time;
	
	private List detail;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List getDetail() {
		return detail;
	}

	public void setDetail(List detail) {
		this.detail = detail;
	}

}

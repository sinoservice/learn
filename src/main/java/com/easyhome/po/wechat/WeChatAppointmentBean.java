package com.easyhome.po.wechat;

public class WeChatAppointmentBean {
	
	private String openId;

	private String externalOrderNo;

	private String appointTime;

	private String periodOfAppoint;

	private String remark;
	
	private String taskNo;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getExternalOrderNo() {
		return externalOrderNo;
	}

	public void setExternalOrderNo(String externalOrderNo) {
		this.externalOrderNo = externalOrderNo;
	}

	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	public String getPeriodOfAppoint() {
		return periodOfAppoint;
	}

	public void setPeriodOfAppoint(String periodOfAppoint) {
		this.periodOfAppoint = periodOfAppoint;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
}

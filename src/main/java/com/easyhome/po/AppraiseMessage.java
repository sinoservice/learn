package com.easyhome.po;

public class AppraiseMessage {
	private String workorderid;//工单ID
	private Integer evalServiceComplete;//服务状态
	private Integer evalDelivery;//送货时效
	private Integer evalInstall;//安装质量
	private Integer evalPhoneBack;//电话回访
	public String getWorkorderid() {
		return workorderid;
	}
	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}
	public Integer getEvalServiceComplete() {
		return evalServiceComplete;
	}
	public void setEvalServiceComplete(Integer evalServiceComplete) {
		this.evalServiceComplete = evalServiceComplete;
	}
	public Integer getEvalDelivery() {
		return evalDelivery;
	}
	public void setEvalDelivery(Integer evalDelivery) {
		this.evalDelivery = evalDelivery;
	}
	public Integer getEvalInstall() {
		return evalInstall;
	}
	public void setEvalInstall(Integer evalInstall) {
		this.evalInstall = evalInstall;
	}
	public Integer getEvalPhoneBack() {
		return evalPhoneBack;
	}
	public void setEvalPhoneBack(Integer evalPhoneBack) {
		this.evalPhoneBack = evalPhoneBack;
	}
	
}

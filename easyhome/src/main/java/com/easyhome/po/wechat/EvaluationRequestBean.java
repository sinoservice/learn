package com.easyhome.po.wechat;

public class EvaluationRequestBean {
	
/*	dispatchNo	派工单号
	customerEval	客户评价
	dissatisfactionReason	不满意原因
	customerEvalRemark	评价备注
	image	图片信息*/

	private String openId;

	private String dispatchNo;

	private String customerEval;

	private String dissatisfactionReason;

	private String customerEvalRemark;
	
	private String image;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getDispatchNo() {
		return dispatchNo;
	}

	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	public String getCustomerEval() {
		return customerEval;
	}

	public void setCustomerEval(String customerEval) {
		this.customerEval = customerEval;
	}

	public String getDissatisfactionReason() {
		return dissatisfactionReason;
	}

	public void setDissatisfactionReason(String dissatisfactionReason) {
		this.dissatisfactionReason = dissatisfactionReason;
	}

	public String getCustomerEvalRemark() {
		return customerEvalRemark;
	}

	public void setCustomerEvalRemark(String customerEvalRemark) {
		this.customerEvalRemark = customerEvalRemark;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

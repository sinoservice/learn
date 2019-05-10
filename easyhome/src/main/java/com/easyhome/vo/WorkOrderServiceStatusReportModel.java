package com.easyhome.vo;

/**
 * 
 * <p>title: WorkOrderServiceStatusReportModel</p>
 * <p>description: 工单服务状态查询实体</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午4:02:09
 */
public class WorkOrderServiceStatusReportModel extends WorkOrderReportBaseBean {
	
	//private String fid;
	//private String workNo;
	//private String orderId;
	private String type;
	private String productQuantity;
	//private String statusDisplay;
	private String dispatchMemo;
	private String dispatchSn;
	//private String cusName;
	//private String cusAddress;
	//private String cusTel;
	//private String sender;
	//private String masterName;
	//private String masterPhone;
	//private String masterFrom;
	private String bookingStatus;
	private String remark;
	//private String outOrderSn;
	//private String billDate;
	//private String sendDate;
	//private String platFormName;
	//private String createTime;
	//private String bookingTime;
	private String singDate;
	private String singTime;
	private String completeDate;
	private String completeTime;
	private String customerEval;
	private String viewDate;
	private String viewTime;
	private String serviceFeedback;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getDispatchMemo() {
		return dispatchMemo;
	}
	public void setDispatchMemo(String dispatchMemo) {
		this.dispatchMemo = dispatchMemo;
	}
	public String getDispatchSn() {
		return dispatchSn;
	}
	public void setDispatchSn(String dispatchSn) {
		this.dispatchSn = dispatchSn;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSingDate() {
		return singDate;
	}
	public void setSingDate(String singDate) {
		this.singDate = singDate;
	}
	public String getSingTime() {
		return singTime;
	}
	public void setSingTime(String singTime) {
		this.singTime = singTime;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
	public String getCustomerEval() {
		return customerEval;
	}
	public void setCustomerEval(String customerEval) {
		this.customerEval = customerEval;
	}
	public String getViewDate() {
		return viewDate;
	}
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	public String getServiceFeedback() {
		return serviceFeedback;
	}
	public void setServiceFeedback(String serviceFeedback) {
		this.serviceFeedback = serviceFeedback;
	}
}

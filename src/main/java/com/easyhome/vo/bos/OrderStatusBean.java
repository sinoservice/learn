package com.easyhome.vo.bos;

import java.io.Serializable;

/**
 * 
 * <p>title: OrderStatusBean</p>
 * <p>description: BOS工单状态查询类</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年8月7日 下午3:02:25
 */
public class OrderStatusBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2061439741003690006L;
	
	private String fid;
	private String orderId;
	private String workNo;
	private int status;
	private String statusDisplay;
	private String masterName;
	private String masterPhone;
	private String createDate;
	private String sendDate;
	private String bookingDate;
	private String sginDate;
	private String completeDate;
	private String viewDate;
	private String orderType;
	
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public String getMasterPhone() {
		return masterPhone;
	}
	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getSginDate() {
		return sginDate;
	}
	public void setSginDate(String sginDate) {
		this.sginDate = sginDate;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getViewDate() {
		return viewDate;
	}
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	
}

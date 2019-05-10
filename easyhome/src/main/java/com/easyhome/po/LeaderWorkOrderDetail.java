package com.easyhome.po;

import java.util.List;

public class LeaderWorkOrderDetail {

	private String workId;
	private String workNo;
	private double amount;
	private String remark;
	private String sendTime;
	private String itemNum;
	
	private String bookingTime;
	private String cusName;
	private String cusAddress;
	private String cusPhone;
	
	private String workerName;
	private String workerPhone;
	
	private String signTime;
	
	private String complateTime;
	
	private int workStatus;
	
	private int isTransform;
	
	
	
	private List<LeaderWorkOrderItemEntity> workOrderItems;

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public String getComplateTime() {
		return complateTime;
	}

	public void setComplateTime(String complateTime) {
		this.complateTime = complateTime;
	}

	public int getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(int workStatus) {
		this.workStatus = workStatus;
	}


	public List<LeaderWorkOrderItemEntity> getWorkOrderItems() {
		return workOrderItems;
	}

	public void setWorkOrderItems(List<LeaderWorkOrderItemEntity> workOrderItems) {
		this.workOrderItems = workOrderItems;
	}

	public int getIsTransform() {
		return isTransform;
	}

	public void setIsTransform(int isTransform) {
		this.isTransform = isTransform;
	}
	

}

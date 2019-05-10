package com.easyhome.po.oms;

import java.util.Date;

import com.easyhome.po.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class WorkOrderBalance {
	
	@JsonProperty("ID")
	private String id;

	@JsonProperty("WORK_NO")
	private String workNo;

	@JsonProperty("SEND_DATE")
	private Date sendDate;

	@JsonProperty("AMOUNT")
	private String amount;

	@JsonProperty("ORDER_SN")
	private String orderSn;

	@JsonProperty("ITEM_COUNT")
	private String itemCount;

	@JsonProperty("CUS_NAME")
	private String cusName;

	@JsonProperty("CUS_PHONE")
	private String cusPhone;

	@JsonProperty("CUS_ADDRESS")
	private String cusAddress;

	@JsonProperty("COMPLETE_DATE")
	private Date completeDate;

	@JsonProperty("BOOKING_TIME")
	private Date bookingTime;

	@JsonProperty("STATUS_DISPLAY")
	private String statusDisplay;

	@JsonProperty("VIEW_TIME")
	private Date viewTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getStatusDisplay() {
		return statusDisplay;
	}

	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getViewTime() {
		return viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}

}

	


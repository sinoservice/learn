package com.easyhome.po.oms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkOrderBalanceInstall {
	@JsonProperty("ID")
	private String id;
	@JsonProperty("SCHEDULE_CODE")
	private String scheduleCode;
	@JsonProperty("SCHEDULE_DATE")
	private String scheduleDate;
	@JsonProperty("FEE")
	private String fee;
	@JsonProperty("ORDER_COUNT")
	private String orderCount;
	@JsonProperty("AMOUNT")
	private double amount;
	@JsonProperty("COUNT")
	private Integer count;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(String orderCount) {
		this.orderCount = orderCount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}

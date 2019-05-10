package com.easyhome.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p> Title: ReminderWorkOrder</p>
 * <p> Description: 催单展示类</p>
 * 
 * @date 2016年6月3日 下午3:43:55
 * @version 1.0
 *
 */
public class ReminderWorkOrder implements Serializable{
	
	private static final long serialVersionUID = -6866661993186577294L;
	
	private String fid;
	private String workNo;
	private Date sendDate;
	private String sender;
	private String platFormName;
	private String masterId;
	private String masterName;
	private String masterPhone;
	private String cusName;
	private String cusTel;
	private String cusAddress;
	private int booking;
	private int overtime;
	  
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getPlatFormName() {
		return platFormName;
	}
	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
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
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public Integer getBooking() {
		return booking;
	}
	public void setBooking(Integer booking) {
		this.booking = booking;
	}
	public int getOvertime() {
		return overtime;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
  
	  
}

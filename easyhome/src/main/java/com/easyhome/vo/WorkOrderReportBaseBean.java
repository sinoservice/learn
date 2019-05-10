package com.easyhome.vo;

/**
 * 
 * <p>title: WorkOrderReportBaseBean</p>
 * <p>description: 工单报表公共属性</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月25日 上午11:06:52
 */
public abstract class WorkOrderReportBaseBean {
	
	private String workNo; //工单号
	private String sendDate; //派单日期,
	private String sendTime; //派单时间,
	private String sender; //派单人,
	private String platFormName; //调度平台,
	private String cusName; //客户姓名,
	private String cusAddress; //地址,
	private String cusTel; //电话,
	private String masterName; //技师,
	private String masterPhone; //技师手机号,
	private String statusDisplay; //派单状态,
	private String billDate; //创建日期,
	private String billTime; //创建时间,
	private String outOrderSn; //外部订单号,
	private String memo2; //备注,
	private String masterFrom; //技师来源,
	private String bookingCreateDate; //预约提交日期,
	private String bookingCreateTime; //预约提交时间,
	private String bookingDate; //和客户预约日期,
	private String bookingTime; //和客户预约时间,
	
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
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
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
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
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	public String getOutOrderSn() {
		return outOrderSn;
	}
	public void setOutOrderSn(String outOrderSn) {
		this.outOrderSn = outOrderSn;
	}
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	public String getMasterFrom() {
		return masterFrom;
	}
	public void setMasterFrom(String masterFrom) {
		this.masterFrom = masterFrom;
	}
	public String getBookingCreateDate() {
		return bookingCreateDate;
	}
	public void setBookingCreateDate(String bookingCreateDate) {
		this.bookingCreateDate = bookingCreateDate;
	}
	public String getBookingCreateTime() {
		return bookingCreateTime;
	}
	public void setBookingCreateTime(String bookingCreateTime) {
		this.bookingCreateTime = bookingCreateTime;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	
}

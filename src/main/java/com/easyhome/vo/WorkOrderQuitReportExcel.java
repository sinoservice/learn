package com.easyhome.vo;

import com.easyhome.utils.ExcelResources;

/**
 * 
 * <p>title: WorkOrderReportBaseBean</p>
 * <p>description: 放弃工单报表模型</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月25日 上午11:06:52
 */
public class WorkOrderQuitReportExcel{
	
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
	private String isQuit; //是否放弃工单,
	private String quitDate; //放弃日期,
	private String quitTime; //放弃时间,
	private String reason; //放弃原因
	
	@ExcelResources(title="工单号",order=1)
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	
	@ExcelResources(title="派单日期",order=2)
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	@ExcelResources(title="派单时间",order=3)
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	@ExcelResources(title="派单人",order=4)
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	@ExcelResources(title="调度平台",order=5)
	public String getPlatFormName() {
		return platFormName;
	}
	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}
	
	@ExcelResources(title="客户姓名",order=6)
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	
	@ExcelResources(title="地址",order=7)
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	
	@ExcelResources(title="电话",order=8)
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	
	@ExcelResources(title="技师",order=9)
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	
	@ExcelResources(title="技师电话",order=10)
	public String getMasterPhone() {
		return masterPhone;
	}
	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}
	
	@ExcelResources(title="派单状态",order=11)
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	
	@ExcelResources(title="创建日期",order=12)
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	
	@ExcelResources(title="创建时间",order=13)
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	
	@ExcelResources(title="外部订单号",order=14)
	public String getOutOrderSn() {
		return outOrderSn;
	}
	public void setOutOrderSn(String outOrderSn) {
		this.outOrderSn = outOrderSn;
	}
	
	@ExcelResources(title="备注",order=15)
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
	@ExcelResources(title="技师来源",order=16)
	public String getMasterFrom() {
		return masterFrom;
	}
	public void setMasterFrom(String masterFrom) {
		this.masterFrom = masterFrom;
	}
	
	@ExcelResources(title="提交预约日期",order=17)
	public String getBookingCreateDate() {
		return bookingCreateDate;
	}
	public void setBookingCreateDate(String bookingCreateDate) {
		this.bookingCreateDate = bookingCreateDate;
	}
	
	@ExcelResources(title="提交预约时间",order=18)
	public String getBookingCreateTime() {
		return bookingCreateTime;
	}
	public void setBookingCreateTime(String bookingCreateTime) {
		this.bookingCreateTime = bookingCreateTime;
	}
	
	@ExcelResources(title="约定上门日期",order=19)
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	@ExcelResources(title="约定上门时间",order=20)
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	@ExcelResources(title="是否放弃工单",order=21)
	public String getIsQuit() {
		return isQuit;
	}
	public void setIsQuit(String isQuit) {
		this.isQuit = isQuit;
	}
	
	@ExcelResources(title="放弃工单日期",order=22)
	public String getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(String quitDate) {
		this.quitDate = quitDate;
	}
	
	@ExcelResources(title="放弃工单时间",order=23)
	public String getQuitTime() {
		return quitTime;
	}
	public void setQuitTime(String quitTime) {
		this.quitTime = quitTime;
	}
	
	@ExcelResources(title="放弃原因",order=24)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}

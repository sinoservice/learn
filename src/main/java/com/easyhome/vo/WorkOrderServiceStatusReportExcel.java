package com.easyhome.vo;

import com.easyhome.utils.ExcelResources;

/**
 * 
 * <p>title: WorkOrderServiceStatusReportModel</p>
 * <p>description: 工单服务状态查询实体</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午4:02:09
 */
public class WorkOrderServiceStatusReportExcel extends WorkOrderReportBaseBean {
	
	private String workNo;
	private String type;
	private String productQuantity;
	private String statusDisplay;
	private String dispatchMemo;
	private String dispatchSn;
	private String cusName;
	private String cusAddress;
	private String cusTel;
	private String sender;
	private String masterName;
	private String masterPhone;
	private String masterFrom;
	private String bookingStatus;
	private String remark;
	private String outOrderSn;
	private String billDate;
	private String billTime;
	private String sendDate;
	private String sendTime;
	private String platFormName;
	private String bookingCreateDate;
	private String bookingCreateTime;
	private String bookingDate;
	private String bookingTime;
	private String singDate;
	private String singTime;
	private String completeDate;
	private String completeTime;
	private String customerEval;
	private String viewDate;
	private String viewTime;
	private String serviceFeedback;
	private String memo2;
	
	@ExcelResources(title="工单号",order=1)
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	
	@ExcelResources(title="安装类型",order=2)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@ExcelResources(title="商品数量",order=3)
	public String getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}
	@ExcelResources(title="工单状态",order=4)
	public String getStatusDisplay() {
		return statusDisplay;
	}
	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}
	@ExcelResources(title="物流公司",order=5)
	public String getDispatchMemo() {
		return dispatchMemo;
	}
	public void setDispatchMemo(String dispatchMemo) {
		this.dispatchMemo = dispatchMemo;
	}
	@ExcelResources(title="物流单号",order=6)
	public String getDispatchSn() {
		return dispatchSn;
	}
	public void setDispatchSn(String dispatchSn) {
		this.dispatchSn = dispatchSn;
	}
	@ExcelResources(title="客户姓名",order=7)
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	@ExcelResources(title="地址",order=8)
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	@ExcelResources(title="电话",order=9)
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	@ExcelResources(title="派单人",order=10)
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	@ExcelResources(title="技师",order=11)
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	@ExcelResources(title="技师手机号",order=12)
	public String getMasterPhone() {
		return masterPhone;
	}
	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}
	@ExcelResources(title="技师来源",order=13)
	public String getMasterFrom() {
		return masterFrom;
	}
	public void setMasterFrom(String masterFrom) {
		this.masterFrom = masterFrom;
	}
	@ExcelResources(title="预约状态",order=14)
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@ExcelResources(title="失败原因",order=15)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@ExcelResources(title="外部订单号",order=16)
	public String getOutOrderSn() {
		return outOrderSn;
	}
	public void setOutOrderSn(String outOrderSn) {
		this.outOrderSn = outOrderSn;
	}
	@ExcelResources(title="工单创建日期",order=17)
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	@ExcelResources(title="工单创建时间",order=18)
	public String getBillTime() {
		return billTime;
	}
	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}
	@ExcelResources(title="派单日期",order=19)
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	@ExcelResources(title="派单时间",order=20)
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	@ExcelResources(title="调度平台",order=21)
	public String getPlatFormName() {
		return platFormName;
	}
	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}
	@ExcelResources(title="主动预约日期",order=22)
	public String getBookingCreateDate() {
		return bookingCreateDate;
	}
	public void setBookingCreateDate(String bookingCreateDate) {
		this.bookingCreateDate = bookingCreateDate;
	}
	@ExcelResources(title="主动预约时间",order=23)
	public String getBookingCreateTime() {
		return bookingCreateTime;
	}
	public void setBookingCreateTime(String bookingCreateTime) {
		this.bookingCreateTime = bookingCreateTime;
	}
	@ExcelResources(title="约定上门日期",order=24)
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	@ExcelResources(title="约定上门时间",order=25)
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	@ExcelResources(title="签到日期",order=26)
	public String getSingDate() {
		return singDate;
	}
	public void setSingDate(String singDate) {
		this.singDate = singDate;
	}
	@ExcelResources(title="签到时间",order=27)
	public String getSingTime() {
		return singTime;
	}
	public void setSingTime(String singTime) {
		this.singTime = singTime;
	}
	@ExcelResources(title="完工日期",order=28)
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	@ExcelResources(title="完工时间",order=29)
	public String getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(String completeTime) {
		this.completeTime = completeTime;
	}
	@ExcelResources(title="评价结果",order=30)
	public String getCustomerEval() {
		return customerEval;
	}
	public void setCustomerEval(String customerEval) {
		this.customerEval = customerEval;
	}
	@ExcelResources(title="回访日期",order=31)
	public String getViewDate() {
		return viewDate;
	}
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}
	@ExcelResources(title="回访时间",order=32)
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	@ExcelResources(title="回访情况",order=33)
	public String getServiceFeedback() {
		return serviceFeedback;
	}
	public void setServiceFeedback(String serviceFeedback) {
		this.serviceFeedback = serviceFeedback;
	}
	@ExcelResources(title="备注",order=34)
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
}

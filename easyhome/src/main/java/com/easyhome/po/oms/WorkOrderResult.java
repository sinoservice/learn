package com.easyhome.po.oms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkOrderResult {
	@JsonProperty("AMOUNT")
	private double amount;
	@JsonProperty("AUDIT_STATUS")
    private int auditStatus;
	@JsonProperty("BOOKING_TIME")
    private String bookingTime;
	@JsonProperty("CHECK_CODE")
    private int checkCode;
	@JsonProperty("COMPLETE_DATE")
    private String completeDate;
	@JsonProperty("CUS_ADDRESS")
    private String cusAddress;
	@JsonProperty("CUS_NAME")
    private String cusName;
	@JsonProperty("CUS_TEL")
    private String cusTel;
	@JsonProperty("CUS_TOMER_EVAL")
    private String cusTomerEval;
	@JsonProperty("DELIVERY_TIME")
    private String deliveryTime;
	@JsonProperty("DISPATCH_MEMO")
    private String dispatchMemo;
	@JsonProperty("DISPATCH_SN")
    private String dispatchSn;
	@JsonProperty("EVAL_DELIVERY")
    private int evalDelivery;
	@JsonProperty("eval_Install")
    private int evalInstall;
	@JsonProperty("EVAL_PHONE_BACK")
    private int evalPhoneBack;
	@JsonProperty("EVAL_SCORE")
    private int evalScore;
	@JsonProperty("EVAL_SERVICE_COMPLETE")
    private int evalServiceComplete;
	@JsonProperty("FEEDBACK_CONTENT")
    private String feedbackContent;
	@JsonProperty("FEEDBACK_MAN")
    private String feedbackMan;
	@JsonProperty("FEEDBACK_REMARK")
    private String feedbackRemark;
	@JsonProperty("FEEDBACK_STATUS")
    private String feedbackStatus;
	@JsonProperty("FEEDBACK_TIME")
    private String feedbackTime;
	@JsonProperty("FEEDBACK_VALIDITY")
    private String feedbackValidity;
	@JsonProperty("FID")
    private String fid;
	@JsonProperty("FRANCHISEE_ID")
    private String franchiseeId;
	@JsonProperty("GIVE_REASONS")
    private String giveReasons;
	@JsonProperty("INSTALL_LINK_ADDRESS")
    private String installLinkAddress;
	@JsonProperty("INSTALL_LINK_MAN")
    private String installLinkMan;
	@JsonProperty("INSTALL_LINK_PHONE")
    private String installLinkPhone;
	@JsonProperty("IS_CUS_CON_FIRM")
    private int isCusConfirm;
	@JsonProperty("IS_FEE")
    private String isFee;
	@JsonProperty("IS_TMALL_ORDER")
    private int isTmallOrder;
	@JsonProperty("MASTER_ID")
    private String masterId;
	@JsonProperty("MASTER_FROM")
    private String masterFrom;
	@JsonProperty("MASTER_NAME")
    private String masterName;
	@JsonProperty("MASTER_PHONE")
    private String masterPhone;
	@JsonProperty("MEMO2")
    private String memo2;
	@JsonProperty("OMS_DISPATCH_NO")
    private String omsDispatchNo;
	@JsonProperty("ORDER_ID")
    private String orderId;
	@JsonProperty("ORDER_SN")
    private String orderSn;
	@JsonProperty("OUT_ORDER_SN")
    private String outOrderSn;
	@JsonProperty("PLAT_FROM_ID")
    private int platFromId;
	@JsonProperty("PLAT_FROM_NAME")
    private String platFromName;
	@JsonProperty("REMARK")
    private String remark;
	@JsonProperty("REPORT_MAN")
    private String reportMan;
	@JsonProperty("SATISFACTION1")
    private int satisfaction1;
	@JsonProperty("SATISFACTION2")
    private int satisfaction2;
	@JsonProperty("SATISFACTION3")
    private int satisfaction3;
	@JsonProperty("SEND_DATE")
    private String sendDate;
	@JsonProperty("SENDER")
    private String sender;
	@JsonProperty("SEND_ID")
    private String senderId;
	@JsonProperty("SERVICEFEEDBACK")
    private String serviceFeedback;
	@JsonProperty("SERVICE_FEED_MAN")
    private String serviceFeedMan;
	@JsonProperty("SERVICE_FEED_MAN_ID")
    private String serviceFeedManId;
	@JsonProperty("SING_TIME")
	private String singTime;
	@JsonProperty("SINGER")
	private String singer;
	@JsonProperty("STATUS")
	private int status;
	@JsonProperty("STATUS_DISPALY")
	private String statusDispaly;
	@JsonProperty("STORE_NAME")
	private String storeName;
	@JsonProperty("TYPE")
	private String type;
	@JsonProperty("VIEW_TIME")
	private String viewTime;
	@JsonProperty("WARE_HOUSE_NAME")
	private String warehouseName;
	@JsonProperty("WORK_NO")
	private String workNo;
	@JsonProperty("WORK_ORDER_MASTER_ID")
	private String workOrderMasterId;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public int getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(int checkCode) {
		this.checkCode = checkCode;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
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
	public String getCusTomerEval() {
		return cusTomerEval;
	}
	public void setCusTomerEval(String cusTomerEval) {
		this.cusTomerEval = cusTomerEval;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
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
	public int getEvalDelivery() {
		return evalDelivery;
	}
	public void setEvalDelivery(int evalDelivery) {
		this.evalDelivery = evalDelivery;
	}
	public int getEvalInstall() {
		return evalInstall;
	}
	public void setEvalInstall(int evalInstall) {
		this.evalInstall = evalInstall;
	}
	public int getEvalPhoneBack() {
		return evalPhoneBack;
	}
	public void setEvalPhoneBack(int evalPhoneBack) {
		this.evalPhoneBack = evalPhoneBack;
	}
	public int getEvalScore() {
		return evalScore;
	}
	public void setEvalScore(int evalScore) {
		this.evalScore = evalScore;
	}
	public int getEvalServiceComplete() {
		return evalServiceComplete;
	}
	public void setEvalServiceComplete(int evalServiceComplete) {
		this.evalServiceComplete = evalServiceComplete;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public String getFeedbackMan() {
		return feedbackMan;
	}
	public void setFeedbackMan(String feedbackMan) {
		this.feedbackMan = feedbackMan;
	}
	public String getFeedbackRemark() {
		return feedbackRemark;
	}
	public void setFeedbackRemark(String feedbackRemark) {
		this.feedbackRemark = feedbackRemark;
	}
	public String getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public String getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public String getFeedbackValidity() {
		return feedbackValidity;
	}
	public void setFeedbackValidity(String feedbackValidity) {
		this.feedbackValidity = feedbackValidity;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFranchiseeId() {
		return franchiseeId;
	}
	public void setFranchiseeId(String franchiseeId) {
		this.franchiseeId = franchiseeId;
	}
	public String getGiveReasons() {
		return giveReasons;
	}
	public void setGiveReasons(String giveReasons) {
		this.giveReasons = giveReasons;
	}
	public String getInstallLinkAddress() {
		return installLinkAddress;
	}
	public void setInstallLinkAddress(String installLinkAddress) {
		this.installLinkAddress = installLinkAddress;
	}
	public String getInstallLinkMan() {
		return installLinkMan;
	}
	public void setInstallLinkMan(String installLinkMan) {
		this.installLinkMan = installLinkMan;
	}
	
	public String getInstallLinkPhone() {
		return installLinkPhone;
	}
	public void setInstallLinkPhone(String installLinkPhone) {
		this.installLinkPhone = installLinkPhone;
	}
	public int getIsCusConfirm() {
		return isCusConfirm;
	}
	public void setIsCusConfirm(int isCusConfirm) {
		this.isCusConfirm = isCusConfirm;
	}
	public String getIsFee() {
		return isFee;
	}
	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}
	public int getIsTmallOrder() {
		return isTmallOrder;
	}
	public void setIsTmallOrder(int isTmallOrder) {
		this.isTmallOrder = isTmallOrder;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getMasterFrom() {
		return masterFrom;
	}
	public void setMasterFrom(String masterFrom) {
		this.masterFrom = masterFrom;
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
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	public String getOmsDispatchNo() {
		return omsDispatchNo;
	}
	public void setOmsDispatchNo(String omsDispatchNo) {
		this.omsDispatchNo = omsDispatchNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getOutOrderSn() {
		return outOrderSn;
	}
	public void setOutOrderSn(String outOrderSn) {
		this.outOrderSn = outOrderSn;
	}
	
	public int getPlatFromId() {
		return platFromId;
	}
	public void setPlatFromId(int platFromId) {
		this.platFromId = platFromId;
	}
	public String getPlatFromName() {
		return platFromName;
	}
	public void setPlatFromName(String platFromName) {
		this.platFromName = platFromName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReportMan() {
		return reportMan;
	}
	public void setReportMan(String reportMan) {
		this.reportMan = reportMan;
	}
	
	public int getSatisfaction1() {
		return satisfaction1;
	}
	public void setSatisfaction1(int satisfaction1) {
		this.satisfaction1 = satisfaction1;
	}
	public int getSatisfaction2() {
		return satisfaction2;
	}
	public void setSatisfaction2(int satisfaction2) {
		this.satisfaction2 = satisfaction2;
	}
	public int getSatisfaction3() {
		return satisfaction3;
	}
	public void setSatisfaction3(int satisfaction3) {
		this.satisfaction3 = satisfaction3;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getServiceFeedback() {
		return serviceFeedback;
	}
	public void setServiceFeedback(String serviceFeedback) {
		this.serviceFeedback = serviceFeedback;
	}
	public String getServiceFeedMan() {
		return serviceFeedMan;
	}
	public void setServiceFeedMan(String serviceFeedMan) {
		this.serviceFeedMan = serviceFeedMan;
	}
	public String getServiceFeedManId() {
		return serviceFeedManId;
	}
	public void setServiceFeedManId(String serviceFeedManId) {
		this.serviceFeedManId = serviceFeedManId;
	}
	public String getSingTime() {
		return singTime;
	}
	public void setSingTime(String singTime) {
		this.singTime = singTime;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusDispaly() {
		return statusDispaly;
	}
	public void setStatusDispaly(String statusDispaly) {
		this.statusDispaly = statusDispaly;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getWorkOrderMasterId() {
		return workOrderMasterId;
	}
	public void setWorkOrderMasterId(String workOrderMasterId) {
		this.workOrderMasterId = workOrderMasterId;
	}
}

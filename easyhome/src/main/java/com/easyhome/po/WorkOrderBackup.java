package com.easyhome.po;

import java.util.Date;

public class WorkOrderBackup {
    private String fid;//主键

    private String orderId;//订单id

    private String workNo;//工单号

    private Date sendDate;//派单日期

    private String sender;//派单人姓名

    private String platFormId;//调度平台id

    private String platFormName;//调度平台id

    private String franchiseeId;//供应商id

    private String masterId;//技师id

    private Integer status;//工单状态

    private String giveReasons;//

    private Double amount;//派工总金额

    private String singer;//完工人

    private Date singTime;//完工时间

    private String serviceMan;//

    private String serviceFeedback;//

    private String cusName;//客户姓名

    private String cusAddress;//客户地址

    private String cusTel;//客户电话

    private String senderId;//派单人id

    private String serviceManId;//

    private Integer orderSn;//订单号（来源订单）

    private String masterName;//技师姓名

    private String statusDisplay;//工单状态文本

    private String feedbackContent;//意见反馈

    private String installLinkPhone;//安装人联系电话

    private String installLinkMan;//安装联系人
    
    private Date feedbackTime;//回访时间

    private String feedbackMan;//回访人

    private String installLinkAddress;//安装联系人地址

    private double evalScore;//客户评分

    private String customerEval;//客户评价

    private Integer isCusConfirm;//是否客户确认

    private String reportMan;//汇报人

    private Date completeDate;//完工时间

    private String type;//安装类型

    private Date billDate;//工单创建日期

    private String masterPhone;//技师电话

    private String workOrderMasterId;//派单记录id

    private Date bookingTime;//预约时间

    private String dispatchSn;//物流单号

    private String dispatchMemo;//物流公司

    private String memo2;//备注2（）

    private String storeName;//经营单位

    private String warehouseName;//发货仓库

    private String feedbackValidity;//回访有效性

    private String isFee;//是否收费

    private Integer customerEvalScore;//客户评价

    private String feedbackRemark;//回访备注

    private int satisfaction1;//及时性满意度

    private int satisfaction2;//态度满意度

    private int satisfaction3;//技能满意度

    private String checkCode;//签到验证码

    private String outOrderSn;//外部订单号

    private String feedbackStatus;//回访状态

    private Integer auditStatus;//审核状态

    private String remark;//工单备注

    private Integer isTmallOrder;//

    private String omsDispatchNo;//

    private Integer evalServiceComplete;//服务是否完成

    private Integer evalDelivery;//送货时效

    private Integer evalInstall;//安装质量

    private Integer evalPhoneBack;//是否接受电话回访

    private Date viewTime;//
    
    private String revokeCause;//撤单原因
    
    private String revokeName;//撤单人姓名
    
    private Date revokeTime;//撤单时间

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

	public String getPlatFormId() {
		return platFormId;
	}

	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}

	public String getPlatFormName() {
		return platFormName;
	}

	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}

	public String getFranchiseeId() {
		return franchiseeId;
	}

	public void setFranchiseeId(String franchiseeId) {
		this.franchiseeId = franchiseeId;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getGiveReasons() {
		return giveReasons;
	}

	public void setGiveReasons(String giveReasons) {
		this.giveReasons = giveReasons;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Date getSingTime() {
		return singTime;
	}

	public void setSingTime(Date singTime) {
		this.singTime = singTime;
	}

	public String getServiceMan() {
		return serviceMan;
	}

	public void setServiceMan(String serviceMan) {
		this.serviceMan = serviceMan;
	}

	public String getServiceFeedback() {
		return serviceFeedback;
	}

	public void setServiceFeedback(String serviceFeedback) {
		this.serviceFeedback = serviceFeedback;
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

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getServiceManId() {
		return serviceManId;
	}

	public void setServiceManId(String serviceManId) {
		this.serviceManId = serviceManId;
	}

	public Integer getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(Integer orderSn) {
		this.orderSn = orderSn;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getStatusDisplay() {
		return statusDisplay;
	}

	public void setStatusDisplay(String statusDisplay) {
		this.statusDisplay = statusDisplay;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public String getInstallLinkPhone() {
		return installLinkPhone;
	}

	public void setInstallLinkPhone(String installLinkPhone) {
		this.installLinkPhone = installLinkPhone;
	}

	public String getInstallLinkMan() {
		return installLinkMan;
	}

	public void setInstallLinkMan(String installLinkMan) {
		this.installLinkMan = installLinkMan;
	}

	public Date getFeedbackTime() {
		return feedbackTime;
	}

	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

	public String getFeedbackMan() {
		return feedbackMan;
	}

	public void setFeedbackMan(String feedbackMan) {
		this.feedbackMan = feedbackMan;
	}

	public String getInstallLinkAddress() {
		return installLinkAddress;
	}

	public void setInstallLinkAddress(String installLinkAddress) {
		this.installLinkAddress = installLinkAddress;
	}

	public double getEvalScore() {
		return evalScore;
	}

	public void setEvalScore(double evalScore) {
		this.evalScore = evalScore;
	}

	public String getCustomerEval() {
		return customerEval;
	}

	public void setCustomerEval(String customerEval) {
		this.customerEval = customerEval;
	}

	public Integer getIsCusConfirm() {
		return isCusConfirm;
	}

	public void setIsCusConfirm(Integer isCusConfirm) {
		this.isCusConfirm = isCusConfirm;
	}

	public String getReportMan() {
		return reportMan;
	}

	public void setReportMan(String reportMan) {
		this.reportMan = reportMan;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getMasterPhone() {
		return masterPhone;
	}

	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}

	public String getWorkOrderMasterId() {
		return workOrderMasterId;
	}

	public void setWorkOrderMasterId(String workOrderMasterId) {
		this.workOrderMasterId = workOrderMasterId;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getDispatchSn() {
		return dispatchSn;
	}

	public void setDispatchSn(String dispatchSn) {
		this.dispatchSn = dispatchSn;
	}

	public String getDispatchMemo() {
		return dispatchMemo;
	}

	public void setDispatchMemo(String dispatchMemo) {
		this.dispatchMemo = dispatchMemo;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getFeedbackValidity() {
		return feedbackValidity;
	}

	public void setFeedbackValidity(String feedbackValidity) {
		this.feedbackValidity = feedbackValidity;
	}

	public String getIsFee() {
		return isFee;
	}

	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}

	public Integer getCustomerEvalScore() {
		return customerEvalScore;
	}

	public void setCustomerEvalScore(Integer customerEvalScore) {
		this.customerEvalScore = customerEvalScore;
	}

	public String getFeedbackRemark() {
		return feedbackRemark;
	}

	public void setFeedbackRemark(String feedbackRemark) {
		this.feedbackRemark = feedbackRemark;
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

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getOutOrderSn() {
		return outOrderSn;
	}

	public void setOutOrderSn(String outOrderSn) {
		this.outOrderSn = outOrderSn;
	}

	public String getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsTmallOrder() {
		return isTmallOrder;
	}

	public void setIsTmallOrder(Integer isTmallOrder) {
		this.isTmallOrder = isTmallOrder;
	}

	public String getOmsDispatchNo() {
		return omsDispatchNo;
	}

	public void setOmsDispatchNo(String omsDispatchNo) {
		this.omsDispatchNo = omsDispatchNo;
	}

	public Integer getEvalServiceComplete() {
		return evalServiceComplete;
	}

	public void setEvalServiceComplete(Integer evalServiceComplete) {
		this.evalServiceComplete = evalServiceComplete;
	}

	public Integer getEvalDelivery() {
		return evalDelivery;
	}

	public void setEvalDelivery(Integer evalDelivery) {
		this.evalDelivery = evalDelivery;
	}

	public Integer getEvalInstall() {
		return evalInstall;
	}

	public void setEvalInstall(Integer evalInstall) {
		this.evalInstall = evalInstall;
	}

	public Integer getEvalPhoneBack() {
		return evalPhoneBack;
	}

	public void setEvalPhoneBack(Integer evalPhoneBack) {
		this.evalPhoneBack = evalPhoneBack;
	}

	public Date getViewTime() {
		return viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}

	public String getRevokeCause() {
		return revokeCause;
	}

	public void setRevokeCause(String revokeCause) {
		this.revokeCause = revokeCause;
	}

	public String getRevokeName() {
		return revokeName;
	}

	public void setRevokeName(String revokeName) {
		this.revokeName = revokeName;
	}

	public Date getRevokeTime() {
		return revokeTime;
	}

	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}

   }
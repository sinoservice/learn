package com.easyhome.vo.dms;

import java.util.Date;

/**
 * 
 * <p>标题: VisitRequestData</p>
 * <p>描述: 回访结果查询请求数据包装</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年10月20日 上午9:49:03</p>
 * <p>版本: 1.0</p>
 */
public class VisitResponseData {

	/**
     * 主键
     */
    private Long jobId;
    /**
     * 派工单编号
     */
    private String etdlNo;
    /**
     * 派工单类型
     */
    private String etdlType;
    /**
     * 派工单状态
     */
    private String etdlStatus;
    /**
     * 技师名称
     */
    private String etdlTeachnologistName;
    /**
     * 网点名称
     */
    private String etdlDotName;
    /**
     * 完工日期
     */
    private Date etdlEndTime;
    /**
     * 汇报人
     */
    private String etdlOperate;
    /**
     * 是否客户确认
     */
    private String isCusConfirm;
    /**
     * 客户平分
     */
    private Double evalScore;
    /**
     * 客户评价
     */
    private String customerEval;
    /**
     * 回访人
     */
    private String feedbackMan;
    /**
     * 回访时间
     */
    private Date feedbackTime;
    /**
     * 回访情况（状态）
     */
    private String feedbackStatus;
    /**
     * 回访有效性
     */
    private String feedbackValidity;
    /**
     * 是否收费
     */
    private String isFee;
    /**
     * 及时性满意度
     */
    private String satisfaction1;
    /**
     * 态度满意度
     */
    private String satisfaction2;
    /**
     * 技能满意度
     */
    private String satisfaction3;
    /**
     * 意见建议
     */
    private String feedbackContent;
    /**
     * 备注
     */
    private String feedbackRemark;
    
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getEtdlNo() {
		return etdlNo;
	}
	public void setEtdlNo(String etdlNo) {
		this.etdlNo = etdlNo;
	}
	public String getEtdlType() {
		return etdlType;
	}
	public void setEtdlType(String etdlType) {
		this.etdlType = etdlType;
	}
	public String getEtdlStatus() {
		return etdlStatus;
	}
	public void setEtdlStatus(String etdlStatus) {
		this.etdlStatus = etdlStatus;
	}
	public String getEtdlTeachnologistName() {
		return etdlTeachnologistName;
	}
	public void setEtdlTeachnologistName(String etdlTeachnologistName) {
		this.etdlTeachnologistName = etdlTeachnologistName;
	}
	public String getEtdlDotName() {
		return etdlDotName;
	}
	public void setEtdlDotName(String etdlDotName) {
		this.etdlDotName = etdlDotName;
	}
	public Date getEtdlEndTime() {
		return etdlEndTime;
	}
	public void setEtdlEndTime(Date etdlEndTime) {
		this.etdlEndTime = etdlEndTime;
	}
	public String getEtdlOperate() {
		return etdlOperate;
	}
	public void setEtdlOperate(String etdlOperate) {
		this.etdlOperate = etdlOperate;
	}
	public String getIsCusConfirm() {
		return isCusConfirm;
	}
	public void setIsCusConfirm(String isCusConfirm) {
		this.isCusConfirm = isCusConfirm;
	}
	public Double getEvalScore() {
		return evalScore;
	}
	public void setEvalScore(Double evalScore) {
		this.evalScore = evalScore;
	}
	public String getCustomerEval() {
		return customerEval;
	}
	public void setCustomerEval(String customerEval) {
		this.customerEval = customerEval;
	}
	public String getFeedbackMan() {
		return feedbackMan;
	}
	public void setFeedbackMan(String feedbackMan) {
		this.feedbackMan = feedbackMan;
	}
	public Date getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public String getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
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
	public String getSatisfaction1() {
		return satisfaction1;
	}
	public void setSatisfaction1(String satisfaction1) {
		this.satisfaction1 = satisfaction1;
	}
	public String getSatisfaction2() {
		return satisfaction2;
	}
	public void setSatisfaction2(String satisfaction2) {
		this.satisfaction2 = satisfaction2;
	}
	public String getSatisfaction3() {
		return satisfaction3;
	}
	public void setSatisfaction3(String satisfaction3) {
		this.satisfaction3 = satisfaction3;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public String getFeedbackRemark() {
		return feedbackRemark;
	}
	public void setFeedbackRemark(String feedbackRemark) {
		this.feedbackRemark = feedbackRemark;
	}
    
}

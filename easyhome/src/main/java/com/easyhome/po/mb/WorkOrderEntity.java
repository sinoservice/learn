package com.easyhome.po.mb;

import java.util.Date;

public class WorkOrderEntity {
	/**
	 * 客单号
	 */
	private String ethtSoNo;
	/**
	 * 客户代码
	 */
	private String ethdCustomEbcuCode;
	/**
	 * 客户名称
	 */
	private String ethdCustomEbcuNameCn;
	/**
	 * 派工单主键
	 */
	private Long etdlId;
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
	 * 技师电话
	 */
	private String etdlTeachnologistTel;
	/**
	 * 预约上门时间从
	 */
	private Date etdlOrderArrivalTime;
	/**
	 * 完成时间
	 */
	private Date etdlEndTime;
	/**
	 * 逻辑删除
	 */
	private Long recStatus;
	/**
	 * 签到时间
	 */
	private Date etdlSignTime;
	/**
	 * 完成备注
	 */
	private String etdlEndRemark;
	/**
	 * 商品代码
	 */
	private String eooiCode;

	public String getEthtSoNo() {
		return ethtSoNo;
	}

	public void setEthtSoNo(String ethtSoNo) {
		this.ethtSoNo = ethtSoNo;
	}

	public String getEthdCustomEbcuCode() {
		return ethdCustomEbcuCode;
	}

	public void setEthdCustomEbcuCode(String ethdCustomEbcuCode) {
		this.ethdCustomEbcuCode = ethdCustomEbcuCode;
	}

	public String getEthdCustomEbcuNameCn() {
		return ethdCustomEbcuNameCn;
	}

	public void setEthdCustomEbcuNameCn(String ethdCustomEbcuNameCn) {
		this.ethdCustomEbcuNameCn = ethdCustomEbcuNameCn;
	}

	public Long getEtdlId() {
		return etdlId;
	}

	public void setEtdlId(Long etdlId) {
		this.etdlId = etdlId;
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

	public String getEtdlTeachnologistTel() {
		return etdlTeachnologistTel;
	}

	public void setEtdlTeachnologistTel(String etdlTeachnologistTel) {
		this.etdlTeachnologistTel = etdlTeachnologistTel;
	}

	public Date getEtdlOrderArrivalTime() {
		return etdlOrderArrivalTime;
	}

	public void setEtdlOrderArrivalTime(Date etdlOrderArrivalTime) {
		this.etdlOrderArrivalTime = etdlOrderArrivalTime;
	}

	public Date getEtdlEndTime() {
		return etdlEndTime;
	}

	public void setEtdlEndTime(Date etdlEndTime) {
		this.etdlEndTime = etdlEndTime;
	}

	public Long getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(Long recStatus) {
		this.recStatus = recStatus;
	}

	public Date getEtdlSignTime() {
		return etdlSignTime;
	}

	public void setEtdlSignTime(Date etdlSignTime) {
		this.etdlSignTime = etdlSignTime;
	}

	public String getEtdlEndRemark() {
		return etdlEndRemark;
	}

	public void setEtdlEndRemark(String etdlEndRemark) {
		this.etdlEndRemark = etdlEndRemark;
	}

	public String getEooiCode() {
		return eooiCode;
	}

	public void setEooiCode(String eooiCode) {
		this.eooiCode = eooiCode;
	}

}

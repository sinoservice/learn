package com.easyhome.po.mb;

public class WorkDataEntity {

	private String Token;// 身份令牌

	private String issueId;// 服务单号

	private String item_No;// 服务单下子类别的序号

	private String serviceEndDate;// 工程师上门服务结束时间(有值，工作单关闭，空，工作单继续)

	private String defect;// 上门服务缺陷描述

	private String scheme;// 上门服务处理方案

	private String is_quality;// 是否质量问题(Y；N)

	private String is_warranty;// 是否保修期内(Y；N)

	private String is_charge;// 是否收费(1-Paid; 0-Free;)

	private String is_confirm_sku;// 二次确认型号是否正确(18位 SKU)

	private String Spare;// 配件成本

	private String transportation;// 运输成本

	private String Artificial;// 人工成本

	private String engineer;// 工程师

	private String remark;// 备注

	private String visite_time;// 上门时间(2017-02-15)

	private String defect_type;// 缺陷部位(数字，安装为99)

	private String defect_msg;// 缺陷描述(6位数字)

	private String picture;// 图片名称(最多4张)

	private String FAILURE_REASON;// 二次上门原因

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getItem_No() {
		return item_No;
	}

	public void setItem_No(String item_No) {
		this.item_No = item_No;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getDefect() {
		return defect;
	}

	public void setDefect(String defect) {
		this.defect = defect;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getIs_quality() {
		return is_quality;
	}

	public void setIs_quality(String is_quality) {
		this.is_quality = is_quality;
	}

	public String getIs_warranty() {
		return is_warranty;
	}

	public void setIs_warranty(String is_warranty) {
		this.is_warranty = is_warranty;
	}

	public String getIs_charge() {
		return is_charge;
	}

	public void setIs_charge(String is_charge) {
		this.is_charge = is_charge;
	}

	public String getIs_confirm_sku() {
		return is_confirm_sku;
	}

	public void setIs_confirm_sku(String is_confirm_sku) {
		this.is_confirm_sku = is_confirm_sku;
	}

	public String getSpare() {
		return Spare;
	}

	public void setSpare(String spare) {
		Spare = spare;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getArtificial() {
		return Artificial;
	}

	public void setArtificial(String artificial) {
		Artificial = artificial;
	}

	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVisite_time() {
		return visite_time;
	}

	public void setVisite_time(String visite_time) {
		this.visite_time = visite_time;
	}

	public String getDefect_type() {
		return defect_type;
	}

	public void setDefect_type(String defect_type) {
		this.defect_type = defect_type;
	}

	public String getDefect_msg() {
		return defect_msg;
	}

	public void setDefect_msg(String defect_msg) {
		this.defect_msg = defect_msg;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getFAILURE_REASON() {
		return FAILURE_REASON;
	}

	public void setFAILURE_REASON(String fAILURE_REASON) {
		FAILURE_REASON = fAILURE_REASON;
	}
}

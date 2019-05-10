package com.easyhome.vo.dms;

import java.util.Date;

public class EbTechnicianModel {

	/**
	 * 技师表主键
	 */
	private Long ebteId;
	/**
	 * 技师工号
	 */
	private String ebteWorkNo;
	/**
	 * 手机号码
	 */
	private Long ebtePhoneNo;
	/**
	 * 姓名
	 */
	private String ebteName;
	/**
	 * 性别
	 */
	private String ebteSex;
	/**
	 * 工种
	 */
	private String ebteWorkType;
	/**
	 * 身份证
	 */
	private String ebteCard;
	/**
	 * 常驻地
	 */
	private String ebteLocation;
	/**
	 * 逻辑删除:0-正常,1-删除
	 */
	private Long recStatus = 0L;
	/**
	 * 技师代码
	 */
	private String ebteCode;
	/**
	 * 服务区域
	 */
	private String ebteServiceArea;
	/**
	 * 年龄
	 */
	private Long ebteAge;
	/**
	 * QQ或微信
	 */
	private String ebteQq;
	/**
	 * 是否带车
	 */
	private Long ebteIsHasCar;
	/**
	 * 团队人数
	 */
	private String ebteTeamCount;
	/**
	 * 开户人
	 */
	private String ebteAccountHolder;
	/**
	 * 开户行
	 */
	private String ebteOpenBank;
	/**
	 * 银行账号
	 */
	private String ebteBankAccount;
	/**
	 * 紧急联系人
	 */
	private String ebteEmergencyLinkman;
	/**
	 * 关系
	 */
	private String ebteRelation;
	/**
	 * 联系电话
	 */
	private Long ebteContactNumber;
	/**
	 * 审核状态
	 */
	private Long ebteReviewState;
	/**
	 * 网点编码
	 */
	private String ebteEsstStationCode;
	/**
	 * 网点名称
	 */
	private String ebteEsstStationName;
	/**
	 * 服务平台代码
	 */
	private String siteCode;
	/**
	 * 服务平台名称
	 */
	private String siteName;
	/**
	 * 备注
	 */
	private String ebteRemark;
	/**
	 * 服务等级
	 */
	private String ebteServiceGrade;
	/**
	 * 技师类型
	 */
	private Long ebteType;
	/**
	 * 技师分数
	 */
	private Double ebteScores;
	/**
	 * 技师登录密码
	 */
	private String ebtePassword;
	/**
	 * 技师属性(1 普通技师，2 工长，3 加盟商)
	 */
	private String ebteProperties;
	/**
	 * 验证码
	 */
	private String ebteVerificateCode;
	/**
	 * 验证码生成时间
	 */
	private Date ebteVerificateCreateTime;
	/**
	 * 验证码失效时间
	 */
	private Date ebteVerificateInvalidTime;
	/**
	 * 支行
	 */
	private String ebteBranchBank;
	/**
	 * 图片1
	 */
	private String ebtePhotoUrl1;
	/**
	 * 图片2
	 */
	private String ebtePhotoUrl2;
	/**
	 * 图片3
	 */
	private String ebtePhotoUrl3;
	/**
	 * 所属工长工号
	 */
	private String ebteParentWorkNo;
	/**
	 * 所属工长姓名
	 */
	private String ebteParentName;
	/**
	 * 是否修改过密码
	 */
	private String ebteIsModifyPwd;
	/**
	 * 薪资
	 */
	private Double ebteSalary;
	/**
	 * 品牌认证代码
	 */
	private String ebteBrandAttestationCode;
	/**
	 * 品牌认证名称
	 */
	private String ebteBrandAttestationName;
	/**
	 * 车辆代码
	 */
	private String ebteCarCode;
	/**
	 * 车辆名称
	 */
	private String ebteCarName;
	/**
	 * 供应商编码
	 */
	private String ebteSupplierCode;
	/**
	 * 供应商名称
	 */
	private String ebteSupplierName;
	/**
	 * 启用状态
	 */
	private Long ebteEnableState;
	/**
	 * 技师认证状态
	 */
	private Long ebteCertifiedState;
	
	
	public String getEbteWorkNo() {
		return ebteWorkNo;
	}
	public void setEbteWorkNo(String ebteWorkNo) {
		this.ebteWorkNo = ebteWorkNo;
	}
	public Long getEbtePhoneNo() {
		return ebtePhoneNo;
	}
	public void setEbtePhoneNo(Long ebtePhoneNo) {
		this.ebtePhoneNo = ebtePhoneNo;
	}
	public String getEbteName() {
		return ebteName;
	}
	public void setEbteName(String ebteName) {
		this.ebteName = ebteName;
	}
	public String getEbteSex() {
		return ebteSex;
	}
	public void setEbteSex(String ebteSex) {
		this.ebteSex = ebteSex;
	}
	public String getEbteWorkType() {
		return ebteWorkType;
	}
	public void setEbteWorkType(String ebteWorkType) {
		this.ebteWorkType = ebteWorkType;
	}
	public String getEbteCard() {
		return ebteCard;
	}
	public void setEbteCard(String ebteCard) {
		this.ebteCard = ebteCard;
	}
	public String getEbteLocation() {
		return ebteLocation;
	}
	public void setEbteLocation(String ebteLocation) {
		this.ebteLocation = ebteLocation;
	}
	public Long getRecStatus() {
		return recStatus;
	}
	public void setRecStatus(Long recStatus) {
		this.recStatus = recStatus;
	}
	public String getEbteCode() {
		return ebteCode;
	}
	public void setEbteCode(String ebteCode) {
		this.ebteCode = ebteCode;
	}
	public String getEbteServiceArea() {
		return ebteServiceArea;
	}
	public void setEbteServiceArea(String ebteServiceArea) {
		this.ebteServiceArea = ebteServiceArea;
	}
	public Long getEbteAge() {
		return ebteAge;
	}
	public void setEbteAge(Long ebteAge) {
		this.ebteAge = ebteAge;
	}
	public String getEbteQq() {
		return ebteQq;
	}
	public void setEbteQq(String ebteQq) {
		this.ebteQq = ebteQq;
	}
	public Long getEbteIsHasCar() {
		return ebteIsHasCar;
	}
	public void setEbteIsHasCar(Long ebteIsHasCar) {
		this.ebteIsHasCar = ebteIsHasCar;
	}
	public String getEbteTeamCount() {
		return ebteTeamCount;
	}
	public void setEbteTeamCount(String ebteTeamCount) {
		this.ebteTeamCount = ebteTeamCount;
	}
	public String getEbteAccountHolder() {
		return ebteAccountHolder;
	}
	public void setEbteAccountHolder(String ebteAccountHolder) {
		this.ebteAccountHolder = ebteAccountHolder;
	}
	public String getEbteOpenBank() {
		return ebteOpenBank;
	}
	public void setEbteOpenBank(String ebteOpenBank) {
		this.ebteOpenBank = ebteOpenBank;
	}
	public String getEbteBankAccount() {
		return ebteBankAccount;
	}
	public void setEbteBankAccount(String ebteBankAccount) {
		this.ebteBankAccount = ebteBankAccount;
	}
	public String getEbteEmergencyLinkman() {
		return ebteEmergencyLinkman;
	}
	public void setEbteEmergencyLinkman(String ebteEmergencyLinkman) {
		this.ebteEmergencyLinkman = ebteEmergencyLinkman;
	}
	public String getEbteRelation() {
		return ebteRelation;
	}
	public void setEbteRelation(String ebteRelation) {
		this.ebteRelation = ebteRelation;
	}
	public Long getEbteContactNumber() {
		return ebteContactNumber;
	}
	public void setEbteContactNumber(Long ebteContactNumber) {
		this.ebteContactNumber = ebteContactNumber;
	}
	public Long getEbteReviewState() {
		return ebteReviewState;
	}
	public void setEbteReviewState(Long ebteReviewState) {
		this.ebteReviewState = ebteReviewState;
	}
	public String getEbteEsstStationCode() {
		return ebteEsstStationCode;
	}
	public void setEbteEsstStationCode(String ebteEsstStationCode) {
		this.ebteEsstStationCode = ebteEsstStationCode;
	}
	public String getEbteEsstStationName() {
		return ebteEsstStationName;
	}
	public void setEbteEsstStationName(String ebteEsstStationName) {
		this.ebteEsstStationName = ebteEsstStationName;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getEbteRemark() {
		return ebteRemark;
	}
	public void setEbteRemark(String ebteRemark) {
		this.ebteRemark = ebteRemark;
	}
	public String getEbteServiceGrade() {
		return ebteServiceGrade;
	}
	public void setEbteServiceGrade(String ebteServiceGrade) {
		this.ebteServiceGrade = ebteServiceGrade;
	}
	public Long getEbteType() {
		return ebteType;
	}
	public void setEbteType(Long ebteType) {
		this.ebteType = ebteType;
	}
	public Double getEbteScores() {
		return ebteScores;
	}
	public void setEbteScores(Double ebteScores) {
		this.ebteScores = ebteScores;
	}
	public String getEbtePassword() {
		return ebtePassword;
	}
	public void setEbtePassword(String ebtePassword) {
		this.ebtePassword = ebtePassword;
	}
	public String getEbteProperties() {
		return ebteProperties;
	}
	public void setEbteProperties(String ebteProperties) {
		this.ebteProperties = ebteProperties;
	}
	public String getEbteVerificateCode() {
		return ebteVerificateCode;
	}
	public void setEbteVerificateCode(String ebteVerificateCode) {
		this.ebteVerificateCode = ebteVerificateCode;
	}
	public Date getEbteVerificateCreateTime() {
		return ebteVerificateCreateTime;
	}
	public void setEbteVerificateCreateTime(Date ebteVerificateCreateTime) {
		this.ebteVerificateCreateTime = ebteVerificateCreateTime;
	}
	public Date getEbteVerificateInvalidTime() {
		return ebteVerificateInvalidTime;
	}
	public void setEbteVerificateInvalidTime(Date ebteVerificateInvalidTime) {
		this.ebteVerificateInvalidTime = ebteVerificateInvalidTime;
	}
	public String getEbteBranchBank() {
		return ebteBranchBank;
	}
	public void setEbteBranchBank(String ebteBranchBank) {
		this.ebteBranchBank = ebteBranchBank;
	}
	public String getEbtePhotoUrl1() {
		return ebtePhotoUrl1;
	}
	public void setEbtePhotoUrl1(String ebtePhotoUrl1) {
		this.ebtePhotoUrl1 = ebtePhotoUrl1;
	}
	public String getEbtePhotoUrl2() {
		return ebtePhotoUrl2;
	}
	public void setEbtePhotoUrl2(String ebtePhotoUrl2) {
		this.ebtePhotoUrl2 = ebtePhotoUrl2;
	}
	public String getEbtePhotoUrl3() {
		return ebtePhotoUrl3;
	}
	public void setEbtePhotoUrl3(String ebtePhotoUrl3) {
		this.ebtePhotoUrl3 = ebtePhotoUrl3;
	}
	public String getEbteParentWorkNo() {
		return ebteParentWorkNo;
	}
	public void setEbteParentWorkNo(String ebteParentWorkNo) {
		this.ebteParentWorkNo = ebteParentWorkNo;
	}
	public String getEbteParentName() {
		return ebteParentName;
	}
	public void setEbteParentName(String ebteParentName) {
		this.ebteParentName = ebteParentName;
	}
	public String getEbteIsModifyPwd() {
		return ebteIsModifyPwd;
	}
	public void setEbteIsModifyPwd(String ebteIsModifyPwd) {
		this.ebteIsModifyPwd = ebteIsModifyPwd;
	}
	public Double getEbteSalary() {
		return ebteSalary;
	}
	public void setEbteSalary(Double ebteSalary) {
		this.ebteSalary = ebteSalary;
	}
	public String getEbteBrandAttestationCode() {
		return ebteBrandAttestationCode;
	}
	public void setEbteBrandAttestationCode(String ebteBrandAttestationCode) {
		this.ebteBrandAttestationCode = ebteBrandAttestationCode;
	}
	public String getEbteBrandAttestationName() {
		return ebteBrandAttestationName;
	}
	public void setEbteBrandAttestationName(String ebteBrandAttestationName) {
		this.ebteBrandAttestationName = ebteBrandAttestationName;
	}
	public String getEbteCarCode() {
		return ebteCarCode;
	}
	public void setEbteCarCode(String ebteCarCode) {
		this.ebteCarCode = ebteCarCode;
	}
	public String getEbteCarName() {
		return ebteCarName;
	}
	public void setEbteCarName(String ebteCarName) {
		this.ebteCarName = ebteCarName;
	}
	public String getEbteSupplierCode() {
		return ebteSupplierCode;
	}
	public void setEbteSupplierCode(String ebteSupplierCode) {
		this.ebteSupplierCode = ebteSupplierCode;
	}
	public String getEbteSupplierName() {
		return ebteSupplierName;
	}
	public void setEbteSupplierName(String ebteSupplierName) {
		this.ebteSupplierName = ebteSupplierName;
	}
	public Long getEbteEnableState() {
		return ebteEnableState;
	}
	public void setEbteEnableState(Long ebteEnableState) {
		this.ebteEnableState = ebteEnableState;
	}
	public Long getEbteCertifiedState() {
		return ebteCertifiedState;
	}
	public void setEbteCertifiedState(Long ebteCertifiedState) {
		this.ebteCertifiedState = ebteCertifiedState;
	}
	public Long getEbteId() {
		return ebteId;
	}
	public void setEbteId(Long ebteId) {
		this.ebteId = ebteId;
	}
	
}

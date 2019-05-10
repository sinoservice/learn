package com.easyhome.po;

import java.util.Date;

public class Worker {
	private String masterId;
	
	private String fid;//id主键

    private String name;//姓名

    private String phone;//电话

    private String sex;//性别

    private String platFormId;//调度平台ID

    private String leaderId;//工长id

    private String platFormName;//调度平台

    private String identityCard;//身份证号

    private String city;//常住地

    private String workType;//工作技能

    private String workTypeDisplay;//工作技能显示内容

    private String serviceProvince;//省

    private String serviceCity;//市

    private String serviceDistrict;//县

    private String bankAccount;//开户人姓名

    private String bankName;//开户行

    private String bankNumber;//开户行账号

    private String sosLinkMan;//紧急联系人

    private String relationship;//关系

    private String linkPhone;//联系电话

    private String serviceProvinceDisplay;//服务区域省(常驻)

    private String serviceCityDisplay;//服务区域市(常驻)

    private String serviceDistrictDisplay;//服务区域县(常驻)

    private int status;//状态

    private Date createTime;//创建时间

    private String age;//年龄

    private String chat;//微信/QQ

    private String haveCar;//是否自带车辆

    private String haveTools;//是否自带安装工具

    private String havaInsurance;//有无意外险

    private String remark;//备注

    private String createUserId;//创建人id

    private String auditUserId;//审核人id

    private Date auditTime;//审核时间

    private String imageUrl1;//图片1

    private String imageUrl2;//图片2

    private String imageUrl3;//图片3

    private String auditUser;//审核人

    private String masterNo;//技师编号

    private String carType;//车型

    private String masterFrom;//及时来源
    //
    private String branch;//支行

    private int certificationStatus;//

    private String workSkill;//

    private Integer locking;//锁定标签
    
    private int tag;//删除标签

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPlatFormId() {
		return platFormId;
	}

	public void setPlatFormId(String platFormId) {
		this.platFormId = platFormId;
	}

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public String getPlatFormName() {
		return platFormName;
	}

	public void setPlatFormName(String platFormName) {
		this.platFormName = platFormName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkTypeDisplay() {
		return workTypeDisplay;
	}

	public void setWorkTypeDisplay(String workTypeDisplay) {
		this.workTypeDisplay = workTypeDisplay;
	}

	public String getServiceProvince() {
		return serviceProvince;
	}

	public void setServiceProvince(String serviceProvince) {
		this.serviceProvince = serviceProvince;
	}

	public String getServiceCity() {
		return serviceCity;
	}

	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}

	public String getServiceDistrict() {
		return serviceDistrict;
	}

	public void setServiceDistrict(String serviceDistrict) {
		this.serviceDistrict = serviceDistrict;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getSosLinkMan() {
		return sosLinkMan;
	}

	public void setSosLinkMan(String sosLinkMan) {
		this.sosLinkMan = sosLinkMan;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getLinkPhone() {
		return linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getServiceProvinceDisplay() {
		return serviceProvinceDisplay;
	}

	public void setServiceProvinceDisplay(String serviceProvinceDisplay) {
		this.serviceProvinceDisplay = serviceProvinceDisplay;
	}

	public String getServiceCityDisplay() {
		return serviceCityDisplay;
	}

	public void setServiceCityDisplay(String serviceCityDisplay) {
		this.serviceCityDisplay = serviceCityDisplay;
	}

	public String getServiceDistrictDisplay() {
		return serviceDistrictDisplay;
	}

	public void setServiceDistrictDisplay(String serviceDistrictDisplay) {
		this.serviceDistrictDisplay = serviceDistrictDisplay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	public String getHaveCar() {
		return haveCar;
	}

	public void setHaveCar(String haveCar) {
		this.haveCar = haveCar;
	}

	public String getHaveTools() {
		return haveTools;
	}

	public void setHaveTools(String haveTools) {
		this.haveTools = haveTools;
	}

	public String getHavaInsurance() {
		return havaInsurance;
	}

	public void setHavaInsurance(String havaInsurance) {
		this.havaInsurance = havaInsurance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public String getMasterNo() {
		return masterNo;
	}

	public void setMasterNo(String masterNo) {
		this.masterNo = masterNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getMasterFrom() {
		return masterFrom;
	}

	public void setMasterFrom(String masterFrom) {
		this.masterFrom = masterFrom;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getCertificationStatus() {
		return certificationStatus;
	}

	public void setCertificationStatus(int certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

	public String getWorkSkill() {
		return workSkill;
	}

	public void setWorkSkill(String workSkill) {
		this.workSkill = workSkill;
	}

	public Integer getLocking() {
		return locking;
	}

	public void setLocking(Integer locking) {
		this.locking = locking;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	
}

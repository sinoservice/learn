package com.easyhome.po;

import java.math.BigDecimal;
import java.util.Date;

public class TbAppUser {
    private String fid;

    private String phone;

    private String password;

    private String name;

    private Date addDate;

    private Short isDisable;

    private Date lastLoginTime;

    private BigDecimal status;

    private String sex;

    private BigDecimal isDriver;

    private BigDecimal isInstall;

    private BigDecimal driverId;

    private String masterId;

    private String driverName;

    private String masterName;

    private BigDecimal platFormId;

    private String platFormName;

    private Short isModifyPwd;

    private Short userType;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Short getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Short isDisable) {
        this.isDisable = isDisable;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public BigDecimal getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(BigDecimal isDriver) {
        this.isDriver = isDriver;
    }

    public BigDecimal getIsInstall() {
        return isInstall;
    }

    public void setIsInstall(BigDecimal isInstall) {
        this.isInstall = isInstall;
    }

    public BigDecimal getDriverId() {
        return driverId;
    }

    public void setDriverId(BigDecimal driverId) {
        this.driverId = driverId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public BigDecimal getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(BigDecimal platFormId) {
        this.platFormId = platFormId;
    }

    public String getPlatFormName() {
        return platFormName;
    }

    public void setPlatFormName(String platFormName) {
        this.platFormName = platFormName == null ? null : platFormName.trim();
    }

    public Short getIsModifyPwd() {
        return isModifyPwd;
    }

    public void setIsModifyPwd(Short isModifyPwd) {
        this.isModifyPwd = isModifyPwd;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }
}
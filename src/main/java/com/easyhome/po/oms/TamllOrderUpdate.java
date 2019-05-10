package com.easyhome.po.oms;
/**
 * 
* @ClassName: TamllOrderUpdate 
* @Description: TODO 喵师傅接口升级_天猫单预约接口实体类
* @date 2017年2月9日 下午5:52:06 
*
 */
public class TamllOrderUpdate {

	public String workorderid;//工单号
	public String masterid;//技师ID
	public String call;//是否拨打过电话：是，否
	public String date;//	预约日期
	public String timeQuantum;//预约时间段
	public int status;//预约成功或失败 0：失败 1：成功
	public String remark;//预约备注
	public String twiceDate;//二次预约时间
	public String reasonCode;//预约失败原因code
	public String reasonName;//预约失败原因
	public String getWorkorderid() {
		return workorderid;
	}
	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}
	public String getMasterid() {
		return masterid;
	}
	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimeQuantum() {
		return timeQuantum;
	}
	public void setTimeQuantum(String timeQuantum) {
		this.timeQuantum = timeQuantum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTwiceDate() {
		return twiceDate;
	}
	public void setTwiceDate(String twiceDate) {
		this.twiceDate = twiceDate;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
		
}

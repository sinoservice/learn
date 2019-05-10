package com.easyhome.vo;

/**
 * 
 * <p>title: WorkOrderReportBaseBean</p>
 * <p>description: 放弃工单报表模型</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月25日 上午11:06:52
 */
public class WorkOrderQuitReportModel extends WorkOrderReportBaseBean{
	
	private String isQuit; //是否放弃工单,
	private String quitDate; //放弃日期,
	private String quitTime; //放弃时间,
	private String reason; //放弃原因
	
	public String getIsQuit() {
		return isQuit;
	}
	public void setIsQuit(String isQuit) {
		this.isQuit = isQuit;
	}
	public String getQuitDate() {
		return quitDate;
	}
	public void setQuitDate(String quitDate) {
		this.quitDate = quitDate;
	}
	public String getQuitTime() {
		return quitTime;
	}
	public void setQuitTime(String quitTime) {
		this.quitTime = quitTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}

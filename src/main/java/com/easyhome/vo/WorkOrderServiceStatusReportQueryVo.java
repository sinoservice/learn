package com.easyhome.vo;

/**
 * 
 * <p>title: WorkOrderServiceStatusReportQueryVo</p>
 * <p>description: 工单服务状态查询条件类</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月23日 下午5:33:16
 */
public class WorkOrderServiceStatusReportQueryVo {
	
	//创建日期开始
	private String billDateStart;
	//创建日期结束
	private String billDateEnd;
	//派单日期开始
	private String sendDateStart;
	//派单日期结束
	private String sendDateEnd;
	//预约失败原因
	private String remark;
	
	public String getBillDateStart() {
		return billDateStart;
	}
	public void setBillDateStart(String billDateStart) {
		this.billDateStart = billDateStart;
	}
	public String getBillDateEnd() {
		return billDateEnd;
	}
	public void setBillDateEnd(String billDateEnd) {
		this.billDateEnd = billDateEnd;
	}
	public String getSendDateStart() {
		return sendDateStart;
	}
	public void setSendDateStart(String sendDateStart) {
		this.sendDateStart = sendDateStart;
	}
	public String getSendDateEnd() {
		return sendDateEnd;
	}
	public void setSendDateEnd(String sendDateEnd) {
		this.sendDateEnd = sendDateEnd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "WorkOrderServiceStatusReportQueryVo [billDateStart=" + billDateStart + ", billDateEnd=" + billDateEnd
				+ ", sendDateStart=" + sendDateStart + ", sendDateEnd=" + sendDateEnd + ", remark=" + remark + "]";
	}
	
	
	
}

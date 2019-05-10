package com.easyhome.po.oms;

public class QuitWorkor {
	
	//工单ID
	private String workorderid;
	//放弃原因
	private String remark;
	public String getWorkorderid() {
		return workorderid;
	}
	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "QuitWorkor [workorderid=" + workorderid + ", remark=" + remark + "]";
	}
	public QuitWorkor(String workorderid, String remark) {
		super();
		this.workorderid = workorderid;
		this.remark = remark;
	}
	public QuitWorkor() {
		
	}
	
	
	

}

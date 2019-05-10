package com.easyhome.po;

import java.util.Date;

public class WorkerOrderTransform {

	private String fid;
	private String workOrderId;
	private String workerId;
	private String workerName;
	private String workerPhone;
	private String workerType;
	private Date transFormDate;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(String workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public String getWorkerType() {
		return workerType;
	}

	public void setWorkerType(String workerType) {
		this.workerType = workerType;
	}

	public Date getTransFormDate() {
		return transFormDate;
	}

	public void setTransFormDate(Date transFormDate) {
		this.transFormDate = transFormDate;
	}
}

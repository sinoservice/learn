package com.easyhome.po;

public class WorkerSelectEntity {

	private String workerId;
	
	private String workerName;
	
	private String workerPhone;
	
	private int workingOrderCount;

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

	public int getWorkingOrderCount() {
		return workingOrderCount;
	}

	public void setWorkingOrderCount(int workingOrderCount) {
		this.workingOrderCount = workingOrderCount;
	}

	public String getWorkerPhone() {
		return workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}
	
}

package com.easyhome.po;

public class TransFormParams {
	
      private String workorderId;//工单ID
      
      private String workerId;//工人ID
      
      private String masterId;//技师或工长ID
      
//      private int workerType;//工人的类型

	public String getWorkorderId() {
		return workorderId;
	}

	public void setWorkorderId(String workorderId) {
		this.workorderId = workorderId;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

//	public int getWorkerType() {
//		return workerType;
//	}
//
//	public void setWorkerType(int workerType) {
//		this.workerType = workerType;
//	}

//	@Override
//	public String toString() {
//		return "TransFormParams [workorderId=" + workorderId + ", workerId=" + workerId + ", masterId=" + masterId
//				+ ", workerType=" + workerType + "]";
//	}
//      
//      
      
}

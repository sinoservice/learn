package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface WorkOrderBackupService {

	//public BaseResponse addBackup(WorkOrderBackup workOrderBackup);
	//public BaseResponse findAll(String workNo);
	public BaseResponse deleteBackup(String workNo,String revokeCause,String revokeName);
	
	public String testJpush();
}

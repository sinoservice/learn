
package com.easyhome.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.WorkOrderBackupService;
import com.easyhome.vo.BaseResponse;

@RestController
@RequestMapping("/backup")
public class WorkOrderBackupController {
	@Resource
	private WorkOrderBackupService workOrderBackupService;
	@RequestMapping("/deleteBackup")
	public BaseResponse deleteBackup(String workNo,String revokeCause,String revokeName){
		BaseResponse response=workOrderBackupService.deleteBackup(workNo, revokeCause, revokeName);
		return response;
	}
	
	@RequestMapping("/test")
	public BaseResponse test(){
		BaseResponse response=new BaseResponse();
		String result = workOrderBackupService.testJpush();
		response.setData(result);
		return response;
	}
}

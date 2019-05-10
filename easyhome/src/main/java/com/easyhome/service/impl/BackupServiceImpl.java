package com.easyhome.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.easyhome.dao.BackupDao;
import com.easyhome.po.WorkOrderBackup;
import com.easyhome.service.BackupService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.MyResponse;

@Service("backupService")
public class BackupServiceImpl implements BackupService{
  @Resource
  private BackupDao backupDao;
  
  Log log = LogFactory.getLog(BackupServiceImpl.class);


	public MyResponse findWorkOrder(String workNo) {
		MyResponse response = new MyResponse();
		try{
			if(workNo!=null&&workNo!=""){
		List<WorkOrderBackup> list = backupDao.findWorkOrder(workNo);
		if(list!=null && list.size()>0){
			WorkOrderBackup workOrderBackup = list.get(0);
			List<Object> detail = backupDao.findItems(workOrderBackup.getFid());
			response.setData(workOrderBackup);
			response.setDetail(detail);
		}
		response.setReturnCode(ReturnCode.STATUS_200);
			}
		}catch(Exception e){
			log.error("工单输入有误",e);
			response.setReturnCode(ReturnCode.STATUS_404);
			response.setInfo("工单不存在");
		}
		return response;	
	}
}

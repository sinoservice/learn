package com.easyhome.service.impl;

import java.util.Date;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyhome.dao.WorkOrderBackupdao;
import com.easyhome.po.WorkOrderBackup;
import com.easyhome.service.WorkOrderBackupService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
@Service("workOrderBackupService")
@Transactional
public class WorkOrderBackupServiceImpl implements WorkOrderBackupService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkOrderBackupServiceImpl.class);
	
	@Resource
	private WorkOrderBackupdao workOrderBackupDao;

	public BaseResponse deleteBackup(String workNo,String revokeCause,String revokeName) {
		BaseResponse response=new BaseResponse();
	
		try {
			WorkOrderBackup workOrderBackup=workOrderBackupDao.findAll(workNo);
			//备份工单
			if(workOrderBackup!=null && (workOrderBackup.getStatus()==0 || workOrderBackup.getStatus()==1 
					|| workOrderBackup.getStatus()==2 || workOrderBackup.getStatus()==3 
					|| workOrderBackup.getStatus()==8 || workOrderBackup.getStatus()==9)){
				workOrderBackup.setRevokeCause(revokeCause);
				workOrderBackup.setRevokeTime(new Date());
				workOrderBackup.setRevokeName(revokeName);
				workOrderBackupDao.addBackup(workOrderBackup);
				response.setReturnCode(ReturnCode.STATUS_200);
				//response.setData(workOrderBackup);
				response.setInfo(ReturnCode.OK);
				logger.info("工单备份成功！");
				//删除工单
				
				workOrderBackupDao.deleteBackup(workNo);
				response.setData(workOrderBackup);
				response.setReturnCode(ReturnCode.STATUS_204);
				response.setInfo("操作成功，您的工单已删除！");
				System.out.println(response.getData()+response.getInfo()+response.getReturnCode());
				logger.info("工单删除成功！");
				
				String title = "你好";
				String content = "你的工单已撤销！";
				String alias = "123344455";

				String result = null;
				try {
					String url = "http://192.16.8.54:8080/eaju_push_service/myJpush/pushAlias?alias="+alias+"&title="+title+"&content="+content;
					//result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
					result=HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
					logger.info("接口连接返回数据："+result);
				} catch (Exception e) {
					
					logger.error("短信接口连接失败！",e);
				}
				
			}else{
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("操作失败，您输入的工单不存在或此工单处于不可删除状态，请检查后重新输入！");
				logger.info("工单不存在或此工单处于不可删除状态");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！",e);
		}
		//System.out.println(response.getData()+response.getInfo()+response.getReturnCode());
		return response;
	}
	public String testJpush(){
		String result = null;
		String title = "你好";
		String alias = "123344455";
		String content = "你的工单已撤销！";//http://pushAlias?alias=123&title=NBA&content=kob
		String url = "http://192.16.8.54:8080/eaju_push_service/myJpush/pushAlias?alias="+alias+"&title="+title+"&content="+content;
		try {
			result = HttpXmlClient.get(url, HttpXmlClient.APPLICATION_JSON);
		} catch (Exception e) {
			logger.error("短信接口连接失败！",e);
		}
		return result;
	}

}

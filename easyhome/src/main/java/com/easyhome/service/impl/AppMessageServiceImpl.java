package com.easyhome.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.dao.AppMessageDao;
import com.easyhome.po.AppMessage;
import com.easyhome.po.AppPushMessage;
import com.easyhome.po.Version;
import com.easyhome.service.AppMessageService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

@Service("appMessageService")
public class AppMessageServiceImpl implements AppMessageService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppMessageServiceImpl.class);
	@Resource
	private AppMessageDao appMessageDao;
	public BaseResponse save(String appVersion,String model,String androidVersion,String masterId,String phone) {
		BaseResponse response=new BaseResponse();
		try {
			AppMessage appMessage=appMessageDao.findById(masterId);//获取这些数据
			//根据masterid查询APPversion 
			if(appMessage == null){
				//添加信息
				int data=appMessageDao.addVersion(appVersion, model, androidVersion, masterId,phone);
				response.setData(data);
				response.setInfo(ReturnCode.OK);
				response.setReturnCode(ReturnCode.STATUS_201);
				logger.info("添加数据成功");
			}else{
				//跟传入参数比较
				if(masterId.equals(appMessage.getMasterId()) && (model.equals(appMessage.getModel())
						|| androidVersion.equals(appMessage.getAndroidVersion()) 
						|| appVersion.equals(appMessage.getAppVersion()))){
					//如果不一样就update
					appMessageDao.updateById(appVersion, model, androidVersion,masterId,phone);
					response.setReturnCode(ReturnCode.STATUS_200);
					response.setData(masterId);
					response.setInfo(ReturnCode.OK);
					logger.info("更新数据成功");
				}
					//如果传入参数是一样return 
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("获取数据异常！");
			logger.error("获取数据异常",e);
		}
		return response;
	}
	@Override
	public BaseResponse UpdateVersion(String phone,String appVersion) {
		BaseResponse response=new BaseResponse();		
		try {
			//判断是否是灰度发布用户
			Version version_2=appMessageDao.findVersion(2);//灰度发布版本
			Version version_1=appMessageDao.findVersion(1);//普通升级版本
			//灰度用户升级
			if(version_2 != null){
				String app_version_2=version_2.getAppVersion();
				double new_version_2=Double.parseDouble(app_version_2);
				double old_version=Double.parseDouble(appVersion);
				List<String> user=appMessageDao.findPhone();
				//是灰度发布用户，不是最新版本，提示更新
				if(user.contains(phone)==true){
					if(new_version_2 > old_version){
						version_2.setFlag(1);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_2);
						response.setInfo(ReturnCode.OK);
						logger.info("灰度用户更新成功");
					}else{
						version_2.setFlag(0);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_2);
						response.setInfo("不需要升级");
						logger.info("不需要升级");
					}
				}else{
					//不是灰度发布用户，检查版本是否是最新版本
					String app_version_1=version_1.getAppVersion();
					double new_version_1=Double.parseDouble(app_version_1);
					if(new_version_1 > old_version){
						version_1.setFlag(1);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_1);
						response.setInfo(ReturnCode.OK);
						logger.info("大众版本更新成功");
					}else{
						version_1.setFlag(0);
						response.setReturnCode(ReturnCode.STATUS_200);
						response.setData(version_1);
						response.setInfo(ReturnCode.OK);
						logger.info("不需要升级");
					}
				}
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo(ReturnCode.FAIL);
			logger.error("获取数据异常！",e);
		}
		return response;
	}
	/**
	 * 查询推送消息
	 */
	public BaseResponse findAppMessage(String userid,Integer pageindex,Integer pagesize,Integer status) {
		BaseResponse response=new BaseResponse();
		List<AppPushMessage> message=null;
		try {
			int rowStart = ((pageindex - 1) * pagesize) + 1;
			int rowEnd = pageindex * pagesize;
			//未读消息
			if(status==1){
				message=appMessageDao.findUnread(userid,rowStart,rowEnd);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setData(message);
				response.setInfo(ReturnCode.OK);
				logger.info("查询数据成功");
			}
			//已读消息
			if(status==2){
				message=appMessageDao.findRead(userid,rowStart,rowEnd);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setData(message);
				response.setInfo(ReturnCode.OK);
				logger.info("查询数据成功");
			}
			//全部消息
			if(status==3){
				message=appMessageDao.findAll(userid,rowStart,rowEnd);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setData(message);
				response.setInfo(ReturnCode.OK);
				logger.info("查询数据成功");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("获取数据异常");
			logger.error("获取数据异常",e);
		}
		return response;
	}
}	

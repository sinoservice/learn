package com.easyhome.service.impl;

import org.apache.log4j.Logger;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyhome.dao.AppraiseDao;
import com.easyhome.po.Appraise;
import com.easyhome.po.AppraiseMessage;
import com.easyhome.service.AppraiseService;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;

@Service("addAppraise")
public class AppraiseServiceImpl implements AppraiseService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppraiseServiceImpl.class);

	@Resource
	private AppraiseDao appraiseDao;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.easyhome.service.AppraiseService#addAppraise(java.lang.String,
	 * java.lang.String, java.lang.Long, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer)
	 */

	public BaseResponse addAppraise(String workorderid,Integer evalServiceComplete,
			Integer evalDelivery, Integer evalInstall, Integer evalPhoneBack) {
		BaseResponse response = new BaseResponse();
		
		try {
			AppraiseMessage all = appraiseDao.findAppraiseMessage(workorderid);
			// 判断workorderid是否已评价过，如果已经评价过返回已评价表示
			// update评价信息
			// 更新工单评价信息，首先工单必须存在
			if (all != null) {
				AppraiseMessage appraiseMessage = new AppraiseMessage();
				appraiseMessage.setEvalServiceComplete(evalServiceComplete);
				appraiseMessage.setEvalDelivery(evalDelivery);
				appraiseMessage.setEvalInstall(evalInstall);
				appraiseMessage.setEvalPhoneBack(evalPhoneBack);
				appraiseMessage.setWorkorderid(workorderid);
				appraiseDao.updateAppraise(appraiseMessage);
				response.setData(workorderid);
				response.setReturnCode(ReturnCode.STATUS_201);
				logger.info("更新数据成功！");
			} else {
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("已评价");
				logger.info("更新数据失败");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！");
		}
		return response;
	}

	public BaseResponse findAppraiseMessage(String workorderid) {
		BaseResponse response = new BaseResponse();
		
		try {
			Appraise appraise = appraiseDao.findAppraise(workorderid);
			if (appraise != null) {
				// 评价过
				AppraiseMessage appraiseMessage = appraiseDao.findAppraiseMessage(workorderid);
				System.out.println("appraiseMessage" + appraiseMessage);
				response.setData(appraiseMessage);
				response.setReturnCode(ReturnCode.STATUS_200);
				response.setInfo(ReturnCode.OK);
				logger.info("");
			} else {
				// 没有评价
				response.setReturnCode(ReturnCode.STATUS_404);
				response.setInfo("NO APPRAISE");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！");
		}
		return response;
	}
	//增加二维码信息
	public BaseResponse addMessage(String workorderid,String address){
		BaseResponse response = new BaseResponse();
		try {
			AppraiseMessage all = appraiseDao.findAppraiseMessage(workorderid);
			if(all != null){
				Appraise appraise = new Appraise();
				appraise.setWorkorderid(workorderid);
				appraise.setAddress(address);
				appraise.setTime(new Date());
				appraiseDao.save(appraise);
				response.setData(appraise);
				response.setReturnCode(ReturnCode.STATUS_201);
				response.setInfo(ReturnCode.OK);
			}else{
				response.setReturnCode(ReturnCode.STATUS_400);
				response.setInfo("NO ORDER");
				logger.info("添加二维码失败");
			}
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！");
		}
		
		return response;
	}
}

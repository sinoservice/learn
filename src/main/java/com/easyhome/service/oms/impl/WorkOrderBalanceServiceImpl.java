package com.easyhome.service.oms.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import com.easyhome.service.oms.WorkOrderBalanceService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.vo.OrderResult;
import com.google.gson.Gson;


@Service("workOrderBalanceService")
public class WorkOrderBalanceServiceImpl implements WorkOrderBalanceService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WorkOrderBalanceServiceImpl.class);
	
	public String findWorkOrderBalance(String masterid,Integer pageindex,Integer pagesize,String startdate,String enddate) {
		OrderResult result=new OrderResult();
		Gson gson = new Gson();
		try {
			if(startdate.length()>8){
				startdate = startdate.replace("-", "/") +" 00:00:01";
			}
			if(enddate.length()>8){
				enddate = enddate.replace("-", "/") + " 23:59:59";
			}
			
			Map<String ,Object> params=new HashMap<String ,Object>();
			params.put("masterid", masterid);
			params.put("startdate", startdate);
			params.put("enddate", enddate);
			params.put("pageIndex", pageindex);
			params.put("pagesize", pagesize);
			String methodName="appQueryAccounts";
			
			String json = gson.toJson(params);
			logger.info(json);
			String data = OmsConnectUtil.getData(methodName, params);
			logger.info(data);
			return data;
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.info("数据获取异常");
		}
		return gson.toJson(result);
	}
}

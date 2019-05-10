package com.easyhome.service.oms.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.oms.TamllOrderUpdate;
import com.easyhome.service.oms.AppTamllOrderServiceI;
import com.easyhome.utils.OmsConnectUtil;

/**
 * 
* @ClassName: AppTamllOrderServiceImpl 
* @Description: TODO 喵师傅接口升级
* @date 2017年2月9日 下午5:41:21 
*
 */
@Service("AppTamllOrderServiceI")
public class AppTamllOrderServiceImpl implements AppTamllOrderServiceI {
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppTamllOrderServiceImpl.class);

	/**
	 * 预约记录列表接口
	 */
	@Override
	public String appBespokeDispatchRecordList(String workorderid, String masterid) {
		String data = null;
		try {
			
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("workorderid", workorderid);
			params.put("masterid", masterid);
			
			//发送请求
			data = OmsConnectUtil.getData("appBespokeDispatchRecordList", params);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 天猫单预约接口
	 */
	@Override
	public String appTmallBespokeDispatch(TamllOrderUpdate orderUpdate) {
		String data = null;
		try {
			
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("workorderid", orderUpdate.getWorkorderid());
			params.put("masterid", orderUpdate.getMasterid());
			params.put("call", orderUpdate.getCall());
			params.put("date", orderUpdate.getDate());
			params.put("timeQuantum", orderUpdate.getTimeQuantum());
			params.put("status", orderUpdate.getStatus());
			params.put("remark", orderUpdate.getRemark());
			params.put("reasonCode", orderUpdate.getReasonCode());
			params.put("reasonName", orderUpdate.getReasonName());
			params.put("twiceDate", orderUpdate.getTwiceDate());
			//发送请求
			data = OmsConnectUtil.getData("appTmallBespokeDispatch", params);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public String appBespokeDispatchTwiceReservationTimeRecordList(String masterid) {
		String data = null;
		try {
			
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterid", masterid);
			
			//发送请求
			data = OmsConnectUtil.getData("appBespokeDispatchTwiceReservationTimeRecordList", params);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}
	
}

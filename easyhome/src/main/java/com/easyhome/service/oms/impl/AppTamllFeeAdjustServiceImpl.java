package com.easyhome.service.oms.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.easyhome.po.oms.AdjustRequest;
import com.easyhome.service.oms.AppTamllFeeAdjustService;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.vo.AdjustResult;
import com.google.gson.Gson;

/**
 * 
* @ClassName: AppTamllFeeAdjustServiceImpl 
* @Description: TODO app天猫费用调整单实现类 ，
*                    业务功能：作为接口提供者和app前端的桥梁，提供申请、查询、修改、取消等数据的传导
*                    以及无需安装数据的传导。
* @date 2016年9月1日 下午5:34:24 
*
 */
@Service("appTamllFeeAdjustService")
public class AppTamllFeeAdjustServiceImpl implements AppTamllFeeAdjustService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AppTamllFeeAdjustServiceImpl.class);
	

	/**
	 * 查询费用调整单
	 */
	public String search(String masterId, String orderNo) {
        //调整单Base
		AdjustResult result = new AdjustResult();
		Gson gson = new Gson();
		try {
			//将参数传入
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("masterId", masterId);
			params.put("orderNo", orderNo);
			
			//调用接口："appTamllFeeAdjustSearch"查询数据，返回data
			String data = OmsConnectUtil.getData("appTamllFeeAdjustSearch", params);
			logger.info("费用调整单查询成功");
			return data;
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("数据获取异常");
			logger.error("数据获取异常", e);
			return gson.toJson(result);
		}
	}
	
    /**
     * 申请费用调整单
     */
	public AdjustResult apply(AdjustRequest adjustRequest) {
		AdjustResult result = new AdjustResult();
		Gson gson = new Gson();
		try {
			//将费用申请参数传入Map集合中
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterId", adjustRequest.getMasterId());
			params.put("orderNo", adjustRequest.getOrderNo());
			params.put("code", adjustRequest.getCode());
			params.put("remark", adjustRequest.getRemark());
			params.put("list", adjustRequest.getList());
			
			//发送请求
			String data = OmsConnectUtil.getData("appTamllFeeAdjust",params);
			
			//解析数据
			if(data!=null){
				JSONObject json = JSONObject.parseObject(data);
				int errCode = json.getIntValue("errCode");
				String errMsg = json.getString("errMsg");
				if(errCode==0){					
					//申请成功
					result.setErrCode(0);
					result.setErrMsg("申请成功");
					logger.info("申请发送成功");
				}else{
					//申请失败
					result.setErrCode(-1);
					result.setErrMsg(errMsg);
					logger.info("申请失败");
				}
			}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("申请操作异常");
			logger.error("获取数据异常", e);
		}
		return result;
	}
    /**
     * 取消调整费用单
     */
	public AdjustResult cancel(String masterId, String ethcId) {
		AdjustResult result = new AdjustResult();
		try {
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterId", masterId);
			params.put("ethcId", ethcId);
			
			//发送请求
			String data = OmsConnectUtil.getData("cancelAdjustFee", params);
			
			//解析数据
			if(data!=null){
				JSONObject json = JSONObject.parseObject(data);
				int errCode = json.getIntValue("errCode");
				String errMsg = json.getString("errMsg");
				if(errCode==0){					
					//申请成功
					result.setErrCode(0);
					result.setErrMsg("取消成功");
					logger.info("取消申请发送成功");
				}else{
					//申请失败
					result.setErrCode(-1);
					result.setErrMsg(errMsg);
					logger.info("取消失败");
				}
			}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("取消操作异常");
			logger.error("获取数据异常", e);
		}
		return result ;
	}
    
	/**
	 * 修改调整费用单
	 */
	public AdjustResult update(AdjustRequest adjustRequest) {
		AdjustResult result = new AdjustResult();
		try {
			//将费用修改参数传入Map集合中
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterId", adjustRequest.getMasterId());
			params.put("ethcId", adjustRequest.getEthcId());
			params.put("code", adjustRequest.getCode());
			params.put("remark", adjustRequest.getRemark());
			params.put("list", adjustRequest.getList());
			
			//发送请求
			String data = OmsConnectUtil.getData("updateAdjustFee",params);
			
			//解析数据
			if(data!=null){
				JSONObject json = JSONObject.parseObject(data);
				int errCode = json.getIntValue("errCode");
				String errMsg = json.getString("errMsg");
				if(errCode==0){					
					//修改成功
					result.setErrCode(0);
					result.setErrMsg("修改成功");
					logger.info("修改成功");
				}else{
					//修改失败
					result.setErrCode(-1);
					result.setErrMsg(errMsg);
					logger.info("修改失败");
				}
			}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("修改操作异常");
			logger.error("获取数据异常", e);
		}
		return result;
	}
	
    /**
     * 无需安装
     */
	public AdjustResult noNeedInstall(String orderNo, String[] ethcId, String remark) {
		AdjustResult result = new AdjustResult();
		try {
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("orderNo", orderNo);
			params.put("ethcId", ethcId);
			params.put("remark", remark);
			//发送请求
			String data = OmsConnectUtil.getData("noNeedIstall", params);
			
			//解析数据
			if(data!=null){
				JSONObject json = JSONObject.parseObject(data);
				int errCode = json.getIntValue("errCode");
				String errMsg = json.getString("errMsg");
				if(errCode==0){					
					//修改成功
					result.setErrCode(0);
					result.setErrMsg("无需安装请求成功");
					logger.info("无需安装请求成功");
				}else{
					//修改失败
					result.setErrCode(-1);
					result.setErrMsg(errMsg);
					logger.info("无需安装请求失败");
				}
			}
		} catch (Exception e) {
			result.setErrCode(-1);
			result.setErrMsg("无需安装操作异常");
			logger.error("获取数据异常", e);
		}
		return result ;
	}

	/**
	 * 费用调整类型
	 */
	
	@Override
	public String appGetAdjustTypeData(String orderNo) {
		String data = null;
		try {
			
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("orderNo", orderNo);
			logger.info(params);
			
			//发送请求
            data = OmsConnectUtil.getData("appGetAdjustTypeData", params);
            logger.info(data);
            return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 申请费用调整
	 */
	@Override
	public String appOutLineFeeAdjust(String requestJson) {
		String data = null;
		try {
			
			//发送请求
			data = OmsConnectUtil.getData("appOutLineFeeAdjust", requestJson);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 费用详情
	 */
	@Override
	public String appFeeApplyIterface(String workorderid, String masterid) {
		String data = null;
		try {
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("workorderid", workorderid);
			params.put("masterid", masterid);
			
			//发送请求
			data = OmsConnectUtil.getData("appFeeApplyIterface", params);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 费用调整查询
	 */
	@Override
	public String appFeeAdjustSearch(String masterId, String orderNo, String itemId) {
		String data = null;
		try {
			
			//传入参数
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("masterId", masterId);
			params.put("orderNo", orderNo);
			params.put("itemId", itemId);
			
			//发送请求
			data = OmsConnectUtil.getData("appFeeAdjustSearch", params);
			logger.info(data);
			
			return data;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public String appDeliveryFinished(String data) {
		String result = null;
		try {
			
			//发送请求
			result = OmsConnectUtil.getData("appDeliveryFinished", data);
			
			logger.info(result);
			
			return result;
		} catch (Exception e) {
			logger.info("请求失败");
			e.printStackTrace();
		}
		return data;
	}
}

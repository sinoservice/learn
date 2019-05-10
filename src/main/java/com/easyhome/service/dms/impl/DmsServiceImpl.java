package com.easyhome.service.dms.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.service.dms.DmsServiceI;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.MD5;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.dms.AppVersionBean;
import com.easyhome.vo.dms.BusStorageBean;
import com.google.gson.Gson;

/**
 * 
 * <p>标题: DmsServiceImpl</p>
 * <p>描述: DMS服务实现</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年10月19日 上午8:54:37</p>
 * <p>版本: 1.0</p>
 */
@Service
public class DmsServiceImpl implements DmsServiceI{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DmsServiceImpl.class);

	@Override
	public String refuseDispatch(String masterId, String workOrderId) {
		
		Gson gson = new Gson();
		try {
			
			String url = ResourcesUtil.getValue("config", "dmsurl");
			
			//请求地址
			String refuseDispatchUrl = url + "dispatch";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("etdlNo", workOrderId);
			params.put("etdlTeachnologistNo", masterId);
			
			String data = gson.toJson(params);
			logger.info("请求参数：" + data);
			String method = "workerRefuseOperation";
			
			Map<String, String> par = new HashMap<>();
			par.put("method", method);
			par.put("data", data);
			
			
			String result = HttpXmlClient.post(refuseDispatchUrl, par);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
			return gson.toJson(br);
			
		}
		
	}

	/**
	 * dms订单状态查询
	 */
	@Override
	public String SearchOrderStatus(String customerOrderNo, String randomStr,String sign){
		
		Gson gson = new Gson();
		
		BaseResponse br = new BaseResponse();
		
		try {
			
			String key = MD5.MD5Encode(customerOrderNo+randomStr+"EAJU");
			
			//认证成功
			if(key.equals(sign))
			{
				String url = ResourcesUtil.getValue("config", "dmsurl");
				
				//请求地址
				String orderNoUrl = url + "dispatch";
				
				Map<String, Object> params = new HashMap<>();
				params.put("customerOrderNo", customerOrderNo);
				String data = gson.toJson(params);		
				Map<String, String> par = new HashMap<>();		
				par.put("method", "searchOrderStatus");
				par.put("data", data);
				String result = HttpXmlClient.post(orderNoUrl, par);
		
				logger.info("返回结果：" + result);
				return result;
			}
			
			//签名失败
			else
			{
				br.setInfo("签名失败");
				br.setReturnCode(500);
				return gson.toJson(br);
			}
	        
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
			return gson.toJson(br);
		}
	}

	@Override
	public String findAppDispatchList(String masterId, String status, int pageSize, int pageIndex, String lng, String lat, String orderBy,
			String isReviewFlag) {
        Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = ResourcesUtil.getValue("config", "dmsurl");

			// 请求地址
			String refuseDispatchUrl = url + "dispatch";

			Map<String, Object> params = new HashMap<String, Object>();
			if ("0".equals(status)) {// 抢单
				params.put("orderStatu", "00");
			}
			if ("1".equals(status)) {
				params.put("orderStatu", "25");
			}
			if ("2".equals(status)) {
				params.put("orderStatu", "35");
			}
			if ("3".equals(status)) {
				params.put("orderStatu", "30,80");
			}
			if ("4".equals(status)) {
				params.put("orderStatu", "85,90,210,220,230,240 ");
			}
			params.put("supplierCode", masterId);
			if (!"0".equals(status)) {
				params.put("isDispatch", 0);
			}
			params.put("pageSize", pageSize);
			params.put("pageIndex", pageIndex);
			params.put("lng", lng);
			params.put("lat", lat);
			params.put("orderBy", orderBy);
			params.put("status", status);
			params.put("isReviewFlag", isReviewFlag);//技师审核状态

			String data = gson.toJson(params);
			logger.info("请求参数：" + data);
			String method = "getAppDispatchList";

			Map<String, String> par = new HashMap<>();
			par.put("method", method);
			par.put("data", data);

			String result = HttpXmlClient.post(refuseDispatchUrl, par);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();

			br.setInfo("未知错误异常");
			br.setReturnCode(500);
			return gson.toJson(br);
		} finally {
			br = null;
			gson = null;
		}
	}

	/**
	 * 查找图片实现类
	 */
	@Override
	public String findImgs(String orderNo) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = ResourcesUtil.getValue("config", "dmsurl");

			// 请求地址
			String imgUrl = url + "baseInfo";

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orderNo", orderNo);

			String data = gson.toJson(params);
			logger.info("请求参数：" + data);
			String method = "findImgs";

			Map<String, String> par = new HashMap<>();
			par.put("method", method);
			par.put("data", data);

			String result = HttpXmlClient.post(imgUrl, par);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();

			br.setInfo("未知错误异常");
			br.setReturnCode(500);
			return gson.toJson(br);
		} finally {
			br = null;
			gson = null;
		}
	}

	@Override
	public String insertSequence(BusStorageBean bean) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = ResourcesUtil.getValue("config", "busurl");

			// 请求地址
			String imgUrl = url + "/storage/catch";

			Map<String, String> params = new HashMap<String, String>();
			params.put("busId", bean.getBusId());
			params.put("busSequence", bean.getBusSequence());
			params.put("createUser", bean.getCreateUser());
			params.put("outOrderNo",bean.getOutOrderNo());
			
			String json = gson.toJson(params);
			System.out.println(imgUrl+json);
			String result =HttpXmlClient.post(imgUrl, params);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();

			br.setInfo("未知错误异常");
			br.setReturnCode(500);
			return gson.toJson(br);
		} finally {
			br = null;
			gson = null;
		}
	}

	@Override
	public String insertAppVersion(AppVersionBean bean) {
		Gson gson = new Gson();
		try {
			
			String url = ResourcesUtil.getValue("config", "dmsurl");
			
			//请求地址
			String dmsUrl = url + "baseInfo";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("omsMasterId", bean.getOmsMasterId());
			params.put("androidVersionNo", bean.getAndroidVersionNo());
			params.put("appVersionNo", bean.getAppVersionNo());
			params.put("phoneModel", bean.getPhoneModel());
			params.put("masterPhone", bean.getMasterPhone());
			params.put("phoneImei", bean.getPhoneImei());
			params.put("creator", bean.getCreator());
			params.put("modifier", bean.getModifier());
			String data = gson.toJson(params);
			logger.info("请求参数：" + data);
			String method = "saveAppVersion";
			
			Map<String, String> par = new HashMap<>();
			par.put("method", method);
			par.put("data", data);
			
			
			String result = HttpXmlClient.post(dmsUrl, par);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
			return gson.toJson(br);			
		}
	}
	
	public String getPrivacyNumber(String workOrderId){
		Gson gson = new Gson();
		try {
			
			String url = ResourcesUtil.getValue("config", "dmsurl");
			
			//请求地址
			String dispatchUrl = url + "httpServices/MDMSHttpService";
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("workorderid", workOrderId);			
			
			String data = gson.toJson(params);
			logger.info("请求参数：" + data);
			String method = "getPrivacyNumber";
			
			Map<String, String> par = new HashMap<>();
			par.put("method", method);
			par.put("data", data);
			
			String result = HttpXmlClient.post(dispatchUrl, par);
			logger.info("返回结果：" + result);
			return result;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
			return gson.toJson(br);
		}
	}
	
}

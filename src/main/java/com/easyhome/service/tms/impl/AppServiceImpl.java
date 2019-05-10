package com.easyhome.service.tms.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.service.tms.AppServiceI;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.Util;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

/**
 * 
 * <p>title: AppServiceImpl</p>
 * <p>description: APP服务接口实现</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年7月27日 下午5:38:33
 */
@Service("appService")
public class AppServiceImpl implements AppServiceI{

	@Override
	public String workOrderList(int status, String workId, int pageSize, int currentPage) throws Exception {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/findOrderList";
			Map<String, String> params = new HashMap<String, String>();
			params.put("status", status+"");
			params.put("workId", workId);
			params.put("pageSize", pageSize+"");
			params.put("currentPage", currentPage+"");
			String post = HttpXmlClient.post(url, params);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

	@Override
	public String getWorkOrderDetail(String workOrderId, String workOrderOwnnerId) throws Exception {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/getWorkOrderDetail";
			Map<String, String> params = new HashMap<String, String>();
			params.put("workOrderId", workOrderId);
			params.put("workOrderOwnnerId", workOrderOwnnerId);
			String post = HttpXmlClient.post(url, params,HttpXmlClient.APPLICATION_JSON);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

	@Override
	public String saveBooking(String workId,
			String omsMasterId, String workorderid, String linkman, String address, String phone,
			int status, String reason, String date, String call) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/booking";
			Map<String, String> params = new HashMap<String, String>();
			params.put("workId",workId);
			params.put("omsMasterId", omsMasterId);
			params.put("workorderid", workorderid);
			params.put("linkman",linkman);
			params.put("address",address);
			params.put("phone",phone);
			params.put("status",status+"");
			params.put("reason",reason);
			params.put("date",date);
			params.put("call",call);
			String post = HttpXmlClient.post(url, params);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

	@Override
	public String saveSign(String workId,String omsMasterId, String workorderid, String signerid, String signer, String type,
			String lat, String lng, String code, String address, String phone) throws Exception {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/sign";
			Map<String, String> params = new HashMap<String, String>();
			params.put("workId",workId);
			params.put("omsMasterId",omsMasterId);
			params.put("workorderid", workorderid);
			params.put("signerid",signerid);
			params.put("signer",signer);
			params.put("type",type);
			params.put("lat",lat);
			params.put("lng",lng);
			params.put("code",code);
			params.put("address",address);
			String post = HttpXmlClient.post(url, params);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

	@Override
	public String saveCompelete(String data, String workId, String workorderid) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/compelete";
			Map<String, String> params = new HashMap<String, String>();
			params.put("workId",workId);
			params.put("workorderid", workorderid);
			params.put("data",data);
			String post = HttpXmlClient.post(url, params,HttpXmlClient.APPLICATION_JSON);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

	@Override
	public String searchWorkOrder(String searchWords, String omsMasterId,String workId, Integer pageIndex, Integer pagesize)
			throws Exception {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String url = Util.getProperty("tmsurl")+"/app/searchWorkOrder";
			Map<String, String> params = new HashMap<String, String>();
			params.put("searchWords",searchWords);
			params.put("omsMasterId", omsMasterId);
			params.put("pageIndex",pageIndex+"");
			params.put("pagesize",pagesize+"");
			params.put("workId", workId);
			String post = HttpXmlClient.post(url, params,HttpXmlClient.APPLICATION_JSON);
			return post;
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
		}
		return gson.toJson(br);
	}

}

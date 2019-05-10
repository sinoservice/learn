package com.easyhome.service.oms.impl;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.easyhome.po.Appraise;
import com.easyhome.po.oms.AppRankingListRequestEntity;
import com.easyhome.service.oms.OmsWorkOrderService;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.OmsConnectUtil;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.OrderResult;
import com.easyhome.vo.dms.VisitResponseData;
import com.easyhome.vo.dms.VisitResponseParse;
import com.google.gson.Gson;

/**
 * 
 * <p> Title: OmsWorkOrderServiceImpl</p>
 * <p> Description: oms服务实现类</p>
 * 
 * @date 2016年6月24日 下午2:06:22
 * @version 1.0
 *
 */
@Service("omsWorkOrderService")
public class OmsWorkOrderServiceImpl implements OmsWorkOrderService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsWorkOrderServiceImpl.class);

	/**
	 * 排行榜
	 */
	@Override
	public String findOmsRankingList(AppRankingListRequestEntity request) {
		Gson gson = new Gson();
		try {
			String data = OmsConnectUtil.getData("appGetEmployeeMedal", gson.toJson(request));
			data = data.replace("errCode", "returnCode").replace("errMsg", "info");
			return data;
		} catch (Exception e) {
			BaseResponse br = new BaseResponse();
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}

	@Override
	public BaseResponse addMessage(String workorderid, String address) {
		BaseResponse response = new BaseResponse();
		try {
			Appraise appraise = new Appraise();
			appraise.setWorkorderid(workorderid);
			appraise.setAddress(address);
			appraise.setTime(new Date());
			response.setData(appraise);
			response.setReturnCode(ReturnCode.STATUS_201);
			response.setInfo(ReturnCode.OK);
		} catch (Exception e) {
			response.setReturnCode(ReturnCode.STATUS_500);
			response.setInfo("亲，您查询的页面不见了，请稍后重试！");
		}
		return response;
	}

	@Override
	public String saveAppraise(
			String workOrderId, 
			int evalServiceComplete, 
			int evalPhoneBack, 
			int satisfaction1,
			int satisfaction2, 
			int satisfaction3, 
			String customerEval) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			
			//设置参数
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("workOrderId", workOrderId);
			data.put("evalServiceComplete", evalServiceComplete);
			data.put("evalPhoneBack", evalPhoneBack);
			data.put("satisfaction1", satisfaction1);
			data.put("satisfaction2", satisfaction2);
			data.put("satisfaction3", satisfaction3);
			data.put("customerEval", customerEval);
			
			//判断工单是否处于可评价状态
			String url = ResourcesUtil.getValue("config", "dmsurl");
			
			//工单评价查询地址
			String dmsurl = url + "dispatch";
			
			Map<String, String> paramsData = new HashMap<>();
			paramsData.put("dispatchNo", workOrderId);
			
			String visitQueryData = gson.toJson(paramsData);
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "findVisitResult");
			params.put("data", visitQueryData);
			String queryResult = HttpXmlClient.post(dmsurl, params);
			
			VisitResponseParse visitResponseParse = gson.fromJson(queryResult, VisitResponseParse.class);
			
			if(visitResponseParse!=null)
			{
				int returnCode = visitResponseParse.getReturnCode();
				VisitResponseData responseData = visitResponseParse.getData();
				
				//回访不存在
				if(returnCode == 200 && responseData == null){
					//请求网络，完成评价操作
					String data2 = OmsConnectUtil.getData("appRecVisitResult", data);
					logger.info(data2);
					
					return "appraise/success";
				}
				
				else
				{
					return "appraise/fail";
				}
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			br.setReturnCode(500);
			br.setInfo("请求失败");
			br.setData("FAIL");
			logger.info("服务端异常：",e);
		}
		
		return "appraise/fail";
	}

	@Override
	public String findAppraiseResult(String workOrderId) {
		
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		
		try {
			//判断工单是否处于可评价状态
			String url = ResourcesUtil.getValue("config", "dmsurl");
			
			//工单评价查询地址
			String dmsurl = url + "dispatch";
			
			Map<String, String> paramsData = new HashMap<>();
			paramsData.put("dispatchNo", workOrderId);
			
			String visitQueryData = gson.toJson(paramsData);
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("method", "findVisitResult");
			params.put("data", visitQueryData);
			String queryResult = HttpXmlClient.post(dmsurl, params);
			
			VisitResponseParse visitResponseParse = gson.fromJson(queryResult, VisitResponseParse.class);
			
			if(visitResponseParse!=null)
			{
				int returnCode = visitResponseParse.getReturnCode();
				VisitResponseData responseData = visitResponseParse.getData();
				
				//回访不存在
				if(returnCode == 200 && responseData == null){
					//请求网络，完成评价操作
					return "appraise/save";
				}
				
				else
				{
					return "appraise/fail";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "appraise/save";
	}

}

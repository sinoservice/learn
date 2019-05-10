package com.easyhome.service.wechat.service.impl;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.easyhome.po.wechat.EvaluationRequestBean;
import com.easyhome.po.wechat.OrderDetailListRequestBean;
import com.easyhome.po.wechat.OrderListRequestBean;
import com.easyhome.po.wechat.PushRecordListRequestBean;
import com.easyhome.po.wechat.UserBean;
import com.easyhome.po.wechat.WeChatAppointmentBean;
import com.easyhome.service.wechat.service.DmsWeChatService;
import com.easyhome.service.wechat.utils.AccessToken;
import com.easyhome.service.wechat.utils.ConstantsWeChat;
import com.easyhome.service.wechat.utils.HttpTool;
import com.easyhome.utils.AliyunSMS;
import com.easyhome.utils.EmptyUtils;
import com.easyhome.utils.HttpXmlClient;
import com.easyhome.utils.ResourcesUtil;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.wechat.WeChatResponse;
import com.google.gson.Gson;

@Service
public class DmsWeChatServiceImpl implements DmsWeChatService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DmsWeChatServiceImpl.class);


	@Override
	public WeChatResponse weChatbinding(UserBean bean,HttpServletRequest request) {
		Gson gson = new Gson();
		WeChatResponse response = new WeChatResponse();
		try {
			//先判断验证码是否一致
			String verificationCodeByPhone = bean.getVerificationCode();
			HttpSession session = request.getSession();
			if(session.getAttribute("code")==null){
				response.setPhone(bean.getPhone());
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("验证码过期！");
			}else if (EmptyUtils.isEmpty(verificationCodeByPhone)){
				response.setPhone(bean.getPhone());
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("验证码为空！");
			}else if (EmptyUtils.isEmpty(bean.getPhone())){
				response.setPhone(bean.getPhone());
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("手机号为空！");
			}else if (EmptyUtils.isEmpty(bean.getOpenId())){
				response.setPhone(bean.getPhone());
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("openId参数为空！");
			} else{
				int verificationCodeBySession = (int) session.getAttribute("code");
				String verificationCodeBySessionChange = verificationCodeBySession+"";
				String sessionPhone = (String) session.getAttribute("phone");
				if(EmptyUtils.isEmpty(sessionPhone)){
					response.setPhone(bean.getPhone());
					response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
					response.setMessage("验证码错误！");
					return response;
				}
				if(!sessionPhone.equals(bean.getPhone())){
					response.setPhone(bean.getPhone());
					response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
					response.setMessage("您输入的手机号与发送验证码时的手机号不一致！");
					return response;
				}
				if(EmptyUtils.isNotEmpty(verificationCodeByPhone)&&
						verificationCodeBySessionChange.equals(verificationCodeByPhone)){
					// 获取参数
					String url = ResourcesUtil.getValue("config", "dmsurl");
					url = url + "httpServices/dmsWeChatHttpServlet";
					Map<String, String> params = new HashMap<>();
					params.put("phone", bean.getPhone());
					params.put("openId", bean.getOpenId());
					String data = gson.toJson(params);
					Map<String, String> par = new HashMap<>();
					par.put("methodName", "weChatbinding");
					par.put("data", data);
					String post = HttpXmlClient.post(url, par);
					// response赋值
					response = gson.fromJson(post, WeChatResponse.class);
					logger.info(post);
				}else{
					response.setPhone(bean.getPhone());
					response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
					response.setMessage("验证码错误！");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	@Override
	public WeChatResponse sendPhoneMsg(String phone,HttpServletRequest request) {
		WeChatResponse response = new WeChatResponse();
		try {
			// 生成6位数验证码
			int code = (int) ((Math.random() * 9 + 1) * 100000);
			HttpSession session = request.getSession();
			String msg = AliyunSMS.sendMsgToPhone(phone, "SMS_139234592", code+"");
			if("OK".equals(msg)){
				session.setAttribute("code", code);
				session.setAttribute("phone", phone);
				response.setMsgCode(ReturnCode.WECHAT_RESULT_SUCCESS);
				response.setMessage("发送验证码成功");
				response.setData(code+"");
				logger.info("验证码："+phone+":"+code);
			}else{
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("发送验证码过于频繁稍后再试！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public WeChatResponse weChatLogin(UserBean bean,HttpServletRequest request,HttpServletResponse httpResponse) {
		Gson gson = new Gson();
		WeChatResponse response = new WeChatResponse();
		try {
			Map<String,Object> returnMap = getOpenId(request);
			boolean isSuccess = (boolean) returnMap.get("status");
			if(!isSuccess){
				response.setPhone(bean.getPhone());
				response.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				response.setMessage("获取openId出错，授权登录失败,请稍后再试!");
				response.setData(bean);
				httpResponse.sendRedirect("http://www.jrdaojia.com/www/index.html");
			}else{
				String openId = (String) returnMap.get("openId");
				bean.setOpenId(openId);
				// 获取参数
				String url = ResourcesUtil.getValue("config", "dmsurl");
				url = url + "httpServices/dmsWeChatHttpServlet";
				Map<String, String> params = new HashMap<>();
				params.put("phone", bean.getPhone());
				params.put("openId", bean.getOpenId());
				String data = gson.toJson(params);
				Map<String, String> par = new HashMap<>();
				par.put("methodName", "weChatLogin");
				par.put("data", data);
				String post = HttpXmlClient.post(url, par);
				response = gson.fromJson(post, WeChatResponse.class);
				response.setOpenId(openId);
				if(ReturnCode.WECHAT_RESULT_FAILURE == response.getMsgCode()){
					httpResponse.sendRedirect("http://www.jrdaojia.com/www/index.html?openId="+openId);
				}
				logger.info(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	/**
	 * 
	 * @author: Irving
	 * @date: 2018-7-10
	 * @description:获取openId
	 * @param
	 */
	private Map<String,Object> getOpenId(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		Object existOpenId = request.getSession().getAttribute("openId");
		// openId不存在，就重新去获取openId
		if (existOpenId == null) {
			if(request.getParameter("code")==null){
				map.put("status", false);
				map.put("msg", "code为空获取用户信息失败");
			}else{
				String httpGet = httpGetOpenId(request.getParameter("code"));
				JSONObject oauthGetOpenId = JSONObject.fromObject(httpGet);
				if (oauthGetOpenId.containsKey("openid")) {
					String openId = oauthGetOpenId.getString("openid");
					map.put("status", true);
					map.put("openId", openId);
				}else{
					map.put("status", false);
					map.put("msg", "获取openId请求失败"+httpGet);
				}
			}
		} else {
			// 直接从session获取
			map.put("status", true);
			map.put("openId", request.getSession().getAttribute("openId"));
		}
		return map;
	}

	/**
	 * 
	 * @author: Irving
	 * @date: 2018-7-11
	 * @description:请求微信的openId
	 * @param
	 */
	private String httpGetOpenId(String code) {

		AccessToken.getAccessToken();
		// 1、根据code到微信请求openid
		String httpsGet = String.format(ConstantsWeChat.GET_OPEN_ID,ConstantsWeChat.APPID,ConstantsWeChat.SECERT, code);
		// 2.发起请求获取用户openid
		String httpGet = HttpTool.httpGet(httpsGet);
		if (EmptyUtils.isEmpty(httpGet)) {
			return "";
		}
		return httpGet;
	}


	/**
	 * 预约上门
	 */
	@Override
	public WeChatResponse weChatAppointment(WeChatAppointmentBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("openId", bean.getOpenId());
			params.put("externalOrderNo", bean.getExternalOrderNo());
			params.put("appointTime", bean.getAppointTime());
			params.put("periodOfAppoint", bean.getPeriodOfAppoint());
			params.put("taskNo", bean.getTaskNo());
			params.put("remark", bean.getRemark());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "weChatAppointment");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}
	
	@Override
	public WeChatResponse weChatEvaluation(EvaluationRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("openId", bean.getOpenId());
			params.put("dispatchNo", bean.getDispatchNo());
			params.put("customerEval", bean.getCustomerEval());
			params.put("dissatisfactionReason", bean.getDissatisfactionReason());
			params.put("customerEvalRemark", bean.getCustomerEvalRemark());
			params.put("image", bean.getImage());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "weChatEvaluation");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}


	@Override
	public WeChatResponse orderQuery(OrderListRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("orderListType", bean.getOrderListType());
			params.put("openId", bean.getOpenId());
			params.put("externalOrderNo", bean.getExternalOrderNo());
//			params.put("goodsName", bean.getGoodsName());
			params.put("pageIndex", bean.getPageIndex());
			params.put("pageSize", bean.getPageSize());
			String data = gson.toJson(params);
			params = new HashMap<>();
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "orderQuery");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}

	
	@Override
	public WeChatResponse orderQueryDetails(OrderDetailListRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("taskNo", bean.getTaskNo());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "orderQueryDetails");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}

	@Override
	public WeChatResponse orderQueryDetailsPhsu(OrderDetailListRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("taskNo", bean.getTaskNo());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "orderQueryDetailsPhsu");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}

	@Override
	public WeChatResponse rderQueryNode(OrderDetailListRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("taskNo", bean.getTaskNo());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "logisticsNode");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}


	@Override
	public WeChatResponse pushRecord(PushRecordListRequestBean bean,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("openId", bean.getOpenId());
			params.put("orderType", bean.getOrderType());
			params.put("pageIndex", bean.getPageIndex());
			params.put("pageSize", bean.getPageSize());
			String data = gson.toJson(params);
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "pushRecordList");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}


	@Override
	public WeChatResponse weChatUrlResponse(String responseUrl,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatresponse = new WeChatResponse();
		try {
			Map<String,Object> returnMap = getOpenId(request);
			boolean isSuccess = (boolean) returnMap.get("status");
			if(!isSuccess){
				weChatresponse.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
				weChatresponse.setMessage("获取openId出错，授权登录失败,联系运维人员！");
				response.sendRedirect("http://www.jrdaojia.com/www/index.html");//跳转到登录绑定界面
			}else{
				UserBean bean = new UserBean();
				String openId = (String) returnMap.get("openId");
				bean.setOpenId(openId);
				// 获取参数
				String url = ResourcesUtil.getValue("config", "dmsurl");
				url = url + "httpServices/dmsWeChatHttpServlet";
				Map<String, String> params = new HashMap<>();
				params.put("phone", bean.getPhone());
				params.put("openId", bean.getOpenId());
				String data = gson.toJson(params);
				Map<String, String> par = new HashMap<>();
				par.put("methodName", "weChatLogin");
				par.put("data", data);
				String post = HttpXmlClient.post(url, par);
				weChatresponse = gson.fromJson(post, WeChatResponse.class);
				weChatresponse.setOpenId(openId);
				String addUrl = "?openId="+openId;
				if(ReturnCode.WECHAT_RESULT_FAILURE == weChatresponse.getMsgCode()){
					if("myOrder".equals(responseUrl)){
						responseUrl = "MyOrderListPage";
					}else if("myPush".equals(responseUrl)){
						responseUrl = "PushRecordPage";
					}
					String directUrl = "?openId="+openId+"sendRedirect"+responseUrl;
					responseUrl = "http://www.jrdaojia.com/www/index.html"+directUrl;//跳转到登录绑定界面
					response.sendRedirect(responseUrl);
				}else{
					if("myOrder".equals(responseUrl)){//我的订单界面
						responseUrl = "http://www.jrdaojia.com/www/#/my-order-list"+addUrl;
					}else if("myPush".equals(responseUrl)){
						responseUrl = "http://www.jrdaojia.com/www/#/push-record"+addUrl;//跳转到推送界面
					}else if("".equals(responseUrl)){
						responseUrl = "http://www.jrdaojia.com/www/index.html"+addUrl;//跳转到待定界面
					}else{
						responseUrl = "http://www.jrdaojia.com/www/index.html"+addUrl;//跳转到登录绑定界面
					}
					response.sendRedirect(responseUrl);
				}
				logger.info(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatresponse;
	}


	@Override
	public WeChatResponse weChatGetOpenId(HttpServletRequest request,
			HttpServletResponse response) {
		WeChatResponse weChatresponse = new WeChatResponse();
		Map<String, Object> returnMap = getOpenId(request);
		boolean isSuccess = (boolean) returnMap.get("status");
		if(!isSuccess){
			weChatresponse.setMsgCode(ReturnCode.WECHAT_RESULT_FAILURE);
			weChatresponse.setMessage("获取openId出错,联系运维人员！");
		}else{
			UserBean bean = new UserBean();
			String openId = (String) returnMap.get("openId");
			bean.setOpenId(openId);
			weChatresponse.setMsgCode(ReturnCode.WECHAT_RESULT_SUCCESS);
			weChatresponse.setMessage("获取openId成功");
			weChatresponse.setData(bean);
		}
		return weChatresponse;
	}


	@Override
	public WeChatResponse weChatToken(HttpServletRequest request,
			HttpServletResponse response) {
		WeChatResponse weChatresponse = new WeChatResponse();
		weChatresponse.setOpenId(AccessToken.getAccessToken());
		return weChatresponse;
	}


	@Override
	public WeChatResponse pushWeChatUrlResponse(String taskNo,String typeUrl,
			HttpServletRequest request, HttpServletResponse response) {
		Gson gson = new Gson();
		WeChatResponse weChatResponse = new WeChatResponse();
		try {
			// 获取参数
			String url = ResourcesUtil.getValue("config", "dmsurl");
			url = url + "httpServices/dmsWeChatHttpServlet";
			Map<String, String> params = new HashMap<>();
			params.put("taskNo", taskNo);
			params.put("typeUrl", typeUrl);
			String data = gson.toJson(params);
			params = new HashMap<>();
			Map<String, String> par = new HashMap<>();
			par.put("methodName", "pushWeChatUrlResponse");
			par.put("data", data);
			String post = HttpXmlClient.post(url, par);
			// response赋值
			weChatResponse = gson.fromJson(post, WeChatResponse.class);
			String responseUrl = "";
			if(ReturnCode.WECHAT_RESULT_FAILURE == weChatResponse.getMsgCode()){
				responseUrl = "http://www.jrdaojia.com/www/#/my-order-details/"+taskNo;
				response.sendRedirect(responseUrl);
			}else{
				if("reservation".equals(typeUrl)){//预约
					responseUrl = "http://www.jrdaojia.com/www/#/customer-reservation/"+taskNo;
				}
				if("reviews".equals(typeUrl)){//评价
					responseUrl = "http://www.jrdaojia.com/www/#/customer-reviews/"+weChatResponse.getMessage();
				}
				response.sendRedirect(responseUrl);
			}
			logger.info(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weChatResponse;
	}
}

package com.easyhome.service.wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyhome.po.wechat.EvaluationRequestBean;
import com.easyhome.po.wechat.OrderDetailListRequestBean;
import com.easyhome.po.wechat.OrderListRequestBean;
import com.easyhome.po.wechat.PushRecordListRequestBean;
import com.easyhome.po.wechat.UserBean;
import com.easyhome.po.wechat.WeChatAppointmentBean;
import com.easyhome.vo.wechat.WeChatResponse;

public interface DmsWeChatService {
	
	WeChatResponse weChatbinding(UserBean bean,HttpServletRequest request);
	
	WeChatResponse sendPhoneMsg(String phone,HttpServletRequest request);
	
	WeChatResponse weChatLogin(UserBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse weChatAppointment(WeChatAppointmentBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse weChatEvaluation(EvaluationRequestBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse orderQuery(OrderListRequestBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse orderQueryDetails(OrderDetailListRequestBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse rderQueryNode(OrderDetailListRequestBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse pushRecord(PushRecordListRequestBean bean,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse pushWeChatUrlResponse(String taskNo,String typeUrl,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse weChatUrlResponse(String responseUrl,HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse orderQueryDetailsPhsu(OrderDetailListRequestBean bean,HttpServletRequest request, HttpServletResponse response);
	
	WeChatResponse weChatGetOpenId(HttpServletRequest request,HttpServletResponse response);
	
	WeChatResponse weChatToken(HttpServletRequest request,HttpServletResponse response);
}

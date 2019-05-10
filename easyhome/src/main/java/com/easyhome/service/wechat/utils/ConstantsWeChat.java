package com.easyhome.service.wechat.utils;

/**
 * 
 * @author: Winston
 * @date: 2018-5-4
 * @description:常量类
 */
public  class ConstantsWeChat {

	/**
	 * 微信相关 上线时需要修改地方
	 */
	//appid  上线时需要修改地方
	public final static String APPID = "wx0afe7dd98ee8ad4e";
	//秘钥 上线时需要修改地方
	public final static String SECERT="cddb0497cc4d2aaba43b9580403ffa50";
	
	
	/*public final static String APPID = "wxf002f27110ef6c63";
	public final static String SECERT="9529ace514dcb9c2e9bb3a00c0f0a7f3";*/
		
		
	public final static String TOKEN="sin0services";
	//服务器地址 上线时需要修改地方
	public final static String HOSTURL="http://59.60.9.8";
	
	//项目的虚拟路径，主要用于访问项目的的其他servlet 
	public final static String VIRTUAL_PATH="/TMS_DEV";
	//服务器路径
	public final static String URLPATH="/TMS_DEV/TMSWxServlet";
	//登录界面跳转的url
	public  final static String LOGIN_URL = HOSTURL+"/SinotransWechart/#/Login";
	//登录成功跳转的url
	public  final static String INDEX_URL = HOSTURL+"/SinotransWechart/#/";
	//模版消息跳转的url
	public  final static String TEMPLATE_URL = HOSTURL+"/SinotransWechart/#/Letter";
	//请求ACCENTTOKEN
	public final static String ACCENTTOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	//请求微信登录路径
	public final static  String REDIRECT_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APPID+"&redirect_uri="+HOSTURL+URLPATH+"?beanName=appWxLoginManager&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
	//获取openId
	public final static  String GET_OPEN_ID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
	//获取jsAPI
	public final static String JSPTICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
	//模板Id
	public final static String TEMPID="f_UQ0lrnYUY-WCgs6jcmWjD8H0etymHsQeT63U9igIw";
}

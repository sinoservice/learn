package com.easyhome.utils;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * 
 * <p> Title: OmsConnectUtil</p>
 * <p> Description: Oms对接工具类</p>
 * <p> 依赖: HttpXmlClient</p>
 * 
 * @date 2016年6月27日 下午3:11:55
 * @version 1.0
 *
 */
public class OmsConnectUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsConnectUtil.class);

	/**
	 * 请求地址
	 */
	public static String URL = "APPSERVER/module-dms/httpServices/MDMSHttpService";
	
	/**
	 * 
	 * <p> Description: 调用oms接口获取数据</p>
	 * 
	 * @date 2016年6月27日 下午3:14:16
	 * @version 1.0
	 * @param methodName   方法名称
	 * @param requestJson  参数，必须是json格式
	 * @return
	 * @throws Exception 
	 */
	public static String getData(String methodName,String requestJson) throws Exception{
		//1.获取服务器地址
		String ipAndPort = Util.getProperty("ipAndPort");
		String url = URL.replace("APPSERVER", ipAndPort);	
		logger.info("调用接口路径："+url);
		try {
			//2.设置请求参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("methodName", methodName);
			params.put("data", requestJson);
			String post = HttpXmlClient.post(url, params);
			return post;
		} catch (Exception e) {
			//throw new Exception("获取数据失败");
		}
		return null;
	}
	
	/**
	 * 
	 * <p> Description: 调用oms接口获取数据</p>
	 * 
	 * @date 2016年6月28日 下午2:02:10
	 * @version 1.0
	 * @param methodName  方法名
	 * @param params      参数
	 * @return
	 */
	public static String getData(String methodName,Map<String, Object> params){
		//1.获取服务器地址
		String ipAndPort = Util.getProperty("ipAndPort");
		String url = URL.replace("APPSERVER", ipAndPort);
		
		//设置map转json
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info("请求参数："+json);
		//请求数据
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("methodName", methodName);
			map.put("data", json);
			String post = HttpXmlClient.post(url, map);
			return post;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
	
	public static void getResponseData(String methodName,String requestJson,HttpServletResponse response) throws Exception{
		//1.获取服务器地址
		String ipAndPort = Util.getProperty("ipAndPort");
		String url = URL.replace("APPSERVER", ipAndPort);	
		logger.info("调用接口路径："+url);
		try {
			//2.设置请求参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("methodName", methodName);
			params.put("data", requestJson);
			HttpXmlClient.sendPost(url, params,response);
		} catch (Exception e) {
			//throw new Exception("获取数据失败");
		}
	}
	
}

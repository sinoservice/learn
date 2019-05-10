package com.easyhome.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.google.gson.Gson;

/**
 * 
 * @ClassName: TmsConnectUtil
 * @Description: TODO tms联调请求工具类
 * @date 2016年11月25日 上午11:19:51
 *
 */
public class TmsConnectUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OmsConnectUtil.class);

	/**
	 * 请求地址
	 */
	public static String URL = "TMSAPP/module-tms/httpServices/eajAppHttpService";

	public static final String TMS_APP_URL = "tmsAppUrl";

	/**
	 * 
	 * @Title: getData
	 * @Description: TODO 调用tms接口获取数据
	 * @param methodName
	 * @param requestJson
	 * @throws Exception
	 * @return String
	 * @throws 
	 * @date 2016年11月25日 上午11:21:12
	 */
	public static String getData(String methodName, String requestJson) throws Exception {

		// 1.获取服务器地址
		String tmsAppUrl = Util.getProperty(TMS_APP_URL);
		String url = URL.replace("TMSAPP", tmsAppUrl);
		logger.info("调用接口路径：" + url);
		try {

			// 2.设置请求参数
			Map<String, String> params = new HashMap<String, String>();
			params.put("methodName", methodName);
			params.put("data", requestJson);
			String post = HttpXmlClient.post(url, params);
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取数据失败");
		}
		return null;
	}

	/**
	 * 
	 * @Title: getData
	 * @Description: TODO 调用tms接口获取数据
	 * @param @param
	 *            methodName
	 * @param @param
	 *            params
	 * @param @return
	 * @return String
	 * @date 2016年11月25日 上午11:29:03
	 */
	public static String getData(String methodName, Map<String, Object> params) {
		// 1.获取服务器地址
		String tmsAppUrl = Util.getProperty(TMS_APP_URL);
		String url = URL.replace("TMSAPP", tmsAppUrl);

		// 2.设置map转json
		Gson gson = new Gson();
		String json = gson.toJson(params);
		logger.info("请求参数：" + json);

		// 3.请求数据
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("methodName", methodName);
			map.put("data", json);
			String post = HttpXmlClient.post(url, map);
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取数据失败！");
		}
		return "";
	}

}
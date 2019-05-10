package com.easyhome.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * 
 * <p>
 * 标题: HttpClientUtil
 * </p>
 * <p>
 * 描述: HttpClient工具类
 * </p>
 * <p>
 * 公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a>
 * </p>
 * <p>
 * 创建时间: 2016年9月1日 下午1:48:06
 * </p>
 * <p>
 * 修改时间: TODO
 * </p>
 * <p>
 * 版本: TODO
 * </p>
 */
public class HttpClientUtil {

	public static final String APPLICATION_JSON = "application/json;charset=UTF-8";

	/**
	 * 
	 * <p>
	 * description: post请求http/https
	 * </p>
	 * 
	 * @param url
	 *            路径
	 * @param json
	 *            json格式参数参数
	 * @return
	 * @throws IOException
	 * @date 2016年9月1日 下午3:15:44
	 */
	public static String postJson(String url, String json) throws IOException {

		// 实例声明
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		StringEntity se = null;
		HttpResponse hr = null;
		InputStream is = null;

		try {

			httpClient = HttpClients.createDefault();

			// 创建httppost
			httpPost = new HttpPost(url);

			// 设置请求头
			httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);

			// 设置请求参数
			se = new StringEntity(json, "UTF-8");
			se.setContentType("text/json");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
			httpPost.setEntity(se);

			hr = httpClient.execute(httpPost);
			StatusLine sl = hr.getStatusLine();
			if (sl.getStatusCode() == 200) {

				// 拿到响应头的实体
				HttpEntity he = hr.getEntity();

				// 拿到实体中的内容，其实就是服务器返回的输入流
				is = he.getContent();

				return StreamUtils.getTextFromStream(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 关闭流

			if (httpClient != null) {
				httpClient.close();
			}

			if (is != null) {
				is.close();
			}

			httpPost = null;
			se = null;
			hr = null;
		}

		return null;
	}

	/**
	 * 
	 * <p>
	 * description: get方式请求数据
	 * </p>
	 * 
	 * @param url
	 * @return
	 * @date 2016年9月1日 下午3:45:54
	 */
	public static String get(String url) {

		// 实例声明
		CloseableHttpClient httpClient = null;
		HttpGet httpGet = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String content = null;

		try {

			// 初始化
			httpClient = HttpClients.createDefault();
			httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet);

			// 获取返回状态行
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == 200) {

				// 获取结果信息
				entity = response.getEntity();
				content = EntityUtils.toString(entity, "utf-8");
				return content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			httpGet = null;
			response = null;
			entity = null;
			content = null;

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * description: get方式请求数据
	 * </p>
	 * 
	 * @param url
	 * @return
	 * @date 2016年9月1日 下午3:45:54
	 */
	public static String post(String url) {

		// 实例声明
		CloseableHttpClient httpClient = null;
		HttpPost httpPost = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String content = null;

		try {

			// 初始化
			httpClient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			response = httpClient.execute(httpPost);

			// 获取返回状态行
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == 200) {

				// 获取结果信息
				entity = response.getEntity();
				content = EntityUtils.toString(entity, "utf-8");
				return content;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (httpClient != null) {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			httpPost = null;
			response = null;
			entity = null;
			content = null;

		}

		return null;

	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            链接地址
	 * @param charset
	 *            字符编码，若为null则默认utf-8
	 * @return
	 */
	public static String doGet(String url, String charset) {
		if (null == charset) {
			charset = "utf-8";
		}
		HttpClient httpClient = null;
		HttpGet httpGet = null;
		String result = null;

		try {
			httpClient = HttpClients.createDefault();
			httpGet = new HttpGet(url);

			HttpResponse response = httpClient.execute(httpGet);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}

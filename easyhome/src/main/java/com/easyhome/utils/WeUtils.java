package com.easyhome.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * 工具类
 * 
 * @date 2016年5月30日 下午5:31:43
 */
public class WeUtils {

	/**
	 * 发送get请求，并返回数据
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	  public static String getRequest(String url) throws IOException{
		  String result="";
		  URL u = new URL(url);
		  //打开和URL之间的链接
		  HttpURLConnection conn =(HttpURLConnection) u.openConnection();
		  //读取链接
     		result =  IOUtils.toString(conn.getInputStream(),"UTF-8");
     		return result;
	  }

	/**
	 * 发送post请求
	 * @throws IOException 
	 * 
	 * @throws IOException
	 */
	  public static String postRequest(String url,String message) throws IOException{
		  URL u = new URL(url);
		  //打开和URL之间的链接
		  HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		  //设置关键值
		  conn.setRequestMethod("POST");//以post方式提交表单，默认是get
		  conn.setDoInput(true);//设置是否从httpUrlConnection读入，默认是true
		  conn.setDoOutput(true);//设置是否项httpUrlConnection输入，默认为false
		  conn.setRequestProperty("Content-Type", "application/json");//设置发送请求的格式
		  //发送请求获取回传的参数
		  OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
		  osw.write(message);
		  osw.flush();
		  osw.close();
		  conn.getOutputStream();
		  return IOUtils.toString(conn.getInputStream());
	  }
	

	/**
	 * mdt 摘要算法
	 * 
	 * @param src
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String src) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = src.getBytes();
		byte[] output = md.digest(input);//digest:消化吸收
		// 采用base64将output转换成字符串
		String dest = Base64.encodeBase64String(output);
		return dest;
	}

	public static void main(String[] args) {
		try {
			System.out.println(md5("123"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}

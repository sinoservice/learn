package com.easyhome.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PropertyUtil.class);
	
	
	/**
	 * 
	 * <p>description: TODO</p>
	 * @param path 文件路径
	 * @param propertyName 属性名称
	 * @return
	 * @date 2016年8月12日 下午5:39:23
	 */
	public static String getProperty(String path,String propertyName){
		String propertyValue = "";
		Properties props = new Properties();
		InputStream in;
		in = Util.class.getResourceAsStream(path);
		try {
			props.load(in);
		} catch (IOException e) {
			logger.error("获取配置数据异常",e);
		}
		if (!props.isEmpty()) {
			propertyValue = props.getProperty(propertyName).toString();
		}
		return propertyValue;
	}
	
	

	/**
	 * 
	 * <p>description: TODO</p>
	 * @param propertyName 属性名称
	 * @return
	 * @date 2016年8月12日 下午5:39:54
	 */
	public static String getProperty(String propertyName){
		String propertyValue = "";
		Properties props = new Properties();
		InputStream in;
		in = Util.class.getResourceAsStream("/config.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			logger.error("获取配置数据异常",e);
		}
		if (!props.isEmpty()) {
			propertyValue = props.getProperty(propertyName).toString();
		}
		return propertyValue;
	}
}

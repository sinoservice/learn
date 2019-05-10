package com.easyhome.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Util {

	private static Log log = LogFactory.getLog(Util.class);
	
	public static boolean isEmpty(String... params) {
		for (String p : params) {
			if(isEmpty(p)){
				return true;
			}
		}
		return false;
	}

	private static boolean isEmpty(String params) {
		if (params == null || params.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static String getProperty(String propertyName){
		String propertyValue = "";
		Properties props = new Properties();
		InputStream in;
		in = Util.class.getResourceAsStream("/config.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			log.error("获取配置数据异常",e);
		}
		if (!props.isEmpty()) {
			propertyValue = props.getProperty(propertyName).toString();
		}
		return propertyValue;
	}
	//判断电话号码   和密码是否合法
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$";
	 /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
    /**
     * 正则表达式：验证密码
     */
   // public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    public static final String REGEX_PASSWORD = "^(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,15}";
    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
}

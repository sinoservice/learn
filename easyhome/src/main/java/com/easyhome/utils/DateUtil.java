package com.easyhome.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>
 * Title: DateUtil
 * </p>
 * <p>
 * Description: 日期格式化工具类
 * </p>
 * 
 * @date 2016年5月11日 下午2:24:35
 * @version 1.0
 *
 */
public class DateUtil {

	/**
	 * 默认格式化
	 */
	public static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final SimpleDateFormat YYYY_MM_DD_HH_MM_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * 
	 * <p>
	 * Description: 字符串转日期
	 * </p>
	 * 
	 * @date 2016年5月11日 下午2:31:29
	 * @version 1.0
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date string2date(String dateString) throws ParseException {
		return DEFAULT_FORMAT.parse(dateString);
	}

	/**
	 * 
	 * <p>
	 * Description: 日期转字符串
	 * </p>
	 * 
	 * @date 2016年5月11日 下午2:31:46
	 * @version 1.0
	 * @param date
	 * @return
	 */
	public static String date2string(Date date) {
		return DEFAULT_FORMAT.format(date);
	}

	/**
	 * 字符串转日期
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @date 2016年5月13日 下午2:34:14
	 * @version 1.0
	 * @param dateString
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date string2date(String dateString, DateFormat format) throws ParseException {
		return format.parse(dateString);
	}

	public static String dataFormat(String format, Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static void main(String[] args) {
		String dataFormat = dataFormat("yyyy-mm-dd HH:mm:ss", new Date());
		System.out.println(dataFormat);
	}

}

package com.easyhome.utils;

import org.apache.log4j.Logger;

import com.easyhome.po.Week;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 月份划分类
 */
public class MonthDivide {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MonthDivide.class);

	/**
	 * 获取每周开始时间，结束时间(自然周)
	 * 
	 * @param completeDate
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Week> getWeeks(String completeDate) throws Exception {
		ArrayList<Week> listWeek = new ArrayList<Week>();

		Week week = null;
		String weekbegin = "";
		String weekEnd = "";
		// String date = "2013-09";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		Date date1 = dateFormat.parse(completeDate);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int count = 0;
		for (int i = 1; i <= days; i++) {
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = dateFormat1.parse(completeDate + "-" + i);
			calendar.clear();
			calendar.setTime(date2);
			int k = calendar.get(Calendar.DAY_OF_WEEK);
			if (k == 1) {// 若当天是周日
				count++;
				if (i - 6 <= 1) {
					//开始日期
					weekbegin = completeDate + "-" + 1;
				} else {
					//结束日期
					weekbegin = completeDate + "-" + (i - 6);
				}
				weekEnd = completeDate + "-" + i;
				week = new Week();
				week.setWeekBegin(weekbegin);
				week.setWeekEnd(weekEnd);
				listWeek.add(week);
			}

			if (k != 1 && i == days) {// 若是本月最后一天，且不是周日
				count++;
				//本周开始日期
				weekbegin = completeDate + "-" + (i - k + 2);
				//本周结束日期
				weekEnd = completeDate + "-" + i;
				week = new Week();
				week.setWeekBegin(weekbegin);
				week.setWeekEnd(weekEnd);
				listWeek.add(week);
			}
		}
		return listWeek;
	}

	/**
	 * 获取每月有多少周
	 * @param completeDate("yyyy-MM")
	 *            
	 * @return
	 * @throws Exception
	 */
	public static List<Week> getDays(String completeDate) throws Exception {
		List<Week> listWeek = new ArrayList<Week>();
		// String date = "2013-09";
		String firstDayBegin = completeDate + "-" + "01";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse(firstDayBegin);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		calendar.add(Calendar.DATE, 6);
		String firstDateEnd = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		String secondDayBegin = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DATE, 6);
		String secondDayEnd = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		String thirdDayBegin = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DATE, 6);
		String thirdDayEnd = dateFormat.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		String fourthDayBegin = dateFormat.format(calendar.getTime());
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String fourthDayEnd = completeDate + "-" + days;
		listWeek.add(new Week(firstDayBegin, firstDateEnd));
		listWeek.add(new Week(secondDayBegin, secondDayEnd));
		listWeek.add(new Week(thirdDayBegin, thirdDayEnd));
		listWeek.add(new Week(fourthDayBegin, fourthDayEnd));
		return listWeek;
	}

	/**
	 * 获取某月的最后一天 @Title:getLastDayOfMonth @Description: @param:@param
	 * completeDate @param:@return @return:String @throws
	 */
	public static String getLastDayOfMonth(String completeDate) {
		String[] ym = null;
		Integer year = null;
		Integer month = null;
		// String regex="[0-9]{4}-[0-9]{2}";
		// if(completeDate.matches(regex)){
		try {
			ym = completeDate.split("-");
			year = Integer.parseInt(ym[0]);
			month = Integer.parseInt(ym[1]);

			Calendar cal = Calendar.getInstance();
			// 设置年份
			cal.set(Calendar.YEAR, year);
			// 设置月份
			cal.set(Calendar.MONTH, month - 1);
			// 获取某月最大天数
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			// 设置日历中月份的最大天数
			cal.set(Calendar.DAY_OF_MONTH, lastDay);
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String lastDayOfMonth = sdf.format(cal.getTime());
			return lastDayOfMonth;
		} catch (Exception e) {
			logger.error("您输入的信息有误！");
		}
		return "";
	}

	private static final int FIRST_DAY = Calendar.MONDAY;

	private static void printWeekdays() {
		Calendar calendar = Calendar.getInstance();
		setToFirstDay(calendar);
		for (int i = 0; i < 7; i++) {
			printDay(calendar);
			calendar.add(Calendar.DATE, 1);
		}
	}
	private static void setToFirstDay(Calendar calendar) {
		while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
			calendar.add(Calendar.DATE, -1);
		}
	}

	private static void printDay(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd EE");
		//System.out.println(dateFormat.format(calendar.getTime()));
	}

	public static class FindDates {

		public static List<Date> findDates(Date dBegin, Date dEnd) {
			List lDate = new ArrayList();
			lDate.add(dBegin);
			Calendar calBegin = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calBegin.setTime(dBegin);
			Calendar calEnd = Calendar.getInstance();			
			// 使用给定的 Date 设置此 Calendar 的时间
			calEnd.setTime(dEnd);
			// 测试此日期是否在指定日期之后
			while (dEnd.after(calBegin.getTime())) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				calBegin.add(Calendar.DAY_OF_MONTH, 1);
				lDate.add(calBegin.getTime());
			}
			return lDate;
		}
	}
}
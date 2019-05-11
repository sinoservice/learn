package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.easyhome.po.Week;
import com.easyhome.utils.MonthDivide;

public class Calendar {
	@Test
	public void test() throws ParseException{
		 String date = "2013-09";//修改测试
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		System.out.println(dateFormat);
		Date date1 = dateFormat.parse(date);
		System.out.println(date1);
	}
	
	public static void main(String[] args) {
	String date = "2016-11";
	List<Week> days;
	try {
		days = MonthDivide.getDays(date);
		for(Week day:days){
			System.out.println("day.getWeekBegin():"+day.getWeekBegin());
			System.out.println(day.getWeekEnd());
		}
		String lastDayOfMonth = MonthDivide.getLastDayOfMonth(date);
		System.out.println("lastDayOfMonth:"+lastDayOfMonth);
		ArrayList<Week> weeks = MonthDivide.getWeeks(date);
		for(Week week:weeks){
			System.out.println("week.getWeekBegin():"+week.getWeekBegin());
			System.out.println(week.getWeekEnd());
		}
		Calendar calendar=new Calendar();
		System.out.println(calendar.hashCode());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}

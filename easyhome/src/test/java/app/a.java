package app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.easyhome.po.Week;
import com.easyhome.utils.MonthDivide;

public class a {
public static void main(String[] args) throws Exception {
	String date="2016-02";
	String lastDayOfMonth = MonthDivide.getLastDayOfMonth(date);
	List<Week> days = MonthDivide.getDays(date);
	ArrayList<Week> weeks = MonthDivide.getWeeks(date);
	for(Week week:weeks){
		System.out.println(week);
	}
	
	System.out.println(days);
	System.out.println(lastDayOfMonth);
	System.out.println("-----------");
	
	Calendar calendar=Calendar.getInstance();
//	calendar.set(Calendar.YEAR, 2016);
//	calendar.set(Calendar.MONTH, 2-1);
	int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
	System.err.println("actualMaximum:"+actualMaximum);
	System.out.println(calendar.getTime());
	System.out.println(calendar.getFirstDayOfWeek());
	System.out.println(calendar.getWeeksInWeekYear());
	System.out.println(calendar.getWeekYear());
	System.out.println(calendar.getMinimalDaysInFirstWeek());
	String firstDay="8";
	if (firstDay.length()!=2) {
		firstDay=0+firstDay;
	}
	System.out.println(firstDay);
	System.out.println(firstDay.length()+"-------------");
//	if (firstDay.l) {
//		
//	}
//	String firstDay=date+"/01";
//	String lastDay = MonthDivide.getLastDayOfMonth(date);
//	String regex="[0-9]{4}/[0-9]{2}/[0-9]{2}";
	String []a={"1","2","3","4","5"};
	String c="";
	for(String b:a){
		c+=b+"/";
		System.out.println(c);
	}
	System.out.println(c);
	System.out.println("---------------"+calendar.get(Calendar.DAY_OF_WEEK));
}


}

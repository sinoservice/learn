package com.easyhome.service.oms.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.easyhome.po.oms.MasterReceipts;
import com.easyhome.po.oms.ReceiptsDetail;
import com.easyhome.po.oms.Week;
import com.easyhome.service.oms.ReceiptsService;
import com.easyhome.utils.oms.MonthDivide;
import com.easyhome.utils.oms.MonthDivide.FindDates;
import com.easyhome.vo.OrderResult;

@Service("receiptsService")
public class ReceiptsServiceImpl implements ReceiptsService{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ReceiptsServiceImpl.class);
	/**
	 * 查询每月的总收益
	 * @param masterId
	 * @param completeDate
	 */
	
	public OrderResult findMonthReceipts(String masterId,String completeDate) {
		OrderResult response=new OrderResult();
		Map<String,Object> data=new HashMap<String,Object>();
		String firstDay=completeDate+"-01";
		String lastDay = MonthDivide.getLastDayOfMonth(completeDate);
		String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
			if(firstDay.matches(regex) && lastDay.matches(regex)){
			try {
			
			Double receipts=Double.valueOf(500);
			data.put("month_profit", receipts);
			
			/**
			 * 查询每月每周所有收益
			 * @param masterId
			 * @param completeDate 前台参数 2016-05
			 */
			
			List<Week> weekList = new ArrayList<Week>();
			Week detile= new Week();
				List<Week> listWeek = MonthDivide.getDays(completeDate);
				int weekSize = 0;
					weekSize = listWeek.size();
					// 找到当月有多少个周 
					for(int i = 0; i < weekSize; i++){
						Week week = listWeek.get(i);
						String weekBegin = week.getWeekBegin();
						String weekEnd = week.getWeekEnd();
						Double profit=Double.valueOf(200);
						detile.setProfit(profit);
						detile.setWeekBegin(weekBegin);
						detile.setWeekEnd(weekEnd);
						weekList.add(detile);
					}
					data.put("weeks_profit", weekList);
			
			/**
			 * 查询所有收益（已完工）
			 * @param masterid
			 * @param completeDate
			 */
				Double allReceipts=Double.valueOf(300);
				data.put("all_profit", allReceipts);
				response.setErrCode(0);
				response.setErrMsg("查询成功");
		} catch (Exception e) {
			response.setErrCode(-1);
			response.setErrMsg("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！",e);
		}
			}else{
				response.setErrCode(-1);
				response.setErrMsg("您输入的日期格式有误,请重新输入！");
				logger.error("日期输入格式有误！");
			}
			response.setResult(data);
			return response;
		
}	
	/**
	 *通过开始日期结束日期获取技师本周收益，以及该周每天的收益
	 * @throws Exception 
	 */
	
	
	public OrderResult findWeekReceipts(String masterId,String weekBegin,String weekEnd) throws Exception {
		OrderResult response=new OrderResult();
		Map<String,Object> data=new HashMap<>();
		String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
		try {
			if(weekBegin.matches(regex) && weekEnd.matches(regex)){
			//查询本周收益
			Double receipts=Double.valueOf(300);
			data.put("week_profit", receipts);
			
			/**
			 * 查询所有收益（已完工）
			 * @param masterid
			 * @param completeDate
			 */
			
				Double allReceipts=Double.valueOf(500);
				data.put("all_profit", allReceipts);
				
			//查询每周收益
			List<MasterReceipts> weekList=new ArrayList<MasterReceipts>();
			MasterReceipts profit=new MasterReceipts();
			//获取每周开始，结束时间
			 Calendar cal = Calendar.getInstance();  
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			    
			    Date dBegin = sdf.parse(weekBegin);  
			    Date dEnd = sdf.parse(weekEnd);  
			    List<Date> lDate =FindDates.findDates(dBegin, dEnd); 
			    //遍历每一天
			    for (Date date : lDate) {  
			        String weekDay=sdf.format(date); 
			        Double d=Double.valueOf(300);
			        profit.setProfit(d);
			        profit.setDay(weekDay);
			        weekList.add(profit);
			    }  
			    data.put("datys_profit", weekList);
			    response.setErrCode(0);
			    response.setErrMsg("查询成功");
			}else{
				response.setErrCode(-1);
				response.setErrMsg("您输入的日期格式有误,请重新输入！");
				logger.error("日期输入格式有误！");
			}
		} catch (Exception e) {
			response.setErrCode(-1);
			response.setErrMsg("亲，您查询的页面不见了，请稍后重试！");
			logger.error("数据库连接失败！",e);
		}
		response.setResult(data);
		return response;
	}
	/**
	 * 根据指定日期获取时间段内每天的收益
	 */

	public OrderResult findDetail(String masterId, String workNo, String timeBegin, String timeEnd, Integer pageIndex,Integer pagesize) {
		OrderResult response=new OrderResult();
		Map<String,Object> map=new HashMap<>();
		List<ReceiptsDetail> detail=new ArrayList<>();
		try {
			int rowStart = ((pageIndex - 1) * pagesize) + 1;
			int rowEnd = pageIndex * pagesize;
			String regex="[0-9]{4}-[0-9]{2}-[0-9]{2}";
		if(timeBegin.matches(regex) && timeEnd.matches(regex)){
			Double a=Double.valueOf(100);
			ReceiptsDetail receipt=new ReceiptsDetail();
			receipt.setCompleteDate("121");
			receipt.setOrder_no("A12123");
			receipt.setProfit(a);
			detail.add(receipt);
			map.put("order_profit", detail);
			 response.setErrCode(0);
			 response.setErrMsg("查询成功");
		}else{
			response.setErrCode(-1);
			response.setErrMsg("您输入的日期格式有误,请重新输入！");
			logger.error("日期输入格式有误！");
		}
		} catch (Exception e) {
			response.setErrCode(-1);
			response.setErrMsg("亲，您查询的页面不见了，请稍后重试！");
			logger.error("获取数据异常！",e);
		}
		response.setResult(map);
		return response;
	}
	
}

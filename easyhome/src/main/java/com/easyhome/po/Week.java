package com.easyhome.po;

public class Week {
	private String weekBegin;
	private String weekEnd;
	private Double profit;
	
	public Week() {
	}
	
	public Week(String weekBegin,String weekEnd) {
		this.weekBegin = weekBegin;
		this.weekEnd = weekEnd;
	}
	
	public String getWeekBegin() {
		return weekBegin;
	}
	public void setWeekBegin(String weekBegin) {
		this.weekBegin = weekBegin;
	}
	public String getWeekEnd() {
		return weekEnd;
	}
	public void setWeekEnd(String weekEnd) {
		this.weekEnd = weekEnd;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}
	
	
	
}

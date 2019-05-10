package com.easyhome.utils;

/**
 * 用来存储Excel标题的对象，通过该对象可以实现标题和方法的对应关系
 */
public class ExcelHeader implements Comparable<ExcelHeader>{
	/**
	 * Excel的标题名称
	 */
	private String title;
	/**
	 * 标题的书序
	 */
	private int order;
	/**
	 * 表题对应的方法名称
	 */
	private String methodName;

	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ExcelHeader(String title, int order, String methodName) {
		super();
		this.title = title;
		this.order = order;
		this.methodName = methodName;
	}
	
	public ExcelHeader() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "ExcelHeader [title=" + title + ", order=" + order
				+ ", methodName=" + methodName + "]";
	}
	public int compareTo(ExcelHeader o) {	
		return order>o.order?1:(order<o.order?-1:0);
	}
	
	
}

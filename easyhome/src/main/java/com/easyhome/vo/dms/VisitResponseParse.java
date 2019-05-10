package com.easyhome.vo.dms;


/**
 * 
 * <p>标题: VisitRequestData</p>
 * <p>描述: 回访结果解析类</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年10月20日 上午9:49:03</p>
 * <p>版本: 1.0</p>
 */
public class VisitResponseParse {

	private int returnCode;
	
	private String info;
	
	private VisitResponseData data;

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public VisitResponseData getData() {
		return data;
	}

	public void setData(VisitResponseData data) {
		this.data = data;
	}
	
	
}

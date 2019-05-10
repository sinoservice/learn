package com.easyhome.vo;

/**
 * 
 * @ClassName: TmsResponse
 * @Description: TODO tms返回工具类
 * @date 2016年11月16日 下午3:45:58
 *
 */
public class TmsResponse {
	private int retCode;//0--服务器返回标志，0：操作成功，-1：操作失败，500：调用服务器接口失败
	private String retMessage;//提示信息
	private Object resultData;//结果集

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetMessage() {
		return retMessage;
	}

	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

}

package com.easyhome.vo;

/**
 * 
* @ClassName: AdjustResult 
* @Description: TODO 调整单结果集
* @date 2016年9月1日 下午3:11:37 
*
 */
public class AdjustResponse {
    private int errCode;
	
	private String errMsg;
	
	private Object detail;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}

	
}

package com.easyhome.vo;

public class AutherizedInfoResponse {

	private int returnCode;
	
	private String info;
	
	/*private String isReviewFlag;*/

	private Object result;

	
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

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

	/*public String getIsReviewFlag() {
		return isReviewFlag;
	}

	public void setIsReviewFlag(String isReviewFlag) {
		this.isReviewFlag = isReviewFlag;
	}*/
	
	
}

package com.easyhome.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeResponse extends OrderResult{
	@JsonProperty("CODE")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

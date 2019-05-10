package com.easyhome.vo.bos;

import java.io.Serializable;
import java.util.List;

public class OrderSendEntity extends ObOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027747875749754657L;
	
	private List<ObOrderDetail> detail;

	public List<ObOrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<ObOrderDetail> detail) {
		this.detail = detail;
	}
}

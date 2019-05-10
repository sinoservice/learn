package com.easyhome.po.mb;

import java.util.List;

public class OrderEntity extends MyReturnResponse {

	private List<WorkOrderEntity> data;

	public List<WorkOrderEntity> getData() {
		return data;
	}

	public void setData(List<WorkOrderEntity> data) {
		this.data = data;
	}

}

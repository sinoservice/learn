package com.easyhome.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <p> Title: WorkOrderPartlyCompletedRequest</p>
 * <p> Description: 部分完工</p>
 * 
 * @date 2016年6月23日 下午5:09:40
 * @version 1.0
 *
 */
public class WorkOrderPartlyCompletedRequest implements Serializable{
	
	private static final long serialVersionUID = 629450473891299009L;
	
	public String workorderid;
	public String masterid;
	public String remark;
	public String phone;
	public String name;
	public String address;
	public String image;
	public List<Goods> items;
	
	@Override
	public String toString() {
		return "WorkOrderPartlyCompletedRequest [workorderid=" + workorderid + ", masterid=" + masterid + ", remark="
				+ remark + ", phone=" + phone + ", name=" + name + ", address=" + address + ", image=" + image
				+ ", items=" + items + "]";
	}
	
}



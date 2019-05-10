package com.easyhome.service.oms;

public interface QuitWorkorService {

	
	/**
	 * 
	 * <p> Description: 放弃工单</p>
	 * 
	 * @date 2016年7月6日 下午5:20:39
	 * @version 1.0
	 * @param workorderid
	 * @param remark
	 * @return
	 */
	public String quitWorkor(String omsMasterId,String workorderid,String remark);


}

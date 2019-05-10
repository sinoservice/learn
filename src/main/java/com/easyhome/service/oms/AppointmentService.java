package com.easyhome.service.oms;


import com.easyhome.po.oms.AppointmentRequest;
import com.easyhome.vo.BaseResponse;

public interface AppointmentService {
	/**
	 * 
	 * <p> Description: 工单预约</p>
	 * 
	 * @date 2016年7月5日 上午10:23:44
	 * @version 1.0
	 * @param request
	 * @return
	 */
	public String appiontWorker(AppointmentRequest request);

	/**
	 * 
	 * <p> Description: oms重发验证码</p>
	 * 
	 * @date 2016年7月7日 上午11:36:02
	 * @version 1.0
	 * @param code
	 * @param phone
	 * @return
	 */
	public BaseResponse reSendSmsCode(String code, String phone);

}

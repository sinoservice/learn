package com.easyhome.service.dms;

import javax.servlet.http.HttpServletRequest;

import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.dms.EbTechnicianModel;
import com.easyhome.vo.dms.ServiceAreaRequest;

public interface DmsMasterservice {
	
	BaseResponse login(String phone, String password);

	BaseResponse Register(HttpServletRequest request,EbTechnicianModel ebTechnicianModel);
	
	BaseResponse findPassWord(HttpServletRequest request,String phone,String passWord,int code);
	
	BaseResponse findCaptcha(HttpServletRequest request,String phone);
	
	BaseResponse updatePassWord(String phone,String passWord,String newPassWord);
	
	BaseResponse findServiceArea(ServiceAreaRequest areaRequest);
	
	BaseResponse updateWorkerData(HttpServletRequest request,EbTechnicianModel ebTechnicianModel);
}

package com.easyhome.controller.dms;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.service.dms.DmsMasterservice;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.dms.EbTechnicianModel;
import com.easyhome.vo.dms.ServiceAreaRequest;

@RestController
@RequestMapping("/dms/master")
public class DmsMasterController {
	@Resource
	private DmsMasterservice masterservice;
	/**
	 * 
	 * <@Description 登录>
	 * @time 2016年10月31日 下午3:16:31
	 * @version V1.0 
	 * @param  phone
	 * @param  password
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public BaseResponse Login(String phone,String password){
		BaseResponse response=masterservice.login(phone, password);
		return response;
	}
	/**
	 * 
	 * <@Description 注册>
	 * @time 2016年10月31日 下午2:08:41
	 * @version V1.0 
	 * @param  ebTechnicianModel
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public BaseResponse register(HttpServletRequest request,EbTechnicianModel ebTechnicianModel){
		BaseResponse response=masterservice.Register(request,ebTechnicianModel);
		return response;
	}
	/**
	 * 
	 * <@Description 忘记密码>
	 * @time 2016年10月31日 下午3:17:30
	 * @version V1.0 
	 * @param  request
	 * @param  phone
	 * @param  passWord
	 * @param  code
	 */
	@RequestMapping(value="/findPassWord",method=RequestMethod.POST)
	public BaseResponse findPassWord(HttpServletRequest request,String phone,String passWord,int code){
		BaseResponse response=masterservice.findPassWord(request, phone, passWord, code);
		return response;
	}
	/**
	 * 
	 * <@Description 修改密码>
	 * @time 2016年10月31日 下午3:17:51
	 * @version V1.0 
	 * @param  phone
	 * @param  passWord
	 * @param  newPassWord
	 */
	@RequestMapping(value="/updatePassWord",method=RequestMethod.POST)
	public BaseResponse updatePassWord(String phone,String passWord,String newPassWord){
		BaseResponse response=masterservice.updatePassWord(phone, passWord, newPassWord);
		return response;
	}
	/**
	 * 
	 * <@Description 发送验证码>
	 * @time 2016年10月31日 下午6:06:22
	 * @version V1.0 
	 * @param  request
	 * @param  phone
	 */
	@RequestMapping("/findCaptcha")
	public BaseResponse findCaptcha(HttpServletRequest request, String phone){
		BaseResponse response=masterservice.findCaptcha(request, phone);
		return response;
	}
	/**
	 * 
	 * <p>description: 查询服务区域</p>
	 * @param areaRequest
	 * @return
	 * @date 2016年11月3日 下午3:46:41
	 */
	@RequestMapping(value="/findServiceArea",method=RequestMethod.POST)
	public BaseResponse findServiceArea(ServiceAreaRequest areaRequest){
		BaseResponse response=masterservice.findServiceArea(areaRequest);
		return response;
	}
	/**
	 * 
	* @Title: updateWorkerData 
	* @Description: TODO 更新技师信息
	* @param request 请求
	* @param ebTechnicianModel 技师信息
	* @return 
	* BaseResponse    
	* @throws 
	* @date 2017年6月7日 上午10:08:23
	 */
	@RequestMapping(value="updateWorker",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponse updateWorkerData(HttpServletRequest request,EbTechnicianModel ebTechnicianModel){
		return masterservice.updateWorkerData(request, ebTechnicianModel);
	}
}

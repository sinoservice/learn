package com.easyhome.service;

import java.util.Map;

import com.easyhome.po.TbAppUser;
import com.easyhome.po.TbMaster;
import com.easyhome.vo.BaseResponse;

public interface UserService {

	public BaseResponse checkLogin(String phone,String password);
	public BaseResponse ModifyPassword(String fid,String oldpassword,String password);
	public BaseResponse AlterPassword(String phone,String password,String captcha);
	
	/**
	 * 
	 * <p> Description: 通过手机号码查询技师id</p>
	 * 
	 * @date 2016年7月7日 下午5:13:34
	 * @version 1.0
	 * @param phone
	 * @return
	 */
	public Map<String,String> findMasterIdByPhone(String phone);
	
	/**
	 * 
	 * <p>description: 通过手机号码查找技师登录信息</p>
	 * @param phone
	 * @return
	 * @date 2016年7月15日 上午11:05:09
	 */
	public TbAppUser findTbAppUserByPhone(String phone);
	
	/**
	 * 
	 * <p>description: 通过电话号码查询技师信息</p>
	 * @param phone 技师手机号码
	 * @return
	 * @throws Exception
	 * @date 2016年8月29日 下午3:07:18
	 */
	public TbMaster findMasterByPhone(String phone) throws Exception;
	
}

package com.easyhome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.Master;
import com.easyhome.po.User;
import com.easyhome.po.Worker;

public interface UserDao {

	public User findByPhone(@Param("phone") String phone);

	public void updatePassword(@Param("fid") String fid, @Param("md5_pwd") String md5_pwd);

	public String findPassword(@Param("fid") String fid);

	public String findCode(@Param("phone") String phone);

	public void updatePasswordByPhone(@Param("phone") String phone, @Param("md5_pwd") String md5_pwd);

	public String findPasswordByPhone(@Param("phone") String phone);

	public Master findMaster(@Param("masterId") String masterId);

	public Worker findWorker(@Param("masterId") String masterId);

	String findLeaderId(@Param("workerId") String workerId);
	
	public Integer findTag(@Param("phone")String phone);
	
	/**
	 * 
	 * <p> Description: 通过手机号码查询技师id</p>
	 * 
	 * @date 2016年7月7日 下午5:10:13
	 * @version 1.0
	 * @param phone
	 * @return
	 */
	public List<Map<String,String>> findMasterIdByPhone(String phone);
}

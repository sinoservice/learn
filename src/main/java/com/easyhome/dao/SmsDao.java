package com.easyhome.dao;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.Sms;

public interface SmsDao {
	Sms getSmsById(@Param("fid") String fid);

}

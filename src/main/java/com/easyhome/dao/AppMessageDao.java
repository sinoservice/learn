package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.AppMessage;
import com.easyhome.po.AppPushMessage;
import com.easyhome.po.Version;
public interface AppMessageDao {

	public int addVersion(@Param("appVersion") String appVersion,@Param("model") String model,@Param("androidVersion") String androidVersion,@Param("masterId") String masterId,@Param("phone")String phone);
	public AppMessage findById(@Param("masterId")String masterId);
	public void updateById(@Param("appVersion") String appVersion,@Param("model") String model,@Param("androidVersion") String androidVersion,@Param("masterId")String masterId,@Param("phone")String phone);
	public Version findVersion(@Param("flag")int flag);
	public List<String> findPhone();
	public List<AppPushMessage> findUnread(@Param("userId")String userId,@Param("rowStart") Integer rowStart,@Param("rowEnd") Integer rowEnd);
	public List<AppPushMessage> findRead(@Param("userId")String userId,@Param("rowStart") Integer rowStart,@Param("rowEnd") Integer rowEnd);
	public List<AppPushMessage> findAll(@Param("userId")String userId,@Param("rowStart") Integer rowStart,@Param("rowEnd") Integer rowEnd);
}

package com.easyhome.dao;

import org.apache.ibatis.annotations.Param;

public interface KilometerDao {

	public void addStart(@Param("fid")String fid,@Param("driverNo")String driverNo,@Param("driverId")String driverId,
			@Param("startKilometer")double startKilometer,@Param("Url")String Url);
	public void addEnd(@Param("endKilometer")double endKilometer,@Param("Url")String Url);
}

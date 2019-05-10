package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.MasterReceipts;
import com.easyhome.po.ReceiptsDetial;
import com.easyhome.po.Week;


public interface MasterReceiptsDao {

	public Double findReceipts(@Param("masterId")String masterId,@Param("firstDay")String firstDay,@Param("lastDay")String lastDay);
	public Double findReceiptsById(@Param("masterId")String masterId);
	public MasterReceipts findDayReceipts(@Param("masterId")String masterId,@Param("day")String day);
	public Week findWeekById(@Param("masterId")String masterId,@Param("weekBegin")String weekBegin,@Param("weekEnd")String weekEnd);
	public Double findWeekReceipts(@Param("masterId")String masterId,@Param("weekBegin")String weekBegin,@Param("weekEnd")String weekEnd);
	public List<ReceiptsDetial> findDetail(@Param("masterId")String masterId,@Param("timeBegin")String timeBegin,@Param("timeEnd")String timeEnd,@Param("rowStart") Integer rowStart,
			@Param("rowEnd") Integer rowEnd);
}

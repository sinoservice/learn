package com.easyhome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbWorkOrderBackup;

public interface TbWorkOrderBackupDao {
	   List<TbWorkOrderBackup> selectByMasterId(
			@Param("masterId") String masterId,
			@Param("rowStart") Integer rowStart,
			@Param("rowEnd") Integer rowEnd);
		
	
}

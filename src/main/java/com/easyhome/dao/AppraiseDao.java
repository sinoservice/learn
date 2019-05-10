package com.easyhome.dao;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.Appraise;
import com.easyhome.po.AppraiseMessage;
public interface AppraiseDao {

	public void save(@Param("appraise")Appraise appraise);
	public void updateAppraise(@Param("appraiseMessage")AppraiseMessage appraiseMessage);
	public AppraiseMessage findAppraiseMessage(@Param("workorderid") String workorderid);
	public Appraise  findAppraise(@Param("workorderid") String workorderid);
}

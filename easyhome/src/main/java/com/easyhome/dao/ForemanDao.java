package com.easyhome.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easyhome.po.Worker;
import com.easyhome.po.WorkerListResponse;
import com.easyhome.po.WorkerResponse;

public interface ForemanDao {

	public void insert(@Param("user_fid")String user_fid,@Param("name")String name, @Param("phone")String phone,@Param("passWord")String passWord,@Param("worker_fid")String worker_fid);
	public void insertWorker(@Param("worker_fid")String worker_fid,@Param("name")String name, @Param("phone")String phone,@Param("masterId")String masterId);
	public int updateWorkerDetile(Worker worker);
	public void update(@Param("name")String name, @Param("phone")String phone,@Param("passWord")String passWord,@Param("fid")String fid);
	public void updateWorker(@Param("name")String name, @Param("phone")String phone,@Param("fid")String fid);
	public void updateLocking(@Param("fid")String fid,@Param("masterId")String masterId,@Param("locking")Integer locking);
	public Integer findLocking(@Param("fid")String fid);
	public String findPhone(@Param("phone")String phone);
	public void updateTag(@Param("fid")String fid,@Param("masterId")String masterId);
	public List<WorkerListResponse> findWorker(@Param("masterId")String masterId,@Param("rowStart")Integer rowStart,@Param("rowEnd")Integer rowEnd);
	public String findFid(@Param("masterId")String masterId);
	/*public int updateUser(@Param("fid")String fid,@Param("sex")String sex,@Param("master_fid")String master_fid);*/
	public WorkerResponse findWorkerDetile(@Param("fid")String fid,@Param("masterId")String masterId);
	public String findPassWord(@Param("fid")String fid);
	public String findMasterId(@Param("phone")String phone);
	
}

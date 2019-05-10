package com.easyhome.service;


import com.easyhome.po.WorkerRequest;
import com.easyhome.vo.BaseResponse;

public interface ForemanService {

	public BaseResponse save(String name,String phone,String passWord,String masterId);
	public BaseResponse updateWorker(String name,String phone,String passWord,String fid);
	public BaseResponse updateLocking(String fid,String masterId, Integer locking);
	public BaseResponse updateTag(String fid,String masterId);
	public BaseResponse findWorker(String masterId,Integer pageIndex,Integer pageSize);
	public BaseResponse insertWorkerDetile(WorkerRequest workerRequest);
	public BaseResponse findWorkerDetile(String fid,String masterId);
}

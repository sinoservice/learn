package com.easyhome.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyhome.po.WorkerRequest;
import com.easyhome.service.ForemanService;
import com.easyhome.vo.BaseResponse;


@RestController
@RequestMapping("/foreman")
public class ForemanController {
	@Resource
	private ForemanService foremanService;
	@RequestMapping("/addForeman")
	public BaseResponse addForeman(String name,String phone,String passWord,String masterId){
		BaseResponse response=foremanService.save(name, phone, passWord,masterId);
		return response;
	}
	/**
	 * 修改工人信息
	 */
	@RequestMapping("/updateWorker")
	public BaseResponse modifyWorker(String name, String phone, String passWord,String fid){
		BaseResponse response=foremanService.updateWorker(name, phone, passWord,fid);
		return response;
	}
	/**
	 * 锁定/解锁工人
	 */
	@RequestMapping("/updateLocking")
	public BaseResponse updateLocking(String fid,String masterId,Integer locking){
		BaseResponse response=foremanService.updateLocking(fid,masterId,locking);
		return response;
	}
	/**
	 * 删除工人
	 */
	@RequestMapping("/deleteWorker")
	public BaseResponse deleteWorker(String fid,String masterId){
		BaseResponse response=foremanService.updateTag(fid,masterId);
		return response;
	}
	/**
	 * 查询工人列表
	 */
	@RequestMapping("/findWorker")
	public BaseResponse findWorker(String masterId,Integer pageIndex,Integer pageSize){
		BaseResponse response=foremanService.findWorker(masterId,pageIndex,pageSize);
		return response;
	}
	/**
	 * 完善工人信息
	 */
	@RequestMapping("/insertWorkerDetile")
	public BaseResponse insertWorkerDetile(WorkerRequest workerRequest){
		BaseResponse response=foremanService.insertWorkerDetile(workerRequest);
		return response;
	}
	/**
	 * 查询工人详细信息
	 */
	@RequestMapping("/findWorkerDetile")
	public BaseResponse findWorkerDetile(String fid,String masterId){
		BaseResponse response=foremanService.findWorkerDetile(fid,masterId);
		return response;
	}
}

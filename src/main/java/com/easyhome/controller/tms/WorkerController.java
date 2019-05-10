package com.easyhome.controller.tms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.tms.WorkerComplete;
import com.easyhome.service.tms.WorkerServiceI;
import com.easyhome.utils.ReturnCode;
import com.easyhome.vo.BaseResponse;
import com.google.gson.Gson;

@Controller
@RequestMapping("/tms/workers")
public class WorkerController {
	private static final Logger logger = Logger.getLogger(WorkerController.class);

	Log log = LogFactory.getLog(WorkerController.class);

	@Autowired
	private WorkerServiceI workerService;

	/**
	 * 调用查询工人列表接口
	 * 
	 * @param masterId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getlist")
	@ResponseBody
	public String findWorkerList(String masterId, Integer pageIndex, Integer pageSize) throws Exception {
		logger.info("masterId:" + masterId);
		logger.info("pageIndex:" + pageIndex);
		logger.info("pageSize:" + pageSize);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String workerList = workerService.findWorkerList(masterId, pageIndex, pageSize);
			return workerList;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}

	/**
	 * 调用查询工人详情接口
	 * 
	 * @param fid
	 * @param masterId
	 * @return
	 */
	@RequestMapping("/getWorkerDetails")
	@ResponseBody
	public String findWorkerDetails(String fid, String masterId) {
		logger.info("masterId:" + masterId);
		logger.info("fid:" + fid);
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String workerDetails = workerService.findWorkerDetails(fid, masterId);
			return workerDetails;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}

	/**
	 * 
	 * @Title: completeWorkerDetails @Description: TODO 调用完善工人信息接口 @param @param
	 * workerComplete @param @return @return String @throws
	 */
	@RequestMapping("/completeWorkerDetails")
	@ResponseBody
	public String completeWorkerDetails(WorkerComplete workerComplete) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String workerDetails = workerService.completeWorkerDetails(workerComplete);
			return workerDetails;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}		
	}

	/**
	 * 
	* @Title: lookOwnerData 
	* @Description: TODO 调用查看个人信息接口
	* @param @param fid
	* @param @return    
	* @return String
	* @throws
	 */
	@RequestMapping("/lookOwnerData")
	@ResponseBody
	public String lookOwnerData(String fid) {
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String workerData = workerService.lookOwnerData(fid);
			return workerData;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}
	
	
	/**
	 * 
	 * <p>description: 添加工人</p>
	 * @param name
	 * @param phone
	 * @param passWord
	 * @param masterId
	 * @return
	 * @date 2016年7月28日 上午10:32:28
	 */
	@RequestMapping("/addWorker")
	@ResponseBody
	public String addWorker(String name, String phone, String passWord, String masterId){
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String addWorker = workerService.add(name, phone, passWord, masterId);
			return addWorker ;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}
	/**
	 * 
	* @Title: deleteWorker 
	* @Description: TODO 删除工人接口
	* @param @param fid
	* @param @param masterId
	* @param @return    
	* @return String
	* @throws
	 */
	@RequestMapping("/deleteWorker")
	@ResponseBody
	public String deleteWorker(String fid,String masterId){
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String deleteWorker = workerService.delete(fid,masterId);
			return deleteWorker ;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}
	
	/**
	 * 
	* @Title: modifyLocking 
	* @Description: TODO 修改工人锁定/解锁状态
	* @param @param fid
	* @param @param masterId
	* @param @param locking
	* @param @return    
	* @return String
	* @throws
	 */
	@RequestMapping("/modifyLocking")
	@ResponseBody
	public String modifyLocking(String fid, String masterId, Integer locking){
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String modifyLocking = workerService.modifyLocking(fid, masterId, locking);
			return modifyLocking;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}
	/**
	 * 
	* @Title: modifyWorker 
	* @Description: TODO 修改工人信息接口
	* @param @param name
	* @param @param phone
	* @param @param passWord
	* @param @param fid
	* @param @return    
	* @return String
	* @throws
	 */
	@RequestMapping("/modifyWorker")
	@ResponseBody
	public String modifyWorker(String name, String phone, String passWord, String fid){
		Gson gson = new Gson();
		BaseResponse br = new BaseResponse();
		try {
			String modifyWorker= workerService.modifyWorker(name, phone, passWord, fid);
			return modifyWorker;
		} catch (Exception e) {
			br.setReturnCode(ReturnCode.STATUS_500);
			br.setInfo("请求失败");
			return gson.toJson(br);
		}
	}
}
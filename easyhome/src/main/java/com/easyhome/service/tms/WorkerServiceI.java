package com.easyhome.service.tms;

import com.easyhome.po.tms.WorkerComplete;

public interface WorkerServiceI {
	/**
	 * 
	* @Title: findWorkerList 
	* @Description: TODO 查询工人列表
	* @param  @param masterId
	* @param  @param pageIndex
	* @param  @param pageSize
	* @param  @return 
	* @return String    
	* @throws
	 */
   public String findWorkerList(String masterId,Integer pageIndex,Integer pageSize);
   /**
	 * 
	* @Title: findWorkerDetails 
	* @Description: TODO 查询工人详情
	* @param  @param fid
	* @param  @param masterId
	* @param  @return 
	* @return String    
	* @throws
	 */
   public String findWorkerDetails(String fid,String masterId);
   
   /**
    * 
   * @Title: completeWorkerDetails 
   * @Description: TODO 完善工人信息
   * @param @param workerComplete
   * @param @return    
   * @return String
   * @throws
    */
   public String completeWorkerDetails(WorkerComplete workerComplete);
   
   /**
    * 
   * @Title: lookOwnerData 
   * @Description: TODO 查看个人信息
   * @param @param fid
   * @param @return    
   * @return String
   * @throws
    */
   public String lookOwnerData(String fid);
   
   /**
    * 
   * @Title: add 
   * @Description: TODO 添加工人
   * @param @param name
   * @param @param phone
   * @param @param passWord
   * @param @param masterId
   * @param @return    
   * @return String
   * @throws
    */
   public String add(String name, String phone, String passWord, String masterId);
   
   /**
    * 
   * @Title: delete 
   * @Description: TODO 删除工人
   * @param @param fid
   * @param @param masterId
   * @param @return    
   * @return String
   * @throws
    */
   public String delete(String fid, String masterId);
   
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
   public String modifyLocking(String fid,String masterId,Integer locking);
   
   /**
    * 
   * @Title: modifyWorker 
   * @Description: TODO 修改工人信息
   * @param @param name
   * @param @param phone
   * @param @param passWord
   * @param @param fid
   * @param @return    
   * @return String
   * @throws
    */
   public String modifyWorker(String name,String phone,String passWord,String fid);
}

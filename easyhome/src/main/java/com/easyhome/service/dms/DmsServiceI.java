package com.easyhome.service.dms;

import com.easyhome.vo.dms.AppVersionBean;
import com.easyhome.vo.dms.BusStorageBean;

/**
 * 
 * <p>标题: DmsServiceI</p>
 * <p>描述: DMS服务接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年10月19日 上午8:53:12</p>
 * <p>版本: 1.0</p>
 */
public interface DmsServiceI {

	/**
	 * 
	 * <p>description: 工人拒单接口</p>
	 * @param masterId
	 * @param workOrderId
	 * @return
	 * @date 2016年10月19日 上午8:58:05
	 */
	String refuseDispatch(String masterId, String workOrderId);
	
	/**
	 * 
	* @param randomStr 
	 * @Title: SearchOrderStatus 
	* @Description: TODO  dms订单状态查询接口
	* @param  @param customerOrderNo
	* @param  @return
	* @param  @throws Exception 
	* @return String    
	* @throws 
	* @date 2016年10月19日 下午3:23:44
	 */
    public String SearchOrderStatus(String customerOrderNo, String randomStr,String sign);
    
    /**
     * 
    * @Title: findAppDispatchList 
    * @Description: TODO   app端工单列表接口
    * @param  @param masterId
    * @param  @param status
    * @param  @param pageSize
    * @param  @param pageIndex
    * @param  @parame isReviewFlag 技师审核状态
    * @param  @return 
    * @return String    
    * @throws 
    * @date 2016年11月1日 下午5:52:15
     */
    public String findAppDispatchList(String masterId, String status, int pageSize, int pageIndex, String lng, String lat, String orderBy, String isReviewFlag);

    public String findImgs(String orderNo);
    
    public String insertSequence(BusStorageBean bean);
    
    public String insertAppVersion(AppVersionBean bean);//保存app版本信息
    
    public String getPrivacyNumber(String workOrderId);
}

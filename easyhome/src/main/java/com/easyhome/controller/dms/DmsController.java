package com.easyhome.controller.dms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.service.dms.DmsServiceI;
import com.easyhome.vo.dms.AppVersionBean;
import com.easyhome.vo.dms.BusStorageBean;

/**
 * 
 * <p>标题: DmsController</p>
 * <p>描述: DMS提供接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * <p>创建时间: 2016年10月19日 上午8:48:51</p>
 * <p>版本: 1.0</p>
 */
@Controller
@RequestMapping(value="/eajudms")
public class DmsController {
	
	@Autowired
	private DmsServiceI dmsService;

	/**
	 * 
	 * <p>description: 拒单</p>
	 * @param masterId
	 * @param workOrderId
	 * @return
	 * @date 2016年10月21日 上午10:11:09
	 */
	@ResponseBody
	@RequestMapping(value="/refuseDispatch")
	public String refuseDispatch(String masterId,String workOrderId){
		String result = dmsService.refuseDispatch(masterId,workOrderId);
		return result;
	}
	
	
	/**
	 * 
	 * <p>description: 查询工单状态（居然到家需要）</p>
	 * @param customerOrderNo
	 * @param randomStr
	 * @return
	 * @date 2016年10月24日 下午6:38:23
	 */
	@ResponseBody
	@RequestMapping(value="/orderStatus")
	public String SearchOrderStatus(String customerOrderNo, String randomStr,String sign){
		
		String result = dmsService.SearchOrderStatus(customerOrderNo, randomStr, sign);
		return result;
	}
	
	/**
	 * 
	* @Title: findAppDispatchList 
	* @Description: TODO  查询app端工单列表
	* @param  @param masterId
	* @param  @param status
	* @param  @param pageSize
	* @param  @param pageIndex
	* @param  @param isReviewFlag 技师审核状态
	* @param  @return 
	* @return String    
	* @throws 
	* @date 2016年11月1日 下午6:10:22
	 */
	@ResponseBody
	@RequestMapping(value="/appOrderList")
	public String findAppDispatchList(String masterId, String status, int pageSize, int pageIndex, String lng, String lat, String orderBy, 
			String isReviewFlag) {
		String result = dmsService.findAppDispatchList(masterId, status, pageSize, pageIndex, lng, lat, orderBy, isReviewFlag);
		return result;
	}
	
	/**
	 * 
	* @Title: findImgs 
	* @Description: TODO 从图片服务器中查找图片
	* @param  @param orderNo
	* @param  @return 
	* @return String    
	* @throws 
	* @date 2016年12月6日 下午4:58:13
	 */
	@RequestMapping(value="/findImgs")
	@ResponseBody
	public String findImgs(String orderNo){
		return dmsService.findImgs(orderNo);
	}
	
	/**
	 * 
	* @Title: insertSequence 
	* @Description: TODO 
	* @param  @param bean
	* @param  @return 
	* @return String    
	* @throws 
	* @date 2016年12月9日 上午9:44:34
	 */
	@RequestMapping(value="/insertSequence")
	@ResponseBody
	public String insertSequence(BusStorageBean bean){
		return dmsService.insertSequence(bean);
	}
	
	/**
	 * 
	* @Title: insertAppVersion 
	* @Description: TODO 
	* @param bean
	* @return 
	* String    
	* @throws 
	* @date 2017年3月16日 上午10:41:30
	 */
	@RequestMapping(value="/insertAppVersion")
	@ResponseBody
	public String insertAppVersion(AppVersionBean bean){
		return dmsService.insertAppVersion(bean);
	}
}

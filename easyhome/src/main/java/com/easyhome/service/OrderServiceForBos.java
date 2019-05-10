package com.easyhome.service;

import java.util.List;

import com.easyhome.po.TbOrder;
import com.easyhome.po.TbOrderDetail;
import com.easyhome.vo.BaseResponse;

/**
 * 
 * <p>title: OrderService</p>
 * <p>description: 订单服务接口</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年8月6日 下午12:00:17
 */
public interface OrderServiceForBos {
	
	/**
	 * 
	 * <p>description: 保存订单</p>
	 * @return
	 * @throws Exception
	 * @date 2016年8月6日 下午2:48:27
	 */
	public int saveOrder( TbOrder tbOrder) throws Exception;
	
	
	/**
	 * 
	 * <p>description: 保存订单商品</p>
	 * @param tbOrderDetailList
	 * @return
	 * @throws Exception
	 * @date 2016年8月6日 下午2:50:01
	 */
	public int saveOrderDetails(List<TbOrderDetail> orderDetailList) throws Exception;


	/**
	 * 
	 * <p>description: 解析并保存来自三方的订单</p>
	 * @param data
	 * @return
	 * @throws Exception
	 * @date 2016年8月6日 下午3:17:41
	 */
	public BaseResponse parseAndSaveOrder(String data) throws Exception;


	/**
	 * 
	 * <p>description: 查询工单状态信息</p>
	 * @param status
	 * @return
	 * @throws Exception
	 * @date 2016年8月7日 下午2:27:52
	 */
	public BaseResponse getWorkOrderStatus(int status) throws Exception;
}

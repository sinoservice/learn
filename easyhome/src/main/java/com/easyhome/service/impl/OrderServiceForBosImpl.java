package com.easyhome.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.dao.TbOrderDetailMapper;
import com.easyhome.dao.TbOrderMapper;
import com.easyhome.dao.TbWorkOrderMapperCustom;
import com.easyhome.po.TbOrder;
import com.easyhome.po.TbOrderDetail;
import com.easyhome.po.TbOrderExample;
import com.easyhome.po.TbOrderExample.Criteria;
import com.easyhome.service.OrderServiceForBos;
import com.easyhome.vo.BaseResponse;
import com.easyhome.vo.bos.ObOrderDetail;
import com.easyhome.vo.bos.OrderSendEntity;
import com.easyhome.vo.bos.OrderStatusBean;
import com.google.gson.Gson;

/**
 * 
 * <p>title: OrderServiceForBosImpl</p>
 * <p>description: TODO</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>网址：<a href="www.juran.com.cn">www.juran.com.cn</a></p>
 * @date 2016年8月6日 下午2:42:55
 */
@Service("orderServiceForBos")
public class OrderServiceForBosImpl implements OrderServiceForBos{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderServiceForBosImpl.class);
	
	@Autowired
	private TbOrderMapper tbOrderMapper;
	
	@Autowired
	private TbOrderDetailMapper tbOrderDetailMapper;
	
	@Autowired
	private TbWorkOrderMapperCustom tbWorkOrderMapperCustom;

	@Override
	public int saveOrder(TbOrder tbOrder) throws Exception {
		int returnCode = -1;
		try {
			int selective = tbOrderMapper.insertSelective(tbOrder);
			if(selective>0){
				logger.info("保存成功");
				returnCode = 0;
			}
		} catch (Exception e) {
			logger.info("保存失败");
			logger.info(e);
		}
		return returnCode;
	}

	@Override
	public int saveOrderDetails(List<TbOrderDetail> orderDetailList) throws Exception {
		int returnCode = 0;
		try {
			for (TbOrderDetail tbOrderDetail : orderDetailList) {
				int selective = tbOrderDetailMapper.insertSelective(tbOrderDetail);
				if(selective>0){
					returnCode++;
				}
			}
			if(returnCode>0){
				logger.info("保存商品列表成功");
			}
		} catch (Exception e) {
			logger.info("保存商品列表失败");
		}
		return returnCode;
	}

	@Override
	public BaseResponse parseAndSaveOrder(String data) throws Exception {
		BaseResponse br = new BaseResponse();
		Gson gson = new Gson();
		try {
			OrderSendEntity ose = null;
			//1.解析数据
			try {
				ose = gson.fromJson(data, OrderSendEntity.class);
				if(ose!=null && ose.getBid()!=null){
					logger.info("解析数据成功");
				}else{
					br.setReturnCode(500);
					br.setInfo("解析数据失败");
				}
			} catch (Exception e) {
				br.setReturnCode(500);
				br.setInfo("解析数据异常");
				logger.info("解析数据异常",e);
				e.printStackTrace();
			}
			
			//2.存储数据
			if(ose!=null && ose.getBid()!=null){
				TbOrderExample example = new TbOrderExample();
				Criteria criteria = example.createCriteria();
				criteria.andFidEqualTo(ose.getBid());
				List<TbOrder> list2 = this.tbOrderMapper.selectByExample(example);
				if(list2==null || list2.size()<=0){
					int order = saveOrder(ose);
					
					if(order==0){
						logger.info("保存主订单信息成功");
						//保存订单详情
						List<ObOrderDetail> list = ose.getDetail();
						List<TbOrderDetail> tods = new ArrayList<TbOrderDetail>();
						
						if(list!=null && list.size()>0){
							for (ObOrderDetail d : list) {
								TbOrderDetail od = new TbOrderDetail();
								if(d!=null && d.getBid()!=null){
									od.setFid(d.getBid());
									od.setOrderId(d.getOrderBid());
									od.setOrderType("BOS");
									od.setProductName(d.getType03());
									od.setProductSn(d.getBizGoodsSn());
									//od.setProductPrice(new BigDecimal(d.getServicePrice()));
									//od.setSalesPrice(new BigDecimal(d.getServicePrice()));
									od.setProductQuantity(new BigDecimal(d.getAmount()));
									//od.setAmount(new BigDecimal(d.getTotal()));
									tods.add(od);
								}
							}
							
							int details = this.saveOrderDetails(tods);
							if(details>=1){
								br.setReturnCode(200);
								br.setInfo("订单保存成功");
								logger.info("保存订单商品成功");
							}else{
								br.setInfo("订单商品失败");
								logger.info("保存订单商品失败");
							}
						}
						br.setReturnCode(200);
					}else{
						br.setReturnCode(200);
						br.setInfo("保存订单成功，但无商品");
						logger.info("保存订单成功，但无商品");
					}
				}else{
					br.setReturnCode(200);
					br.setInfo("订单已经保存，请勿重复发送");
				}
			}else{
				br.setReturnCode(500);
				br.setInfo("订单数据不存在");
			}
			
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("未知错误异常");
			e.printStackTrace();
		}
		
		return br;
	}

	//保存订单
	private int saveOrder(OrderSendEntity ose) throws Exception {
		TbOrder tbOrder = new TbOrder();
		tbOrder.setFid(ose.getBid());
		
		tbOrder.setOrderType("BOS");
		tbOrder.setOutOrderSn(ose.getBizOrderSn());
		tbOrder.setStoreName(ose.getShop());
		
		tbOrder.setCheckstatus(new BigDecimal(5));
		tbOrder.setOutStatus("待发货");
		tbOrder.setDdDate(new Date());
		tbOrder.setMemberId(ose.getSellerId());
		tbOrder.setShipName(ose.getReciver());
		tbOrder.setShipMobile(ose.getReciverPhone());
		tbOrder.setShipAddress(ose.getReciverAddress());
		
		tbOrder.setTotalProductPrice(new BigDecimal(0));
		tbOrder.setDeleteFlag(new BigDecimal(0));
		tbOrder.setStoresInvoiceName(ose.getSeller());
		tbOrder.setStoresWorkerName("居然之家售后服务销区");
		tbOrder.setMemo2(ose.getRemark());
		//tbOrder.setWorkOrderId("0");
		tbOrder.setPushTime(new Date());
		int order = this.saveOrder(tbOrder);
		return order;
	}

	@Override
	public BaseResponse getWorkOrderStatus(int status) throws Exception {
		BaseResponse br = new BaseResponse();
		try {
			List<OrderStatusBean> list = tbWorkOrderMapperCustom.getWorkOrderStatus(status);
			if(list!=null && list.size()>0){
				br.setReturnCode(200);
				br.setInfo("获取状态成功");
				br.setData(list);
			}else{
				br.setReturnCode(404);
				br.setInfo("无记录");
			}
		} catch (Exception e) {
			br.setReturnCode(500);
			br.setInfo("获取数据异常");
		}
		return br;
	}

}

package com.easyhome.po.wechat;

public class OrderListRequestBean {
	
	private String orderListType;//列表类型
    
    private String openId;//用户绑定ID
    
    private String externalOrderNo;//订单号（搜索功能）
    
    private String goodsName;//商品名称
    
    private String pageIndex;
    
    private String pageSize;
    
	public String getOrderListType() {
		return orderListType;
	}

	public void setOrderListType(String orderListType) {
		this.orderListType = orderListType;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getExternalOrderNo() {
		return externalOrderNo;
	}

	public void setExternalOrderNo(String externalOrderNo) {
		this.externalOrderNo = externalOrderNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

}

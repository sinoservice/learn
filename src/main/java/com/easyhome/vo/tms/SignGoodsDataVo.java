package com.easyhome.vo.tms;

import java.io.Serializable;

/**
 * 
* @ClassName: SignGoodsDataVo 
* @Description: TODO  订单签收商品情况实体类
* @date 2016年11月17日 下午2:26:06 
*
 */
public class SignGoodsDataVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月17日 下午2:26:00 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String lineId;// 主键ID
	private String ItemName;//商品名称
	private String itemCode;// 商品编码
	private String signQty;// 实际签收数量
	private String stockOutQty;// 货物短少(无，则传0)
	private String packageDamagedQty;// 包装破损(无，则传0)
	private String mildewPolluteQty;// 霉变污染(无，则传0)
	private String goodsDamagedQty;// 货物破损(无，则传0)
	private String goodsFleeingQty;// 串货(无，则传0)
	private String otherAbnormalQty;// 其他异常数量(无，则传0)
	private String remark;// 备注
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getSignQty() {
		return signQty;
	}
	public void setSignQty(String signQty) {
		this.signQty = signQty;
	}
	public String getStockOutQty() {
		return stockOutQty;
	}
	public void setStockOutQty(String stockOutQty) {
		this.stockOutQty = stockOutQty;
	}
	public String getPackageDamagedQty() {
		return packageDamagedQty;
	}
	public void setPackageDamagedQty(String packageDamagedQty) {
		this.packageDamagedQty = packageDamagedQty;
	}
	public String getMildewPolluteQty() {
		return mildewPolluteQty;
	}
	public void setMildewPolluteQty(String mildewPolluteQty) {
		this.mildewPolluteQty = mildewPolluteQty;
	}
	public String getGoodsDamagedQty() {
		return goodsDamagedQty;
	}
	public void setGoodsDamagedQty(String goodsDamagedQty) {
		this.goodsDamagedQty = goodsDamagedQty;
	}
	public String getGoodsFleeingQty() {
		return goodsFleeingQty;
	}
	public void setGoodsFleeingQty(String goodsFleeingQty) {
		this.goodsFleeingQty = goodsFleeingQty;
	}
	public String getOtherAbnormalQty() {
		return otherAbnormalQty;
	}
	public void setOtherAbnormalQty(String otherAbnormalQty) {
		this.otherAbnormalQty = otherAbnormalQty;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}

}

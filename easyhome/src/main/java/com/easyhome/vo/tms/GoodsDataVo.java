package com.easyhome.vo.tms;

import java.io.Serializable;

/**
 * 
* @ClassName: GoodsDataVo 
* @Description: TODO  商品信息实体类
* @date 2016年11月18日 上午9:32:17 
*
 */
public class GoodsDataVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 上午9:32:11 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private String lineId;// 商品ID
	private String lineNo;// 商品行号
	private String itemCode;// 商品编码
	private String ItemName;// 商品名称
	private String itemTypeCode;// 品类代码
	private String itemTypeName;// 品类名称
	private String packageName;// 包装规格
	private String quantity;// 数量
	private String weight;// 重量
	private String volume;// 体积
	private String subStr1;// 备用字段1
	private String subStr2;// 备用字段1
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getLineNo() {
		return lineNo;
	}
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemTypeCode() {
		return itemTypeCode;
	}
	public void setItemTypeCode(String itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getSubStr1() {
		return subStr1;
	}
	public void setSubStr1(String subStr1) {
		this.subStr1 = subStr1;
	}
	public String getSubStr2() {
		return subStr2;
	}
	public void setSubStr2(String subStr2) {
		this.subStr2 = subStr2;
	}

}

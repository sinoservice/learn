package com.easyhome.vo;

/**
 * 
 * <p> Title: Goods</p>
 * <p> Description: 商品</p>
 * 
 * @date 2016年6月23日 下午5:17:07
 * @version 1.0
 *
 */
public class Goods{

	public String GOOD_NO;
	public String GOOD_LINEID;
	public String ITEM_AMOUNT;
	public String ACTUAL_AMOUNT;
	public String IS_COMPLETEED;
	public String UNCOM_REASON;
	public String REMARK;
	
	@Override
	public String toString() {
		return "Goods [GOOD_NO=" + GOOD_NO + ", GOOD_LINEID=" + GOOD_LINEID + ", ITEM_AMOUNT=" + ITEM_AMOUNT
				+ ", ACTUAL_AMOUNT=" + ACTUAL_AMOUNT + ", IS_COMPLETEED=" + IS_COMPLETEED + ", UNCOM_REASON="
				+ UNCOM_REASON + ", REMARK=" + REMARK + "]";
	}
	
	
}

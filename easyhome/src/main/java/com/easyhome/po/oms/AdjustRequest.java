package com.easyhome.po.oms;
/**
 * 
* @ClassName: AdjustRequest 
* @Description: TODO 天猫费用调整单实体类
* @date 2016年9月1日 下午3:50:46 
*
 */
public class AdjustRequest {
    private String masterId;	//技师编码
    private String ethcId;      //调整单号
    private String orderNo;	    //派工单号
    private String code;	    //调整单服务类型
    private String remark;	    //调整说明
    private String list;		//图片，以“|”分割
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getEthcId() {
		return ethcId;
	}
	public void setEthcId(String ethcId) {
		this.ethcId = ethcId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
}

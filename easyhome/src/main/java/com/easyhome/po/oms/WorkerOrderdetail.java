package com.easyhome.po.oms;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerOrderdetail {
	@JsonProperty("FID")
	private String fid;
	@JsonProperty("ITEM_NAME")
    private String itemName;
	@JsonProperty("AMOUNT")
    private double amount;
	@JsonProperty("TIMES")
    private double times;
	@JsonProperty("REQUIREMENT")
    private String requirement;
	@JsonProperty("REMARK")
    private String remark;
	@JsonProperty("ADDRESS")
    private double addPrice;
	@JsonProperty("INSTALL_PRICE")
    private double installPrice;
	@JsonProperty("WORK_ORDER_ID")
    private String workOrderId;
	@JsonProperty("ITEM_AMOUNT")
    private double itemAmount;
	@JsonProperty("GOODS_NO")
    private String goodsNo;
	@JsonProperty("GOODS_NAME")
    private String goodsName;
	@JsonProperty("GOODS_SIZE")
    private String goodsSize;
	@JsonProperty("UNIT")
    private String unit;
	@JsonProperty("QUANTITY")
    private double quantity;
	@JsonProperty("PRICE")
    private double price;
	@JsonProperty("HANDLE_TOTAL")
    private double handleTotal;
	@JsonProperty("RECEIVABLES_OLD_FEE")
    private double receivablesOldFee;
	@JsonProperty("RECEIVABLES_INSTALL_FEE")
    private double receivablesInstallFee;
	@JsonProperty("RECEIVABLES_REMOTE_FEE")
    private double receivablesRemoteFee;
	@JsonProperty("RECEIVABLES_SMALL_FEE")
    private double receivablesSmallFee;
	@JsonProperty("RECEIVABLES_SECOND_FEE")
    private double receivablesSecondFee;
	@JsonProperty("RECEIVABLES_TOTAL")
    private double receivablesTotal;
	@JsonProperty("HANDLE_OLD_FEE")
    private double handleOldFee;
	@JsonProperty("HANDLE_INSTALL_FEE")
    private double handleInstallFee;
	@JsonProperty("HANDLE_REMOTE_FEE")
    private double handleRemoteFee;
	@JsonProperty("HANDLE_SMALL_FEE")
    private double handleSmallFee;
	@JsonProperty("HANDLE_SECOND_FEE")
    private double handleSecondFee;
	@JsonProperty("BRAND_NAME")
    private String brandName;
	@JsonProperty("GOODS_IMAGE")
    private String goodsImage;
	@JsonProperty("RECEIVABLES_TREIGHT")
    private double receivablesFreight;
	@JsonProperty("HANDLE_FREIGHT")
    private double handleFreight;
	@JsonProperty("OMS_ID")
    private String omsId;
	@JsonProperty("CANCEL_REASON")
	private String cancelReason;
	@JsonProperty("CANCEL_PERSON")
	private String cancelPerson;
	@JsonProperty("CANCEL_TIME")
	private Date cancelTime;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTimes() {
        return times;
    }

    public void setTimes(double times) {
        this.times = times;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public double getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(double addPrice) {
        this.addPrice = addPrice;
    }

    public double getInstallPrice() {
        return installPrice;
    }

    public void setInstallPrice(double installPrice) {
        this.installPrice = installPrice;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId == null ? null : workOrderId.trim();
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize == null ? null : goodsSize.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHandleTotal() {
        return handleTotal;
    }

    public void setHandleTotal(double handleTotal) {
        this.handleTotal = handleTotal;
    }

    public double getReceivablesOldFee() {
        return receivablesOldFee;
    }

    public void setReceivablesOldFee(double receivablesOldFee) {
        this.receivablesOldFee = receivablesOldFee;
    }

    public double getReceivablesInstallFee() {
        return receivablesInstallFee;
    }

    public void setReceivablesInstallFee(double receivablesInstallFee) {
        this.receivablesInstallFee = receivablesInstallFee;
    }

    public double getReceivablesRemoteFee() {
        return receivablesRemoteFee;
    }

    public void setReceivablesRemoteFee(double receivablesRemoteFee) {
        this.receivablesRemoteFee = receivablesRemoteFee;
    }

    public double getReceivablesSmallFee() {
        return receivablesSmallFee;
    }

    public void setReceivablesSmallFee(double receivablesSmallFee) {
        this.receivablesSmallFee = receivablesSmallFee;
    }

    public double getReceivablesSecondFee() {
        return receivablesSecondFee;
    }

    public void setReceivablesSecondFee(double receivablesSecondFee) {
        this.receivablesSecondFee = receivablesSecondFee;
    }

    public double getReceivablesTotal() {
        return receivablesTotal;
    }

    public void setReceivablesTotal(double receivablesTotal) {
        this.receivablesTotal = receivablesTotal;
    }

    public double getHandleOldFee() {
        return handleOldFee;
    }

    public void setHandleOldFee(double handleOldFee) {
        this.handleOldFee = handleOldFee;
    }

    public double getHandleInstallFee() {
        return handleInstallFee;
    }

    public void setHandleInstallFee(double handleInstallFee) {
        this.handleInstallFee = handleInstallFee;
    }

    public double getHandleRemoteFee() {
        return handleRemoteFee;
    }

    public void setHandleRemoteFee(double handleRemoteFee) {
        this.handleRemoteFee = handleRemoteFee;
    }

    public double getHandleSmallFee() {
        return handleSmallFee;
    }

    public void setHandleSmallFee(double handleSmallFee) {
        this.handleSmallFee = handleSmallFee;
    }

    public double getHandleSecondFee() {
        return handleSecondFee;
    }

    public void setHandleSecondFee(double handleSecondFee) {
        this.handleSecondFee = handleSecondFee;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public double getReceivablesFreight() {
        return receivablesFreight;
    }

    public void setReceivablesFreight(double receivablesFreight) {
        this.receivablesFreight = receivablesFreight;
    }

    public double getHandleFreight() {
        return handleFreight;
    }

    public void setHandleFreight(double handleFreight) {
        this.handleFreight = handleFreight;
    }

    public String getOmsId() {
        return omsId;
    }

    public void setOmsId(String omsId) {
        this.omsId = omsId == null ? null : omsId.trim();
    }

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelPerson() {
		return cancelPerson;
	}

	public void setCancelPerson(String cancelPerson) {
		this.cancelPerson = cancelPerson;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
    
}

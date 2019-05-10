package com.easyhome.vo.bos;

public class ObOrderDetail {
    private String bid;

    private String orderBid;

    private Integer sn;

    private String bizGoodsSn;

    private String type01;

    private String type02;

    private String type03;

    private String brand;

    private String length;

    private String height;

    private Double servicePrice;

    private Integer amount;

    private Double total;

    private Double payable;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getOrderBid() {
        return orderBid;
    }

    public void setOrderBid(String orderBid) {
        this.orderBid = orderBid == null ? null : orderBid.trim();
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getBizGoodsSn() {
        return bizGoodsSn;
    }

    public void setBizGoodsSn(String bizGoodsSn) {
        this.bizGoodsSn = bizGoodsSn == null ? null : bizGoodsSn.trim();
    }

    public String getType01() {
        return type01;
    }

    public void setType01(String type01) {
        this.type01 = type01 == null ? null : type01.trim();
    }

    public String getType02() {
        return type02;
    }

    public void setType02(String type02) {
        this.type02 = type02 == null ? null : type02.trim();
    }

    public String getType03() {
        return type03;
    }

    public void setType03(String type03) {
        this.type03 = type03 == null ? null : type03.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPayable() {
        return payable;
    }

    public void setPayable(Double payable) {
        this.payable = payable;
    }
}
package com.easyhome.po;

public class OrderDateQueryBean {
    private String id;
    private String workNo;

    private String sendDate;

    private String amount;

    private String orderSn;

    private String itemCount;

    private String cusName;

    private String cusPhone;


    private String cusAddress;

    private String completeDate;


    private String bookingTime;

 
    private String statusDisplay;

    private String viewTime;

    private int rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatusDisplay() {
        return statusDisplay;
    }

    public void setStatusDisplay(String statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "OrderDateQueryList [id=" + id + ", workNo=" + workNo + ", sendDate=" + sendDate + ", amount=" + amount
                + ", orderSn=" + orderSn + ", itemCount=" + itemCount + ", cusName=" + cusName + ", cusPhone="
                + cusPhone + ", cusAddress=" + cusAddress + ", completeDate=" + completeDate + ", bookingTime="
                + bookingTime + ", statusDisplay=" + statusDisplay + ", viewTime=" + viewTime + ", rate=" + rate + "]";
    }

    public OrderDateQueryBean(String id, String workNo, String sendDate, String amount, String orderSn,
            String itemCount, String cusName, String cusPhone, String cusAddress, String completeDate,
            String bookingTime, String statusDisplay, String viewTime, int rate) {
        super();
        this.id = id;
        this.workNo = workNo;
        this.sendDate = sendDate;
        this.amount = amount;
        this.orderSn = orderSn;
        this.itemCount = itemCount;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.completeDate = completeDate;
        this.bookingTime = bookingTime;
        this.statusDisplay = statusDisplay;
        this.viewTime = viewTime;
        this.rate = rate;
    }

    public OrderDateQueryBean() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
}

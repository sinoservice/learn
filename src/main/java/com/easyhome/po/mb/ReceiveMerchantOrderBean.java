 package com.easyhome.po.mb;

public class ReceiveMerchantOrderBean {
    //物理表主键
    private int id;
    
    //业务主键
    private String businessKey;
    
    //商家类型  1.美标
    private String merchantType;

    //商家报文
    private String textContent;
    
    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    //操作状态 1.初始化；2.锁定 ；3.成功；4.失败
    private int operateStatus;
    
    //创建时间
    private String createTime;
    
    //创建人
    private String creator;
    

    //修改时间
    private String modifyTime;
    
    //修改人
    private String modifier;
    
    //订单状态 :0:正常,1:禁用
    private int yn;
    
    private String token;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public int getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(int operateStatus) {
        this.operateStatus = operateStatus;
    }

    /*public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }*/



    public String getModifier() {
        return modifier;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }
}

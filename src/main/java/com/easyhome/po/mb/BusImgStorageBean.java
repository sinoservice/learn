package com.easyhome.po.mb;

import java.io.Serializable;

/**
 * 
* @ClassName: BusImgStorageBean 
* @Description: TODO  商家图片存储实体类
* @date 2016年11月18日 上午11:54:15 
*
 */
public class BusImgStorageBean implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月18日 上午11:32:18 
	*/ 
	
	private static final long serialVersionUID = 1L;

	private int id;// 物理主键
	private String busId;//业务主键
	private String imgUrl;//图片路径
	private String createTime;//创建时间
	private String createUser;//创建人
	private String modifyTime;//修改时间
	private String modifyUser;//修改人
	private int yn;//是否启用
	private int busType;//商家类型
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBusId() {
		return busId;
	}
	public void setBusId(String busId) {
		this.busId = busId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public int getYn() {
		return yn;
	}
	public void setYn(int yn) {
		this.yn = yn;
	}
	public int getBusType() {
		return busType;
	}
	public void setBusType(int busType) {
		this.busType = busType;
	}
}

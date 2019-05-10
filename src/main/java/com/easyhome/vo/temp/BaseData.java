package com.easyhome.vo.temp;

/**
 * 
 * <p> Title: BaseData</p>
 * <p> Description: 基础数据临时类</p>
 * 
 * @date 2016年6月17日 下午8:35:04
 * @version 1.0
 *
 */
public class BaseData {
	
	private String CategoryCode;
	private String CategoryId;
	private String Code;
	private String FID;
	private String ParentId;
	private String Sortnum;
	private String Status;
	private String Title;
	public String getCategoryCode() {
		return CategoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		CategoryCode = categoryCode;
	}
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getFID() {
		return FID;
	}
	public void setFID(String fID) {
		FID = fID;
	}
	public String getParentId() {
		return ParentId;
	}
	public void setParentId(String parentId) {
		ParentId = parentId;
	}
	public String getSortnum() {
		return Sortnum;
	}
	public void setSortnum(String sortnum) {
		Sortnum = sortnum;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
}

package com.easyhome.po.oms;

public class WorkorPopupRequest {
	
	private String CategoryCode;
	
	private String CategoryId;
	
	private String code;
	
	private String FID;
	
	private String  ParentId;
	
	private String Sortnum;
	
	private Integer Status;
	
	private String Title;
	
	private String children;
	
	
	
	
	@Override
	public String toString() {
		return "WorkorPopup [CategoryCode=" + CategoryCode + ", CategoryId=" + CategoryId + ", code=" + code + ", FID="
				+ FID + ", ParentId=" + ParentId + ", Sortnum=" + Sortnum + ", Status=" + Status + ", Title=" + Title
				+ ", children=" + children + "]";
	}




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
		return code;
	}




	public void setCode(String code) {
		this.code = code;
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




	public Integer getStatus() {
		return Status;
	}




	public void setStatus(Integer status) {
		Status = status;
	}




	public String getTitle() {
		return Title;
	}




	public void setTitle(String title) {
		Title = title;
	}




	public String getChildren() {
		return children;
	}




	public void setChildren(String children) {
		this.children = children;
	}




	public WorkorPopupRequest() {
		// TODO Auto-generated constructor stub
	}

}

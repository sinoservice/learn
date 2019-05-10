package com.easyhome.po;
/**
 * 
* @ClassName: Version 
* @Description: TODO App版本发布实体类
* @date 2017年5月26日 下午4:33:54 
*
 */
public class Version {


	private String appVersion;//app版本
	private String url;//下载路径
	private String notice;//公告
	private int flag;//技师App：1普通，2灰度 ；服务商App：3普通，4灰度
	private int isUpdate;//是否强制升级
	
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	
}

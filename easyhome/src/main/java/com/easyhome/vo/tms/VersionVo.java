package com.easyhome.vo.tms;

import java.io.Serializable;

/**
 * 
 * <p>标题: VersionVo</p>
 * <p>描述: APP版本信息</p>
 * <p>公司：<a href="www.juran.com.cn">北京居然之家投资控股集团有限公司</a></p>
 * <p>创建时间: 2016年11月10日 下午3:48:43</p>
 * <p>版本: 1.0</p>
 */
public class VersionVo implements Serializable{
	
	private static final long serialVersionUID = -3689796509623875804L;

	/**
	 * 最新版本号
	 */
	private String versionNo;
	
	/**
	 * 版本名称
	 */
	private String versionName;
	
	/**
	 * 版本说明
	 */
	private String versionDescription;

	/**
	 * 
	 * 下载路径
	 */
	private String downLoadUrl;
	
	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionDescription() {
		return versionDescription;
	}

	public void setVersionDescription(String versionDescription) {
		this.versionDescription = versionDescription;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public VersionVo(String versionNo, String versionName, String versionDescription,String downLoadUrl) {
		super();
		this.versionNo = versionNo;
		this.versionName = versionName;
		this.versionDescription = versionDescription;
		this.downLoadUrl = downLoadUrl;
	}

	public String getDownLoadUrl() {
		return downLoadUrl;
	}

	public void setDownLoadUrl(String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
	}

}

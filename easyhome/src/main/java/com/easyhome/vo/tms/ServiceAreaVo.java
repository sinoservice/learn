package com.easyhome.vo.tms;

import java.io.Serializable;
/**
 * 
* @ClassName: ServiceAreaVo 
* @Description: TODO 服务区域实体类
* @date 2016年11月16日 下午4:01:31 
*
 */
public class ServiceAreaVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	* @date 2016年11月16日 下午3:57:19 
	*/ 
	
	private static final long serialVersionUID = 1L;
	
	private String serviceAreaCode;// 司机服务区域代码
	private String serviceAreaName;// 司机服务区域名称
	private String provinceCode;// 司机服务区域省份代码
	private String provinceName;// 司机服务区域省份名称
	private String cityCode	;// 司机服务区域城市代码
	private String cityName	;// 司机服务区域城市名称
	private String countyCode;// 司机服务区域区县代码
	private String countyName;// 司机服务区域区县名称
	private String townCode;// 司机服务区域城镇代码
	private String townName;// 司机服务区域城镇名称
	private String regionCode;// 司机服务区域自定义区域代码
	private String regionName;// 司机服务区域自定义区域名称
	public String getServiceAreaCode() {
		return serviceAreaCode;
	}
	public void setServiceAreaCode(String serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}
	public String getServiceAreaName() {
		return serviceAreaName;
	}
	public void setServiceAreaName(String serviceAreaName) {
		this.serviceAreaName = serviceAreaName;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getTownCode() {
		return townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}

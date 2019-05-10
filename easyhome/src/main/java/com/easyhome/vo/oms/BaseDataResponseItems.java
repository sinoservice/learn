package com.easyhome.vo.oms;

import java.io.Serializable;

/**
 * 
 * <p> Title: BaseDateResponseItems</p>
 * <p> Description: 基础数据解析明细类</p>
 * 
 * @date 2016年6月27日 下午2:24:37
 * @version 1.0
 *
 */
public class BaseDataResponseItems implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4624246040217618651L;
	public String FID;
    public String code;
    public String categorycode;
    public String remark;
    public String sortnum;
    public String title;
    public String categoryid;
    public String parentid;
    public String status;
}

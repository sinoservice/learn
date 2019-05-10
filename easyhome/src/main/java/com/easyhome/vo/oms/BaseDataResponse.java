package com.easyhome.vo.oms;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <p> Title: BaseDateResponse</p>
 * <p> Description: BaseDate响应类</p>
 * 
 * @date 2016年6月27日 下午2:19:58
 * @version 1.0
 *
 */
public class BaseDataResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7108374348363446310L;
	
	public String errCode;
	public String errMsg;
	public List<BaseDataResponseItems> result;

}

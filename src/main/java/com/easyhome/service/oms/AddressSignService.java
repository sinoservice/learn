package com.easyhome.service.oms;

import com.easyhome.po.oms.AddressSignRequest;
import com.easyhome.vo.BaseResponse;

/**
 * 距离位置接口
 * @date 2016 下午5:06:55
 * @version 1.0
 */
public interface AddressSignService {
	public BaseResponse addressSign(AddressSignRequest request);
}

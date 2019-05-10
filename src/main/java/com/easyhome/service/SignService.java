package com.easyhome.service;

import com.easyhome.vo.BaseResponse;

public interface SignService {

	BaseResponse getCoordinate(String address);
}

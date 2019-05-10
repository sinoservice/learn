package com.easyhome.service.oms;

import com.easyhome.vo.CodeResponse;

public interface CodeService {
	CodeResponse findCode(String phone);
}

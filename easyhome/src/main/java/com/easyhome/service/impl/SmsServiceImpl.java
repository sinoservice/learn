package com.easyhome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easyhome.dao.SmsDao;
import com.easyhome.po.Sms;
import com.easyhome.service.SmsService;

@Service("smsService")
public class SmsServiceImpl implements SmsService {
	@Resource
	private SmsDao smsDao;

	public Sms getSmsById(String fid) {
		return smsDao.getSmsById(fid);
	}

}

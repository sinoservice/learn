package com.easyhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.dao.OrderDateQueryDao;

@Controller
@RequestMapping("/test")
public class AA_test {
	
	@Autowired
	private OrderDateQueryDao orderDateQueryDao;
	
	@RequestMapping("/find")
	@ResponseBody
	public String find(String orderNo){
		return orderDateQueryDao.find()+"";
	}
	
}

package com.easyhome.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyhome.po.TbReminder;
import com.easyhome.po.TbVoiceReply;
import com.easyhome.service.ReminderService;


/**
 * 
 * <p> Title: ReminderController</p>
 * <p> Description: 工单提醒接口</p>
 * 
 * @date 2016年6月8日 下午7:54:53
 * @version 1.0
 *
 */
@Controller
@RequestMapping(value="/reminder")
public class ReminderController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -853141882974420474L;
	
	Log log = LogFactory.getLog(ReminderController.class);
	
	@Autowired
	private ReminderService reminderService;
	
	/**
	 * 
	 * <p> Description: 保存语音提醒记录</p>
	 * 
	 * @date 2016年6月8日 下午8:05:23
	 * @version 1.0
	 * @param reminder
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveReminder")
	@ResponseBody
	public int saveReminder(TbReminder reminder) throws Exception{
		log.info(reminder);
		log.info(reminder.getFid());
		log.info(reminder.getCusName());
		log.info(reminder.getMasterPhone());
		log.info(reminder.getStatus());
		log.info(reminder.getWorkNo());
		reminder.setFid(reminder.getFid()==null || "".equals(reminder.getFid()) ?  UUID.randomUUID().toString():reminder.getFid());
		reminder.setReminderTime(new Date());
		int i = reminderService.insertReminder(reminder);
		return i;
	}

	/**
	 * 
	 * <p> Description: 保存语音接听状态</p>
	 * 
	 * @date 2016年6月8日 下午8:06:01
	 * @version 1.0
	 * @param voiceReply
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveVoiceReply")
	@ResponseBody
	public int saveVoiceReply(TbVoiceReply voiceReply) throws Exception{
		log.info(voiceReply);
		voiceReply.setFid(voiceReply.getFid()==null || "".equals(voiceReply.getFid()) ?  UUID.randomUUID().toString():voiceReply.getFid());
		log.info(voiceReply);
		return reminderService.insertVoiceReply(voiceReply);
	}
}

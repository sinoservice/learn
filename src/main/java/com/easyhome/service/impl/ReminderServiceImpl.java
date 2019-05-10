package com.easyhome.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyhome.dao.TbReminderMapper;
import com.easyhome.dao.TbVoiceReplyMapper;
import com.easyhome.po.TbReminder;
import com.easyhome.po.TbVoiceReply;
import com.easyhome.service.ReminderService;

/**
 * 
 * <p> Title: ReminderServiceImpl</p>
 * <p> Description: 工单提醒服务类</p>
 * 
 * @date 2016年6月8日 下午8:43:18
 * @version 1.0
 *
 */
@Service("reminderService")
public class ReminderServiceImpl implements ReminderService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7772336051369400881L;
	
	Log log = LogFactory.getLog(ReminderServiceImpl.class);
	
	@Autowired
	private TbReminderMapper tbReminderMapper;
	
	@Autowired
	private TbVoiceReplyMapper tbVoiceReplyMapper;

	@Override
	public int insertReminder(TbReminder reminder) throws Exception {
		try {
			int insert = tbReminderMapper.insert(reminder);
			if(insert>0){
				log.info("保存reminder成功");
				return 0;
			}else{
				log.info("保存reminder失败");
				return -1;
			}
		} catch (Exception e) {
			log.info("保存reminder失败",e);
			return -1;
		}
	}

	@Override
	public int insertVoiceReply(TbVoiceReply voiceReply) throws Exception {
		try {
			int insert = tbVoiceReplyMapper.insert(voiceReply);
			if(insert>0){
				log.info("保存voiceReply成功");
				return 0;
			}else{
				log.info("保存voiceReply失败");
				return -1;
			}
		} catch (Exception e) {
			log.info("保存voiceReply失败",e);
			return -1;
		}
	}

}

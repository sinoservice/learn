package com.easyhome.service;

import java.io.Serializable;

import com.easyhome.po.TbReminder;
import com.easyhome.po.TbVoiceReply;

/**
 * 
 * <p> Title: ReminderService</p>
 * <p> Description: 工单提醒接口</p>
 * 
 * @date 2016年6月8日 下午7:39:29
 * @version 1.0
 *
 */
public interface ReminderService extends Serializable{

	/**
	 * 
	 * <p> Description: 保存工单提醒</p>
	 * 
	 * @date 2016年6月8日 下午7:40:40
	 * @version 1.0
	 * @param reminder
	 * @return
	 * @throws Exception
	 */
	public int insertReminder(TbReminder reminder) throws Exception;
	
	/**
	 * 
	 * <p> Description: 保存工单状态</p>
	 * 
	 * @date 2016年6月8日 下午7:41:42
	 * @version 1.0
	 * @param voiceReply
	 * @return
	 */
	public int insertVoiceReply(TbVoiceReply voiceReply) throws Exception;
}

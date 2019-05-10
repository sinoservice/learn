package dao.mapper;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easyhome.dao.TbReminderMapper;
import com.easyhome.dao.TbVoiceReplyMapper;
import com.easyhome.po.TbReminder;
import com.easyhome.po.TbVoiceReply;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class TbReminderTest {

	@Autowired
	private TbReminderMapper tbReminderMapper;
	
	@Autowired
	private TbVoiceReplyMapper tbVoiceReplyMapper;
	
	@Test
	public void testInsertReminder() throws Exception {
		TbReminder record = new TbReminder();
		record.setFid(UUID.randomUUID().toString());
		record.setBizId("100001000^22223232");
		record.setCusName("MrDuan");
		record.setMasterPhone("13502074166");
		record.setReminderTime(new Date());
		record.setStatus(0l);
		record.setWorkNo("AZ106100007");
		int insert = tbReminderMapper.insert(record);
		System.out.println(insert);
	}
	
	@Test
	public void testInsertVoiceReply() throws Exception {
		TbVoiceReply record = new TbVoiceReply();
		record.setBizId("100001000^22223232");
		record.setDuration(30l);
		record.setEndTime("2016-06-08 12:12:12");
		record.setFid(UUID.randomUUID().toString());
		record.setStartTime("2016-06-08 12:12:00");
		record.setStatus(0l);
		record.setStatusCode("0");
		record.setStatusMsg("");
		
		int insert = tbVoiceReplyMapper.insert(record);
		System.out.println(insert);
	}
}

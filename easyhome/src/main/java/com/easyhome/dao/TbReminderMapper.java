package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbReminder;
import com.easyhome.po.TbReminderExample;

public interface TbReminderMapper {
    int countByExample(TbReminderExample example);

    int deleteByExample(TbReminderExample example);

    int deleteByPrimaryKey(String fid);

    int insert(TbReminder record);

    int insertSelective(TbReminder record);

    List<TbReminder> selectByExample(TbReminderExample example);

    TbReminder selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") TbReminder record, @Param("example") TbReminderExample example);

    int updateByExample(@Param("record") TbReminder record, @Param("example") TbReminderExample example);

    int updateByPrimaryKeySelective(TbReminder record);

    int updateByPrimaryKey(TbReminder record);
}
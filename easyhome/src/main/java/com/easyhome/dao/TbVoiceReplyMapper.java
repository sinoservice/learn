package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbVoiceReply;
import com.easyhome.po.TbVoiceReplyExample;

public interface TbVoiceReplyMapper {
    int countByExample(TbVoiceReplyExample example);

    int deleteByExample(TbVoiceReplyExample example);

    int deleteByPrimaryKey(String fid);

    int insert(TbVoiceReply record);

    int insertSelective(TbVoiceReply record);

    List<TbVoiceReply> selectByExample(TbVoiceReplyExample example);

    TbVoiceReply selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") TbVoiceReply record, @Param("example") TbVoiceReplyExample example);

    int updateByExample(@Param("record") TbVoiceReply record, @Param("example") TbVoiceReplyExample example);

    int updateByPrimaryKeySelective(TbVoiceReply record);

    int updateByPrimaryKey(TbVoiceReply record);
}
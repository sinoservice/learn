package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbAppUser;
import com.easyhome.po.TbAppUserExample;

public interface TbAppUserMapper {
    int countByExample(TbAppUserExample example);

    int deleteByExample(TbAppUserExample example);

    int insert(TbAppUser record);

    int insertSelective(TbAppUser record);

    List<TbAppUser> selectByExample(TbAppUserExample example);

    int updateByExampleSelective(@Param("record") TbAppUser record, @Param("example") TbAppUserExample example);

    int updateByExample(@Param("record") TbAppUser record, @Param("example") TbAppUserExample example);
}
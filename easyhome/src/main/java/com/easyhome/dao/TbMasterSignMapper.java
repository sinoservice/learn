package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbMasterSign;
import com.easyhome.po.TbMasterSignExample;

public interface TbMasterSignMapper {
    int countByExample(TbMasterSignExample example);

    int deleteByExample(TbMasterSignExample example);

    int insert(TbMasterSign record);

    int insertSelective(TbMasterSign record);

    List<TbMasterSign> selectByExample(TbMasterSignExample example);

    int updateByExampleSelective(@Param("record") TbMasterSign record, @Param("example") TbMasterSignExample example);

    int updateByExample(@Param("record") TbMasterSign record, @Param("example") TbMasterSignExample example);
}
package com.easyhome.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.easyhome.po.TbMaster;
import com.easyhome.po.TbMasterExample;

public interface TbMasterMapper {
    int countByExample(TbMasterExample example);

    int deleteByExample(TbMasterExample example);

    int insert(TbMaster record);

    int insertSelective(TbMaster record);

    List<TbMaster> selectByExample(TbMasterExample example);

    int updateByExampleSelective(@Param("record") TbMaster record, @Param("example") TbMasterExample example);

    int updateByExample(@Param("record") TbMaster record, @Param("example") TbMasterExample example);
}
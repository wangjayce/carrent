package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Inport;

public interface InportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inport record);

    int insertSelective(Inport record);

    Inport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inport record);

    int updateByPrimaryKey(Inport record);
    
    /**
      * 查询所有进货单
     * @param record
     * @return
     */
    List<Inport> queryAllInport(Inport record);
}
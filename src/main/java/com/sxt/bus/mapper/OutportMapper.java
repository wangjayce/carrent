package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Outport;

public interface OutportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Outport record);

    int insertSelective(Outport record);

    Outport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Outport record);

    int updateByPrimaryKey(Outport record);
    
    /**
     * 查询所有退货单
    * @param record
    * @return
    */
   List<Outport> queryAllOutport(Outport record);
}
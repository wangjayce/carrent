package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.vo.LeavebillVo;

public interface LeavebillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leavebill record);

    int insertSelective(Leavebill record);

    Leavebill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leavebill record);

    int updateByPrimaryKey(Leavebill record);
    
    /**
     * 查询所有请假单
     */
    List<Leavebill> queryAllLeavebill(LeavebillVo leavebillVo);
}
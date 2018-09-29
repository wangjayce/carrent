package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    /**
     * 查询所有商品
     * @param record
     * @return
     */
    List<Goods> queryAllGoods(Goods record);

    /**
     * 根据供应商id查询所有商品
     * @param providerid
     * @return
     */
    List<Goods> queryGoodsByPid(Integer providerid);
}
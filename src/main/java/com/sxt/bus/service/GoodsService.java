package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.sys.utils.DataGrid;

public interface GoodsService {

	/**
	 * 查询所有商品树节点提供数据
	 * @param goodsVo
	 * @return
	 */
	List<Goods> queryGoodsTree(GoodsVo goodsVo);
	
	/**
	 * 表格数据查询所有商品
	 * @param goodsVo
	 * @return
	 */
	DataGrid queryAllGoods(GoodsVo goodsVo);
	
	/**
	 * 添加商品
	 * @param record
	 * @return
	 */
	int insert(Goods record);
	
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询商品
	 */
	Goods queryGoodsById(Integer id);
	
	/**
	 * 修改商品
	 */
	int updateGoods(Goods goods);

	List<Goods> queryGoodsByPid(GoodsVo goodsVo);
}

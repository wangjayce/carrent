package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.sys.utils.DataGrid;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public DataGrid queryAllGoods(GoodsVo goodsVo) {
		Page<Object> page = PageHelper.startPage(goodsVo.getPage(), goodsVo.getLimit());
		List<Goods> data = goodsMapper.queryAllGoods(goodsVo);
		return new DataGrid(page.getTotal(), data);
		
		
	}

	@Override
	public List<Goods> queryGoodsTree(GoodsVo goodsVo) {
		
		return goodsMapper.queryAllGoods(goodsVo);
	}

	@Override
	public int insert(Goods record) {
		return goodsMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = goodsMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Goods queryGoodsById(Integer id) {
		return goodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateGoods(Goods goods) {
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public List<Goods> queryGoodsByPid(GoodsVo goodsVo) {
		return goodsMapper.queryGoodsByPid(goodsVo.getProviderid());
	}

}

package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Outport;
import com.sxt.bus.mapper.OutportMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.OutportService;
import com.sxt.bus.vo.OutportVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.utils.DataGrid;

@Service
public class OutportServiceImpl implements OutportService {

	@Autowired
	private OutportMapper outportMapper;
	@Autowired
	private GoodsService goodsService;
	
	@Override
	public DataGrid queryAllOutport(OutportVo outportVo) {
		Page<Object> page = PageHelper.startPage(outportVo.getPage(), outportVo.getLimit());
		List<Outport> data = outportMapper.queryAllOutport(outportVo);
		return new DataGrid(page.getTotal(), data);
	}

	@Override
	public List<Outport> queryOutportTree(OutportVo outportVo) {
		return outportMapper.queryAllOutport(outportVo);
	}

	@Override
	public int insert(Outport outport) {
		Goods goods = goodsService.queryGoodsById(outport.getGoodsid());
		if(goods.getNumber()-outport.getNumber()<0) {
			return SYS_Constast.LOW_STOCKS;
		}
		goods.setNumber(goods.getNumber()-outport.getNumber());
		goodsService.updateGoods(goods);
		return outportMapper.insert(outport);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = outportMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Outport queryOutportById(Integer id) {
		return outportMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateOutport(Outport outport) {
		Outport outport2 = this.queryOutportById(outport.getId());
		Goods goods = goodsService.queryGoodsById(outport.getGoodsid());
		goods.setNumber(goods.getNumber()+outport2.getNumber()-outport.getNumber());
		goodsService.updateGoods(goods);
		return outportMapper.updateByPrimaryKeySelective(outport);
	}


}

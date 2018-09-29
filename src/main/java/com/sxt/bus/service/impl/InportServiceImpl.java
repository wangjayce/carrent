package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Inport;
import com.sxt.bus.mapper.InportMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.InportService;
import com.sxt.bus.vo.InportVo;
import com.sxt.sys.utils.DataGrid;

@Service
public class InportServiceImpl implements InportService {

	@Autowired
	private InportMapper inportMapper;
	@Autowired
	private GoodsService goodsService;
	
	@Override
	public DataGrid queryAllInport(InportVo inportVo) {
		Page<Object> page = PageHelper.startPage(inportVo.getPage(), inportVo.getLimit());
		List<Inport> data = inportMapper.queryAllInport(inportVo);
		return new DataGrid(page.getTotal(), data);
		
		
	}

	@Override
	public List<Inport> queryInportTree(InportVo inportVo) {
		return inportMapper.queryAllInport(inportVo);
	}

	@Override
	public int insert(Inport inprot) {
		Goods goods = goodsService.queryGoodsById(inprot.getGoodsid());
		goods.setNumber(goods.getNumber()+inprot.getNumber());
		goodsService.updateGoods(goods);
		return inportMapper.insert(inprot);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = inportMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Inport queryInportById(Integer id) {
		return inportMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateInport(Inport inport) {
		Inport inport2 = this.queryInportById(inport.getId());
		Goods goods = goodsService.queryGoodsById(inport.getGoodsid());
		goods.setNumber(goods.getNumber()-inport2.getNumber()+inport.getNumber());
		goodsService.updateGoods(goods);
		return inportMapper.updateByPrimaryKeySelective(inport);
	}


}

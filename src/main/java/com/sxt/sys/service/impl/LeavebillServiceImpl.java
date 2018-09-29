package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.mapper.LeavebillMapper;
import com.sxt.sys.service.LeavebillService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LeavebillVo;

@Service
public class LeavebillServiceImpl implements LeavebillService {

	@Autowired
	private LeavebillMapper leavebillMapper;
	
	@Override
	public DataGrid queryAllLeavebill(LeavebillVo leavebillVo) {
		Page<Object> page = PageHelper.startPage(leavebillVo.getPage(), leavebillVo.getLimit());
		List<Leavebill> data = leavebillMapper.queryAllLeavebill(leavebillVo);
		return new DataGrid(page.getTotal(), data);
		
		
	}

	@Override
	public int insert(Leavebill record) {
		return leavebillMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = leavebillMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Leavebill queryLeavebillById(Integer id) {
		return leavebillMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateLeavebill(Leavebill leavebill) {
		return leavebillMapper.updateByPrimaryKeySelective(leavebill);
	}
}

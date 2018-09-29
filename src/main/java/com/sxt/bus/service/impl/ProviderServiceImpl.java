package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.mapper.ProviderMapper;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.utils.DataGrid;

@Service
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderMapper providerMapper;
	
	@Override
	public Provider queryProviderById(Integer id) {
		return providerMapper.selectByPrimaryKey(id);
	}

	@Override
	public DataGrid queryAllProvider(ProviderVo providerVo) {
		Page<Object> page = PageHelper.startPage(providerVo.getPage(), providerVo.getLimit());
		List<Provider> list = providerMapper.queryAllProvider(providerVo);
		return new DataGrid(page.getTotal(), list);
	}

	@Override
	public int insert(ProviderVo providerVo) {
		return providerMapper.insert(providerVo);
	}

	@Override
	public int updateProvider(ProviderVo providerVo) {
		return providerMapper.updateByPrimaryKeySelective(providerVo);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int i = 0 ;
		for (Integer j : id) {
			i = providerMapper.deleteByPrimaryKey(j);
		}
		return i;
	}

	@Override
	public List<Provider> queryAllProviderForList(ProviderVo providerVo) {
		return providerMapper.queryAllProvider(providerVo);
	}

}

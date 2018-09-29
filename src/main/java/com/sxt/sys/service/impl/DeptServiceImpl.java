package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Dept;
import com.sxt.sys.mapper.DeptMapper;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public DataGrid queryAllDept(DeptVo deptVo) {
		Page<Object> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());
		List<Dept> data = deptMapper.queryAllDept(deptVo);
		return new DataGrid(page.getTotal(), data);
		
		
	}

	@Override
	public List<Dept> queryDeptTree(DeptVo deptVo) {
		
		return deptMapper.queryAllDept(deptVo);
	}

	@Override
	public int insert(Dept record) {
		return deptMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = deptMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Dept queryDeptById(Integer id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateDept(Dept dept) {
		return deptMapper.updateByPrimaryKey(dept);
	}

}

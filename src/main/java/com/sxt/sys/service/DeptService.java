package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Dept;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.DeptVo;

public interface DeptService {

	/**
	 * 查询所有部门树节点提供数据
	 * @param deptVo
	 * @return
	 */
	List<Dept> queryDeptTree(DeptVo deptVo);
	
	/**
	 * 表格数据查询所有部门
	 * @param deptVo
	 * @return
	 */
	DataGrid queryAllDept(DeptVo deptVo);
	
	/**
	 * 添加部门
	 * @param record
	 * @return
	 */
	int insert(Dept record);
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询部门
	 */
	Dept queryDeptById(Integer id);
	
	/**
	 * 修改部门
	 */
	int updateDept(Dept dept);
}

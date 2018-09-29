package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LeavebillVo;

public interface LeavebillService {

	
	/**
	 * 表格数据查询所有请假单
	 * @param leavebillVo
	 * @return
	 */
	DataGrid queryAllLeavebill(LeavebillVo leavebillVo);
	
	/**
	 * 添加请假单
	 * @param record
	 * @return
	 */
	int insert(Leavebill record);
	
	/**
	 * 删除请假单
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询请假单
	 */
	Leavebill queryLeavebillById(Integer id);
	
	/**
	 * 修改请假单
	 */
	int updateLeavebill(Leavebill leavebill);
}

package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Outport;
import com.sxt.bus.vo.OutportVo;
import com.sxt.sys.utils.DataGrid;

public interface OutportService {

	/**
	 * 查询所有退货单树节点提供数据
	 * @param outport
	 * @return
	 */
	List<Outport> queryOutportTree(OutportVo outport);
	
	/**
	 * 表格数据查询所有退货单
	 * @param outport
	 * @return
	 */
	DataGrid queryAllOutport(OutportVo outport);
	
	/**
	 * 添加退货单
	 * @param record
	 * @return
	 */
	int insert(Outport record);
	
	/**
	 * 删除退货单
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询退货单
	 */
	Outport queryOutportById(Integer id);
	
	/**
	 * 修改退货单
	 */
	int updateOutport(Outport outport);

}

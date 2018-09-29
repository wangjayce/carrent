package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.vo.InportVo;
import com.sxt.sys.utils.DataGrid;

public interface InportService {

	/**
	 * 查询所有进货单树节点提供数据
	 * @param inportVo
	 * @return
	 */
	List<Inport> queryInportTree(InportVo inportVo);
	
	/**
	 * 表格数据查询所有进货单
	 * @param inportVo
	 * @return
	 */
	DataGrid queryAllInport(InportVo inportVo);
	
	/**
	 * 添加进货单
	 * @param record
	 * @return
	 */
	int insert(Inport record);
	
	/**
	 * 删除进货单
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询进货单
	 */
	Inport queryInportById(Integer id);
	
	/**
	 * 修改进货单
	 */
	int updateInport(Inport inport);

}

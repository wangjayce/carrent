package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.LogInfo;
import com.sxt.sys.mapper.LogInfoMapper;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LogInfoVo;

@Service
public class LogInfoServiceImpl implements LogInfoService{

	@Autowired
	private LogInfoMapper logInfoMapper;
	
	
	@Override
	public DataGrid queryAllLogInfo(LogInfoVo logInfoVo) {
		Page<Object> page = PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
		List<LogInfo> data = logInfoMapper.queryAllLogInfo(logInfoVo);		
		return new DataGrid(page.getTotal(), data);
	}


	@Override
	public int insert(LogInfo record) {
		return logInfoMapper.insert(record);
	}


	@Override
	public int deleteById(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = logInfoMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

}

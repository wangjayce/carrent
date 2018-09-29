package com.sxt.sys.service;

import com.sxt.sys.domain.LogInfo;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LogInfoVo;

public interface LogInfoService {

	  /**
     * 查询所有日志
     */
    DataGrid queryAllLogInfo(LogInfoVo logInfoVo);
    
    int insert(LogInfo record);
    
    int deleteById(Integer... id);
}

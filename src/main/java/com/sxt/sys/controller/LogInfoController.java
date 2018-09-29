package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LogInfoVo;

@Controller
@RequestMapping("logInfo")
public class LogInfoController {

	@Autowired
	private LogInfoService logInfoService;
	
	@RequestMapping("toLogInfoManager")
	public String toLogInfoManager() {
		
		return "system/logInfo/logInfo";
	}
	
	@RequestMapping("uploadAllLogInfo")
	@ResponseBody
	public DataGrid uploadAllLogInfo(LogInfoVo logInfoVo) {
		return logInfoService.queryAllLogInfo(logInfoVo);
	}
	
	@RequestMapping("batchDeleteLogInfo")
	@ResponseBody
	public Map<String, Object> batchDeleteLogInfo(LogInfoVo logInfoVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		try {
			if(null!=logInfoVo.getIds()&&logInfoVo.getIds().length>0) {				
				int i = logInfoService.deleteById(logInfoVo.getIds());
				if(i>0) {
					msg="删除成功";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("deleteLogInfo")
	@ResponseBody
	public Map<String, Object> deleteLogInfo(LogInfoVo logInfoVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		try {			
				int i = logInfoService.deleteById(logInfoVo.getId());
				if(i>0) {
					msg="删除成功";
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
}

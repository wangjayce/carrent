package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Notice;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.NoticeVo;

public interface NoticeService {

	
	/**
	 * 表格数据查询所有公告
	 * @param noticeVo
	 * @return
	 */
	DataGrid queryAllNotice(NoticeVo noticeVo);
	
	
	List<Notice> queryAllNotice();
	
	/**
	 * 添加公告
	 * @param record
	 * @return
	 */
	int insert(Notice record);
	
	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询公告
	 */
	Notice queryNoticeById(Integer id);
	
	/**
	 * 修改公告
	 */
	int updateNotice(Notice notice);
}

package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Notice;
import com.sxt.sys.mapper.NoticeMapper;
import com.sxt.sys.service.NoticeService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.NoticeVo;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public DataGrid queryAllNotice(NoticeVo noticeVo) {
		Page<Object> page = PageHelper.startPage(noticeVo.getPage(), noticeVo.getLimit());
		List<Notice> data = noticeMapper.queryAllNotice(noticeVo);
		return new DataGrid(page.getTotal(), data);
		
		
	}

	@Override
	public int insert(Notice record) {
		return noticeMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = noticeMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Notice queryNoticeById(Integer id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateNotice(Notice notice) {
		return noticeMapper.updateByPrimaryKeySelective(notice);
	}

	@Override
	public List<Notice> queryAllNotice() {
		NoticeVo noticeVo = new NoticeVo();
		return noticeMapper.queryAllNotice(noticeVo);
	}

}

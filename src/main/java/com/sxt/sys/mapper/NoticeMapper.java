package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Notice;
import com.sxt.sys.vo.NoticeVo;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);   
    /**
     * 查询所有公告
     * @param record
     * @return
     */
    List<Notice> queryAllNotice(NoticeVo recordVo);
    
}
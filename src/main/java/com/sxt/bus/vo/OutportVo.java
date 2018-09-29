package com.sxt.bus.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sxt.bus.domain.Outport;
public class OutportVo extends Outport{

	private Integer[] ids;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	
	private Integer page;
	private Integer limit;
	
	
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	

	
	
}

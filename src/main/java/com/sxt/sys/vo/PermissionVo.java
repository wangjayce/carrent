package com.sxt.sys.vo;

import com.sxt.sys.domain.Permission;

public class PermissionVo extends Permission{

private Integer[] ids;
	
	
	
	private Integer page;
	private Integer limit;
	
	
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
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

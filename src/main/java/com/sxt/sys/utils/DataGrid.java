package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

public class DataGrid {

	private Integer code = 0;
	private String msg = "";
	private Long count;
	private List<?> data = new ArrayList<>();
	
	
	public DataGrid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataGrid(Long count, List<?> data) {
		super();
		this.count = count;
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
	
	
	
}

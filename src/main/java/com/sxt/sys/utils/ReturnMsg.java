package com.sxt.sys.utils;

import java.util.HashMap;
import java.util.Map;

public class ReturnMsg {

	private Integer code=0;
	private String msg="";
	private Map<String, Object> data = new HashMap<>();
	
	
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
	public Map<String, Object> getMap() {
		return data;
	}
	public void setMap(Map<String, Object> data) {
		this.data = data;
	}
	public ReturnMsg(Map<String, Object> data) {
		this.data = data;
	}
	public ReturnMsg() {
	}
}

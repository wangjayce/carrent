package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TreeNote {

	/**
	 * 导航菜单树结构
	 */
	
	private Integer id;
    @JsonProperty("pId")
	private Integer pid;
	private String title;
	private String icon;
	private String href;
	private Boolean spread;
	private String target;
	private List<TreeNote> children = new ArrayList<>();
	
	/**
	 * zTee需要的树属性
	 * @return
	 */
	private String name;
	private Boolean open;
	private Boolean isParent;
	/**
	 * 复选框的树
	 * @param id
	 * @param pid
	 * @param name
	 * @param open
	 * @param isparent
	 */
	private Boolean checked;
	
	public TreeNote(Integer id, Integer pid, String name, Boolean open, Boolean isparent,Boolean checked) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.open = open;
		this.isParent = isparent;
		this.checked = checked;
	}
	
	
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public TreeNote(Integer id, Integer pid, String name, Boolean open, Boolean isparent) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.open = open;
		this.isParent = isparent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Boolean getSpread() {
		return spread;
	}
	public void setSpread(Boolean spread) {
		this.spread = spread;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public List<TreeNote> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNote> children) {
		this.children = children;
	}

	public TreeNote(Integer id, Integer pid, String title, String icon, String href, Boolean spread, String target) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.href = href;
		this.spread = spread;
		this.target = target;
	}
	public TreeNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

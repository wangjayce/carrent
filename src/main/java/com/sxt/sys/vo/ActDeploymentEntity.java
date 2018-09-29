package com.sxt.sys.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActDeploymentEntity {

	  protected String id;
	  protected String name;
	  protected String category;
	  protected String tenantId;
	  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	  protected Date deploymentTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Date getDeploymentTime() {
		return deploymentTime;
	}
	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}
	  
	  
}

package com.sxt.sys.utils;

import java.util.ArrayList;
import java.util.List;

import com.sxt.sys.domain.User;

public class ActiverUser {

	/**
	 * shiro存入token的user
	 */
	private User curUser;

	private List<String> roles = new ArrayList<String>();

	private List<String> permissions =  new ArrayList<String>();

	public ActiverUser(User curUser, List<String> roles, List<String> permissions) {
		this.curUser = curUser;
		this.roles = roles;
		this.permissions = permissions;
	}

	public ActiverUser() {
	}

	public User getCurUser() {
		return curUser;
	}

	public void setCurUser(User curUser) {
		this.curUser = curUser;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	
	
}

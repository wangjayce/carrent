package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public DataGrid queryAllRole(RoleVo roleVo) {
		Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data = roleMapper.queryAllRole(roleVo);
		return new DataGrid(page.getTotal(), data);
	}
	@Override
	public List<Role> queryAllRoleForList(RoleVo roleVo) {
		return roleMapper.queryAllRole(roleVo);
	}

	@Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = roleMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public Role queryRoleById(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateRole(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int addRolePermission(RoleVo roleVo) {
		int i = roleMapper.deleteRolePermission(roleVo.getId());
		if(null!=roleVo.getIds()&&roleVo.getIds().length>0) {
			for (Integer j : roleVo.getIds()) {
				roleMapper.savaRolePermission(roleVo.getId(),j);
				i++;
			}
		}
		return i;
	}
	@Override
	public List<Role> queryUserRole(Integer id) {
		return roleMapper.queryUserRole(id);
	}

}

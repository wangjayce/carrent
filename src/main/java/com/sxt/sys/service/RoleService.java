package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Role;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.RoleVo;

public interface RoleService {

	
	/**
	 * 表格数据查询所有角色
	 * @param roleVo
	 * @return
	 */
	DataGrid queryAllRole(RoleVo roleVo);
		
	/**
	 * 添加角色
	 * @param record
	 * @return
	 */
	int insert(Role record);
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);
	
	/**
	 * 根据id查询角色
	 */
	Role queryRoleById(Integer id);
	
	/**
	 * 修改角色
	 */
	int updateRole(Role role);

	int addRolePermission(RoleVo roleVo);

	List<Role> queryAllRoleForList(RoleVo roleVo);

	List<Role> queryUserRole(Integer id);
}

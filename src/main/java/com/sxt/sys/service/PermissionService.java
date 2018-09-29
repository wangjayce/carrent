package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.Permission;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.PermissionVo;

public interface PermissionService {

	/**
	 * 超级用户菜单全查询
	 * @param permissionVo
	 * @return
	 */
	List<TreeNote> queryPermissionByType(PermissionVo permissionVo);
	
	/**
	 * 根据用户id查询菜单
	 * @param permissionVo
	 * @param id
	 * @return
	 */
	List<TreeNote> queryPermissionByType(PermissionVo permissionVo,Integer id);

	
	/**
	 * 根据id查询菜单或者权限
	 * @param id
	 * @return
	 */
	Permission queryPermissionById(Integer id);
	
	/**
	 * 查询菜单和权限列表
	 * @param menuVo
	 * @return
	 */
	DataGrid queryAllPermission(PermissionVo permissionVo);

	

	/**
	 * 添加权限或菜单
	 * @param menuVo
	 * @return
	 */
	int insert(PermissionVo permissionVo);

	/**
	 * 修改权限或菜单
	 * @param menuVo
	 * @return
	 */
	int updatePermission(PermissionVo permissionVo);

	/**
	 * 删除权限或菜单
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer... id);

	List<Permission> queryMenuTree(PermissionVo menuVo);

	List<Permission> queryPermissionByRoleId(Integer id);

	List<Permission> queryMenuByUserId(Integer id);

	List<Permission> queryPermissionByUserId(Integer id);
}

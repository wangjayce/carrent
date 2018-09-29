package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Permission;
import com.sxt.sys.vo.PermissionVo;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	List<Permission> queryAllMenu(PermissionVo permissionVo);

	List<Permission> queryPermissionByRoleId(Integer available, Integer id);

	List<Permission> queryAllMenuByUserId(String type,Integer available, Integer id);

	List<Permission> queryMenuByUserId(Integer id);

	List<Permission> queryPermissionByUserId(Integer id);
}
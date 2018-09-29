package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.Role;
import com.sxt.sys.vo.RoleVo;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> queryAllRole(RoleVo roleVo);

    int savaRolePermission(Integer rid, Integer pid);

	int deleteRolePermission(Integer rid);

	List<Role> queryUserRole(Integer id);
}
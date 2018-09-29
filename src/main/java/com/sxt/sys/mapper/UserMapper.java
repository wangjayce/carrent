package com.sxt.sys.mapper;

import java.util.List;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登陆根据登陆名查询user
     * @param loginname
     * @return
     */
	User queryUserByLoginname(String loginname);

	List<User> queryAllUser(UserVo userVo);

	/**
	 * 删除用户角色
	 * @param id
	 * @return
	 */
	int deleteUserRoleByUid(Integer id);

	/**
	 * 添加用户角色关系
	 * @param j
	 * @param id
	 */
	void addUserRole(Integer j, Integer id);
}
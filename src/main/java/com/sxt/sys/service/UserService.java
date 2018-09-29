package com.sxt.sys.service;

import java.util.List;

import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.UserVo;

public interface UserService {

	public User queryUserByLoginname(String loginname);

	public User queryUserById(Integer id);

	public DataGrid queryAllUser(UserVo userVo);

	public int insert(UserVo userVo);

	public int updateUser(UserVo userVo);

	public int deleteByPrimaryKey(Integer...integers);

	public List<User> queryAllUserByDeptId(UserVo userVo);

	public int saveUserRole(UserVo userVo);
}

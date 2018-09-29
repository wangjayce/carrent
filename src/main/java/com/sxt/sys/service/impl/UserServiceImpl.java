package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.domain.User;
import com.sxt.sys.mapper.UserMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserByLoginname(String loginname) {
		return userMapper.queryUserByLoginname(loginname);
	}

	@Override
	public User queryUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public DataGrid queryAllUser(UserVo userVo) {
		Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
		List<User> list = userMapper.queryAllUser(userVo);
		return new DataGrid(page.getTotal(), list);
	}
	@Override
	public List<User> queryAllUserByDeptId(UserVo userVo) {
		return userMapper.queryAllUser(userVo);
	}

	@Override
	public int insert(UserVo userVo) {
		return userMapper.insert(userVo);
	}

	@Override
	public int updateUser(UserVo userVo) {
		return userMapper.updateByPrimaryKeySelective(userVo);
	}

	@Override
	public int deleteByPrimaryKey(Integer... integers) {
		int j = 0;
		for (Integer i : integers) {
			j = userMapper.deleteByPrimaryKey(i);
			
		}
		return j;
	}

	@Override
	public int saveUserRole(UserVo userVo) {
		int i = this.userMapper.deleteUserRoleByUid(userVo.getId());
		if(null!=userVo.getIds()&&userVo.getIds().length>0) {
			for (Integer j : userVo.getIds()) {
				userMapper.addUserRole(j,userVo.getId());
				i++;
			}
		}
		return i;
	}


}

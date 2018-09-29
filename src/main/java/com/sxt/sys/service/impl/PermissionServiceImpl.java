package com.sxt.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.mapper.PermissionMapper;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.StandarTreeBuilt;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.PermissionVo;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<TreeNote> queryPermissionByType(PermissionVo permissionVo) {
		List<Permission> list = permissionMapper.queryAllMenu(permissionVo);
		List<TreeNote> treeNotes = new ArrayList<>();
		for (Permission p : list) {
			Boolean spread = p.getOpen()==1?true:false;
			treeNotes.add(new TreeNote(p.getId(), p.getPid(), p.getName(), p.getIcon(), p.getHref(), spread, p.getTarget()));
		}
		List<TreeNote> notes = StandarTreeBuilt.builtCombotreeJson(treeNotes, 1);
		return notes;
	}

	@Override
	public List<TreeNote> queryPermissionByType(PermissionVo permissionVo, Integer id) {
		List<Permission> list = permissionMapper.queryAllMenuByUserId(permissionVo.getType(),permissionVo.getAvailable(),id);
		List<TreeNote> treeNotes = new ArrayList<>();
		for (Permission p : list) {
			Boolean spread = p.getOpen()==1?true:false;
			treeNotes.add(new TreeNote(p.getId(), p.getPid(), p.getName(), p.getIcon(), p.getHref(), spread, p.getTarget()));
		}
		List<TreeNote> notes = StandarTreeBuilt.builtCombotreeJson(treeNotes, 1);
		return notes;
	}

	@Override
	public Permission queryPermissionById(Integer id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	@Override
	public DataGrid queryAllPermission(PermissionVo permissionVo) {
		Page<Object> page = PageHelper.startPage(permissionVo.getPage(), permissionVo.getLimit());
		List<Permission> list = this.permissionMapper.queryAllMenu(permissionVo);
		return new DataGrid(page.getTotal(), list);
	}



	@Override
	public int insert(PermissionVo permissionVo) {
		return permissionMapper.insert(permissionVo);
	}

	@Override
	public int updatePermission(PermissionVo permissionVo) {
		return permissionMapper.updateByPrimaryKeySelective(permissionVo);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int j = 0;
		for (Integer i : id) {
			j = permissionMapper.deleteByPrimaryKey(i);
		}
		return j;
	}

	@Override
	public List<Permission> queryMenuTree(PermissionVo menuVo) {
		return permissionMapper.queryAllMenu(menuVo);
	}

	@Override
	public List<Permission> queryPermissionByRoleId(Integer id) {
		Integer available = SYS_Constast.TYPE_AVAILABLE_YES;
		return this.permissionMapper.queryPermissionByRoleId(available,id);
	}

	@Override
	public List<Permission> queryMenuByUserId(Integer id) {
		return permissionMapper.queryMenuByUserId(id);
	}

	@Override
	public List<Permission> queryPermissionByUserId(Integer id) {
		return permissionMapper.queryPermissionByUserId(id);
	}


}

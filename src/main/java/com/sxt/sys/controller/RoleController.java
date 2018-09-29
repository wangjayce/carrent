package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.Role;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.PermissionVo;
import com.sxt.sys.vo.RoleVo;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping("toRoleManager")
	public String toRoleManager() {		
		return "system/role/roleManager";
	}
	
	
	@RequestMapping("toaddRole")
	public String addRole() {		
		return "system/role/addRole";
	}
	
	
	@RequestMapping("togivePermission")
	public String togivePermission(RoleVo roleVo,Model model) {	
		model.addAttribute("id", roleVo.getId());
		return "system/role/givePermission";
	}
	
	@RequestMapping("loadPermissionTree")
	@ResponseBody
	public List<TreeNote> loadPermissionTree(RoleVo roleVo) {
		List<TreeNote> treeNotes = new ArrayList<>();
		List<Permission> list  = permissionService.queryPermissionByRoleId(roleVo.getId());
		PermissionVo permissionVo = new PermissionVo();
		permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Permission> list2 = permissionService.queryMenuTree(permissionVo);
		for (Permission p1 : list2) {
			Boolean checked = false;
			for (Permission p2 : list) {
				if(p1.getId()==p2.getId()) {
					checked = true;
				}
			}
			Boolean isparent = false;
			if(p1.getType().equals(SYS_Constast.PERMISSION_TYPE_MENU)) {
				isparent = true;
			}
			Boolean open = p1.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNotes.add(new TreeNote(p1.getId(), p1.getPid(), p1.getName() , open, isparent, checked));
		}
		
		return treeNotes;
	}
	
	
	@RequestMapping("toupdateRole")
	public String updateRole(RoleVo roleVo,Model model) {
		Role role = roleService.queryRoleById(roleVo.getId());
		model.addAttribute("role", role);
		return "system/role/updateRole";
	}
	
	
	/**
	 * 分配角色的权限
	 * @param roleVo
	 * @return
	 */
	@RequestMapping("savaRolePermission")
	@ResponseBody
	public Map<String, Object> savaRolePermission(RoleVo roleVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "保存失败";
		try {
			int i = roleService.addRolePermission(roleVo);
			if(i>0) {
				msg = "保存成功";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 加载角色表格数据
	 * @param roleVo
	 * @return
	 */
	@RequestMapping("uploadAllRole")
	@ResponseBody
	public DataGrid uploadAllRole(RoleVo roleVo) {	
		return roleService.queryAllRole(roleVo);
	}
	

	@RequestMapping("addRole")
	@ResponseBody
	public Map<String , Object> addRole(RoleVo roleVo,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = roleService.insert(roleVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateRole")
	@ResponseBody
	public Map<String , Object> updateRole(RoleVo roleVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = roleService.updateRole(roleVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteRole")
	@ResponseBody
	public Map<String , Object> deleteRole(RoleVo roleVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=roleVo.getIds()&&roleVo.getIds().length>0){
			    i = roleService.deleteByPrimaryKey(roleVo.getIds());				
			}else {
				i = roleService.deleteByPrimaryKey(roleVo.getId());				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			msg="删除成功";
		}
		map.put("msg", msg);
		return map;
	}
}

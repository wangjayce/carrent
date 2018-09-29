package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Dept;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping("toMenuManager")
	public String toMenuManager() {		
		return "system/menu/menuManager";
	}
	
	
	@RequestMapping("toMenuLeft")
	public String toMenuLeft() {		
		return "system/menu/menuLeft";
	}
	
	
	@RequestMapping("toMenuRight")
	public String toMenuRight() {		
		return "system/menu/menuRight";
	}
	@RequestMapping("toaddMenu")
	public String addMenu() {		
		return "system/menu/addMenu";
	}
	
	
	
	@RequestMapping("toupdateMenu")
	public String updateMenu(PermissionVo menuVo,Model model) {
		Permission permission = permissionService.queryPermissionById(menuVo.getId());
		if(null!=permission.getIcon()&&!permission.getIcon().equals("")) {
			String icon = permission.getIcon();
			String icon1 = icon.replaceAll("&", "&amp;");
			permission.setIcon(icon1);
		}
		model.addAttribute("menu", permission);
		return "system/menu/updateMenu";
	}
	
	
	/**
	 * 加载菜单表格数据
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("uploadAllMenu")
	@ResponseBody
	public DataGrid uploadAllMenu(PermissionVo menuVo) {	
		menuVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
		return permissionService.queryAllPermission(menuVo);
	}
	
	/**
	 * 加载菜单树结构
	 * @param menuVo
	 * @return
	 */
	@RequestMapping("loadMenuTree")
	@ResponseBody
	public List<TreeNote> loadMenuTree(PermissionVo menuVo) {	
		menuVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
		List<Permission> list = permissionService.queryMenuTree(menuVo);
		List<TreeNote> treeNotes = new ArrayList<>();
		for (Permission d : list) {
			Boolean open = d.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			Boolean isparent = d.getParent()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNotes.add(new TreeNote(d.getId(), d.getPid(), d.getName(), open, isparent));
		}
		return treeNotes;
	}
	@RequestMapping("addMenu")
	@ResponseBody
	public Map<String , Object> addMenu(PermissionVo menuVo) {
		menuVo.setType(SYS_Constast.PERMISSION_TYPE_MENU);
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = permissionService.insert(menuVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateMenu")
	@ResponseBody
	public Map<String , Object> updateMenu(PermissionVo menuVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = permissionService.updatePermission(menuVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteMenu")
	@ResponseBody
	public Map<String , Object> deleteMenu(PermissionVo menuVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=menuVo.getIds()&&menuVo.getIds().length>0){
			    i = permissionService.deleteByPrimaryKey(menuVo.getIds());				
			}else {
				i = permissionService.deleteByPrimaryKey(menuVo.getId());				
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

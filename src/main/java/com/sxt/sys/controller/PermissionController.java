package com.sxt.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.PermissionVo;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping("toPermissionManager")
	public String toPermissionManager() {		
		return "system/permission/permissionManager";
	}
	
	
	@RequestMapping("toPermissionLeft")
	public String toPermissionLeft() {		
		return "system/permission/permissionLeft";
	}
	
	
	@RequestMapping("toPermissionRight")
	public String toPermissionRight() {		
		return "system/permission/permissionRight";
	}
	@RequestMapping("toaddPermission")
	public String addPermission() {		
		return "system/permission/addPermission";
	}
	
	
	
	@RequestMapping("toupdatePermission")
	public String updatePermission(PermissionVo permissionVo,Model model) {
		Permission permission = permissionService.queryPermissionById(permissionVo.getId());
		model.addAttribute("permission", permission);
		return "system/permission/updatePermission";
	}
	
	
	/**
	 * 加载菜单表格数据
	 * @param permissionVo
	 * @return
	 */
	@RequestMapping("uploadAllPermission")
	@ResponseBody
	public DataGrid uploadAllPermission(PermissionVo permissionVo) {	
		permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);
		return permissionService.queryAllPermission(permissionVo);
	}
	

	@RequestMapping("addPermission")
	@ResponseBody
	public Map<String , Object> addPermission(PermissionVo permissionVo) {
		permissionVo.setType(SYS_Constast.PERMISSION_TYPE_PERMISSION);
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = permissionService.insert(permissionVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("updatePermission")
	@ResponseBody
	public Map<String , Object> updatePermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = permissionService.updatePermission(permissionVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deletePermission")
	@ResponseBody
	public Map<String , Object> deletePermission(PermissionVo permissionVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=permissionVo.getIds()&&permissionVo.getIds().length>0){
			    i = permissionService.deleteByPrimaryKey(permissionVo.getIds());				
			}else {
				i = permissionService.deleteByPrimaryKey(permissionVo.getId());				
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

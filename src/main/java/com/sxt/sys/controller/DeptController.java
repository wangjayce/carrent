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
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.DeptVo;

@Controller
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping("toDeptManager")
	public String toDeptManager() {		
		return "system/dept/deptManager";
	}
	
	
	@RequestMapping("toDeptLeft")
	public String toDeptLeft() {		
		return "system/dept/deptLeft";
	}
	
	
	@RequestMapping("toDeptRight")
	public String toDeptRight() {		
		return "system/dept/deptRight";
	}
	@RequestMapping("toaddDept")
	public String addDept() {		
		return "system/dept/addDept";
	}
	
	
	
	@RequestMapping("toupdateDept")
	public String updateDept(DeptVo deptVo,Model model) {
		Dept dept = deptService.queryDeptById(deptVo.getId());
		model.addAttribute("dept", dept);
		return "system/dept/updateDept";
	}
	
	
	/**
	 * 加载部门表格数据
	 * @param deptVo
	 * @return
	 */
	@RequestMapping("uploadAllDept")
	@ResponseBody
	public DataGrid uploadAllDept(DeptVo deptVo) {	
		deptVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		return deptService.queryAllDept(deptVo);
	}
	
	/**
	 * 加载部门树结构
	 * @param deptVo
	 * @return
	 */
	@RequestMapping("loadDeptTree")
	@ResponseBody
	public List<TreeNote> loadDeptTree(DeptVo deptVo) {	
		deptVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Dept> list = deptService.queryDeptTree(deptVo);
		List<TreeNote> treeNotes = new ArrayList<>();
		for (Dept d : list) {
			Boolean open = d.getOpen()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			Boolean isparent = d.getParent()==SYS_Constast.TYPE_PUBLIC_ONE?true:false;
			treeNotes.add(new TreeNote(d.getId(), d.getPid(), d.getName(), open, isparent));
		}
		return treeNotes;
	}
	@RequestMapping("addDept")
	@ResponseBody
	public Map<String , Object> addDept(DeptVo deptVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = deptService.insert(deptVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateDept")
	@ResponseBody
	public Map<String , Object> updateDept(DeptVo deptVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = deptService.updateDept(deptVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteDept")
	@ResponseBody
	public Map<String , Object> deleteDept(DeptVo deptVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=deptVo.getIds()&&deptVo.getIds().length>0){
			    i = deptService.deleteByPrimaryKey(deptVo.getIds());				
			}else {
				i = deptService.deleteByPrimaryKey(deptVo.getId());				
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

package com.sxt.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.LeavebillService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.LeavebillVo;

@Controller
@RequestMapping("leavebill")
public class LeavebillController {

	@Autowired
	private LeavebillService leavebillService;
	
	
	@RequestMapping("toLeavebillManager")
	public String toLeavebillManager() {		
		return "system/leavebill/leavebillManager";
	}
	
	
	@RequestMapping("toaddLeavebill")
	public String addLeavebill() {		
		return "system/leavebill/addLeavebill";
	}
	
	
	@RequestMapping("toupdateLeavebill")
	public String updateLeavebill(LeavebillVo leavebillVo,Model model) {
		Leavebill leavebill = leavebillService.queryLeavebillById(leavebillVo.getId());
		model.addAttribute("leavebill", leavebill);
		return "system/leavebill/updateLeavebill";
	}
	
	
	/**
	 * 加载请假单表格数据
	 * @param leavebillVo
	 * @return
	 */
	@RequestMapping("uploadAllLeavebill")
	@ResponseBody
	public DataGrid uploadAllLeavebill(LeavebillVo leavebillVo,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user.getType()==SYS_Constast.USER_TYPE_SUPER) {
			return leavebillService.queryAllLeavebill(leavebillVo);
		}else {
			leavebillVo.setUserid(user.getId());
			return leavebillService.queryAllLeavebill(leavebillVo);
		}
	}
	
	/**
	 * 图片上传
	 * @param leavebillVo
	 * @return
	 */
	@RequestMapping("uploadimage")
	@ResponseBody
	public Map<String, Object> uploadimage(@Param("file")MultipartFile file,HttpServletRequest request) {	
		String path = request.getServletContext().getRealPath("myimage");
		String oldName = file.getOriginalFilename();
		File dir = new File(path);
		System.out.println(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file1 = new File(dir,oldName);
		try {
			file.transferTo(file1);
			Map<String, Object> data = new HashMap<>();
			data.put("src", "../myimage/"+oldName);
			data.put("title", oldName);
			Map<String, Object> map = new HashMap<>();
			 map.put("code",0);//0表示成功，1失败
	        map.put("msg","上传成功");//提示消息
	        map.put("data",data);
			return map;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("addLeavebill")
	@ResponseBody
	public Map<String , Object> addLeavebill(LeavebillVo leavebillVo,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = leavebillService.insert(leavebillVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateLeavebill")
	@ResponseBody
	public Map<String , Object> updateLeavebill(LeavebillVo leavebillVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = leavebillService.updateLeavebill(leavebillVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteLeavebill")
	@ResponseBody
	public Map<String , Object> deleteLeavebill(LeavebillVo leavebillVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=leavebillVo.getIds()&&leavebillVo.getIds().length>0){
			    i = leavebillService.deleteByPrimaryKey(leavebillVo.getIds());				
			}else {
				i = leavebillService.deleteByPrimaryKey(leavebillVo.getId());				
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

package com.sxt.bus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Inport;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.InportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.InportVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;

@Controller
@RequestMapping("inport")
public class InportController {

	@Autowired
	private InportService inportService;
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("toInportManager")
	public String toInportManager() {		
		return "business/inport/inportManager";
	}
	
	
	@RequestMapping("toInportLeft")
	public String toInportLeft() {		
		return "business/inport/inportLeft";
	}
	
	
	@RequestMapping("toInportRight")
	public String toInportRight() {		
		return "business/inport/inportRight";
	}
	@RequestMapping("toaddInport")
	public String addInport(Model model) {
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/inport/addInport";
	}
	
	
	
	@RequestMapping("toupdateInport")
	public String updateInport(InportVo inportVo,Model model) {
		Inport inport = inportService.queryInportById(inportVo.getId());
		model.addAttribute("inport", inport);
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/inport/updateInport";
	}
	
	
	/**
	 * 加载进货单表格数据
	 * @param inportVo
	 * @return
	 */
	@RequestMapping("uploadAllInport")
	@ResponseBody
	public DataGrid uploadAllInport(InportVo inportVo) {	
		return inportService.queryAllInport(inportVo);
	}

	
	/**
	 * 加载供应商树结构，此处还是引用的商品controller的方法
	 * @param inportVo
	 * @return
	 */
	@RequestMapping("loadInportTree")
	@ResponseBody
	public List<TreeNote> loadInportTree(ProviderVo providerVo) {	
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		List<TreeNote> treeNotes = new ArrayList<>();
		Integer parentId = SYS_Constast.TYPE_PUBLIC_ZERO;
		treeNotes.add(new TreeNote(parentId, SYS_Constast.TYPE_PUBLIC_ZERO, "供应商列表", true, true));
		for (Provider d : list) {
			Boolean open = false;
			Boolean isparent = false;
			treeNotes.add(new TreeNote(d.getId(),parentId, d.getProvidername(), open, isparent));
		}
		return treeNotes;
	}
	
	@RequestMapping("addInport")
	@ResponseBody
	public Map<String , Object> addInport(InportVo inportVo,HttpSession session) {
		User user = (User) session.getAttribute("user");	
		inportVo.setOperateperson(user.getName());
		inportVo.setInporttime(new Date());
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = inportService.insert(inportVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateInport")
	@ResponseBody
	public Map<String , Object> updateInport(InportVo inportVo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = inportService.updateInport(inportVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteInport")
	@ResponseBody
	public Map<String , Object> deleteInport(InportVo inportVo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=inportVo.getIds()&&inportVo.getIds().length>0){
			    i = inportService.deleteByPrimaryKey(inportVo.getIds());				
			}else {
				i = inportService.deleteByPrimaryKey(inportVo.getId());				
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

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

import com.sxt.bus.domain.Outport;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.OutportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.OutportVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;

@Controller
@RequestMapping("outport")
public class OutportController {

	@Autowired
	private OutportService outportService;
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("toOutportManager")
	public String toOutportManager() {		
		return "business/outport/outportManager";
	}
	
	
	@RequestMapping("toOutportLeft")
	public String toOutportLeft() {		
		return "business/outport/outportLeft";
	}
	
	
	@RequestMapping("toOutportRight")
	public String toOutportRight() {		
		return "business/outport/outportRight";
	}
	@RequestMapping("toaddOutport")
	public String addOutport(Model model) {
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/outport/addOutport";
	}
	
	
	
	@RequestMapping("toupdateOutport")
	public String updateOutport(OutportVo outportVo,Model model) {
		Outport outport = outportService.queryOutportById(outportVo.getId());
		model.addAttribute("outport", outport);
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/outport/updateOutport";
	}
	
	
	/**
	 * 加载退货单表格数据
	 * @param outportVo
	 * @return
	 */
	@RequestMapping("uploadAllOutport")
	@ResponseBody
	public DataGrid uploadAllOutport(OutportVo outportVo) {	
		return outportService.queryAllOutport(outportVo);
	}

	
	/**
	 * 加载供应商树结构，此处还是引用的商品controller的方法
	 * @param outportVo
	 * @return
	 */
	@RequestMapping("loadOutportTree")
	@ResponseBody
	public List<TreeNote> loadOutportTree(ProviderVo providerVo) {	
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
	
	@RequestMapping("addOutport")
	@ResponseBody
	public Map<String , Object> addOutport(OutportVo outportVo,HttpSession session) {
		User user = (User) session.getAttribute("user");	
		outportVo.setOperateperson(user.getName());
		outportVo.setOutporttime(new Date());
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = outportService.insert(outportVo);
			if(i>0) {
				msg="添加成功";
			}else if(i==SYS_Constast.LOW_STOCKS) {
				msg = "退货数量超过库存，退货失败";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateOutport")
	@ResponseBody
	public Map<String , Object> updateOutport(OutportVo outportVo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = outportService.updateOutport(outportVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteOutport")
	@ResponseBody
	public Map<String , Object> deleteOutport(OutportVo outportVo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=outportVo.getIds()&&outportVo.getIds().length>0){
			    i = outportService.deleteByPrimaryKey(outportVo.getIds());				
			}else {
				i = outportService.deleteByPrimaryKey(outportVo.getId());				
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

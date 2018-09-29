package com.sxt.bus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.utils.DataGrid;

@Controller
@RequestMapping("provider")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
	
	@RequestMapping("toProviderManager")
	public String toProviderManager() {		
		return "business/provider/providerManager";
	}
	
	
	@RequestMapping("toaddProvider")
	public String addProvider() {		
		return "business/provider/addProvider";
	}
	
	
	@RequestMapping("toupdateProvider")
	public String updateProvider(ProviderVo providerVo,Model model) {
		Provider provider = providerService.queryProviderById(providerVo.getId());
		model.addAttribute("provider", provider);
		return "business/provider/updateProvider";
	}
	
	
	
	/**
	 * 加载供应商表格数据
	 * @param providerVo
	 * @return
	 */
	@RequestMapping("uploadAllProvider")
	@ResponseBody
	public DataGrid uploadAllProvider(ProviderVo providerVo) {	
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		return providerService.queryAllProvider(providerVo);
	}
	

	
	@RequestMapping("addProvider")
	@ResponseBody
	public Map<String , Object> addProvider(ProviderVo providerVo,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = providerService.insert(providerVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("updateProvider")
	@ResponseBody
	public Map<String , Object> updateProvider(ProviderVo providerVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = providerService.updateProvider(providerVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("deleteProvider")
	@ResponseBody
	public Map<String , Object> deleteProvider(ProviderVo providerVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=providerVo.getIds()&&providerVo.getIds().length>0){
			    i = providerService.deleteByPrimaryKey(providerVo.getIds());				
			}else {
				i = providerService.deleteByPrimaryKey(providerVo.getId());				
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

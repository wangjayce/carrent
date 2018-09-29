package com.sxt.bus.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.TreeNote;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ProviderService providerService;
	
	@RequestMapping("toGoodsManager")
	public String toGoodsManager() {		
		return "business/goods/goodsManager";
	}
	
	
	@RequestMapping("toGoodsLeft")
	public String toGoodsLeft() {		
		return "business/goods/goodsLeft";
	}
	
	
	@RequestMapping("toGoodsRight")
	public String toGoodsRight() {		
		return "business/goods/goodsRight";
	}
	@RequestMapping("toaddGoods")
	public String addGoods(Model model) {
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/goods/addGoods";
	}
	
	
	
	@RequestMapping("toupdateGoods")
	public String updateGoods(GoodsVo goodsVo,Model model) {
		Goods goods = goodsService.queryGoodsById(goodsVo.getId());
		model.addAttribute("goods", goods);
		ProviderVo providerVo = new ProviderVo();
		providerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Provider> list = providerService.queryAllProviderForList(providerVo);
		model.addAttribute("list", list);
		return "business/goods/updateGoods";
	}
	
	
	/**
	 * 加载商品表格数据
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping("uploadAllGoods")
	@ResponseBody
	public DataGrid uploadAllGoods(GoodsVo goodsVo) {	
		goodsVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		return goodsService.queryAllGoods(goodsVo);
	}
	/**
	 * 根据供应商id查询商品
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping("queryGoodsByPid")
	@ResponseBody
	public List<Goods> queryGoodsByPid(GoodsVo goodsVo) {	
		return goodsService.queryGoodsByPid(goodsVo);
	}
	
	/**
	 * 加载商品树结构
	 * @param goodsVo
	 * @return
	 */
	@RequestMapping("loadGoodsTree")
	@ResponseBody
	public List<TreeNote> loadGoodsTree(ProviderVo providerVo) {	
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
	
	@RequestMapping("addGoods")
	@ResponseBody
	public Map<String , Object> addGoods(GoodsVo goodsVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = goodsService.insert(goodsVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateGoods")
	@ResponseBody
	public Map<String , Object> updateGoods(GoodsVo goodsVo,HttpServletRequest request) {
		Goods goods = goodsService.queryGoodsById(goodsVo.getId());
		String path = request.getServletContext().getRealPath("/");
		String oldpath = goods.getGoodsimg();
		if(oldpath!=null&&!oldpath.equals("")) {
			String newPath = oldpath.substring(2, oldpath.length());
			File file = new File(path+newPath);
			if(file.isFile()&&file.exists()) {
				file.delete();
			}
		}
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = goodsService.updateGoods(goodsVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteGoods")
	@ResponseBody
	public Map<String , Object> deleteGoods(GoodsVo goodsVo,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=goodsVo.getIds()&&goodsVo.getIds().length>0){
			    i = goodsService.deleteByPrimaryKey(goodsVo.getIds());
			    for (Integer k : goodsVo.getIds()) {
			    	Goods goods = goodsService.queryGoodsById(k);
					String path = request.getServletContext().getRealPath("/");
					String oldpath = goods.getGoodsimg();
					if(oldpath!=null&&!oldpath.equals("")) {
						String newPath = oldpath.substring(2, oldpath.length());
						File file = new File(path+newPath);
						if(file.isFile()&&file.exists()) {
							file.delete();
						}
					}
				}
			}else {
				i = goodsService.deleteByPrimaryKey(goodsVo.getId());	
				Goods goods = goodsService.queryGoodsById(goodsVo.getId());
				String path = request.getServletContext().getRealPath("/");
				String oldpath = goods.getGoodsimg();
				if(oldpath!=null&&!oldpath.equals("")) {
					String newPath = oldpath.substring(2, oldpath.length());
					File file = new File(path+newPath);
					if(file.isFile()&&file.exists()) {
						file.delete();
					}
				}
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

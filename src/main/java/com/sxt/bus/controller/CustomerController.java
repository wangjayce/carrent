package com.sxt.bus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.bus.domain.Customer;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.vo.CustomerVo;
import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.utils.DataGrid;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {		
		return "business/customer/customerManager";
	}
	
	
	@RequestMapping("toaddCustomer")
	public String addCustomer() {		
		return "business/customer/addCustomer";
	}
	
	
	@RequestMapping("toupdateCustomer")
	public String updateCustomer(CustomerVo customerVo,Model model) {
		Customer customer = customerService.queryCustomerById(customerVo.getId());
		model.addAttribute("customer", customer);
		return "business/customer/updateCustomer";
	}
	
	
	
	/**
	 * 加载客户表格数据
	 * @param customerVo
	 * @return
	 */
	@RequestMapping("uploadAllCustomer")
	@ResponseBody
	public DataGrid uploadAllCustomer(CustomerVo customerVo) {
		customerVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		return customerService.queryAllCustomer(customerVo);
	}
	

	
	@RequestMapping("addCustomer")
	@ResponseBody
	public Map<String , Object> addCustomer(CustomerVo customerVo,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = customerService.insert(customerVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("updateCustomer")
	@ResponseBody
	public Map<String , Object> updateCustomer(CustomerVo customerVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = customerService.updateCustomer(customerVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	@RequestMapping("deleteCustomer")
	@ResponseBody
	public Map<String , Object> deleteCustomer(CustomerVo customerVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=customerVo.getIds()&&customerVo.getIds().length>0){
			    i = customerService.deleteByPrimaryKey(customerVo.getIds());				
			}else {
				i = customerService.deleteByPrimaryKey(customerVo.getId());				
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

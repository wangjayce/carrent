package com.sxt.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Customer;
import com.sxt.bus.mapper.CustomerMapper;
import com.sxt.bus.service.CustomerService;
import com.sxt.bus.vo.CustomerVo;
import com.sxt.sys.utils.DataGrid;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Customer queryCustomerById(Integer id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	@Override
	public DataGrid queryAllCustomer(CustomerVo customerVo) {
		Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
		List<Customer> list = customerMapper.queryAllCustomer(customerVo);
		return new DataGrid(page.getTotal(), list);
	}

	@Override
	public int insert(CustomerVo customerVo) {
		return customerMapper.insert(customerVo);
	}

	@Override
	public int updateCustomer(CustomerVo customerVo) {
		return customerMapper.updateByPrimaryKeySelective(customerVo);
	}

	@Override
	public int deleteByPrimaryKey(Integer... id) {
		int i = 0 ;
		for (Integer j : id) {
			i = customerMapper.deleteByPrimaryKey(j);
		}
		return i;
	}

}

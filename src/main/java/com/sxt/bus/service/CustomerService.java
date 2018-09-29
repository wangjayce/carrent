package com.sxt.bus.service;

import com.sxt.bus.domain.Customer;
import com.sxt.bus.vo.CustomerVo;
import com.sxt.sys.utils.DataGrid;

public interface CustomerService {

	Customer queryCustomerById(Integer id);

	DataGrid queryAllCustomer(CustomerVo customerVo);

	int insert(CustomerVo customerVo);

	int updateCustomer(CustomerVo customerVo);

	int deleteByPrimaryKey(Integer... id);

}

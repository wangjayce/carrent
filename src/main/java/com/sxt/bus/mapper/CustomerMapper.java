package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Customer;
import com.sxt.bus.vo.CustomerVo;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * 查询所有客户
     * @param customerVo
     * @return
     */
	List<Customer> queryAllCustomer(CustomerVo customerVo);
}
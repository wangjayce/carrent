package com.sxt.bus.mapper;

import java.util.List;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.vo.ProviderVo;

public interface ProviderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provider record);

    int insertSelective(Provider record);

    Provider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provider record);

    int updateByPrimaryKey(Provider record);
    
    /**
     * 查询所有供应商
     * @param customerVo
     * @return
     */
	List<Provider> queryAllProvider(ProviderVo providerVo);
}
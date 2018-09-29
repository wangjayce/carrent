package com.sxt.bus.service;

import java.util.List;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.utils.DataGrid;

public interface ProviderService {

	Provider queryProviderById(Integer id);

	DataGrid queryAllProvider(ProviderVo providerVo);

	int insert(ProviderVo providerVo);

	int updateProvider(ProviderVo providerVo);

	int deleteByPrimaryKey(Integer... id);

	List<Provider> queryAllProviderForList(ProviderVo providerVo);

}

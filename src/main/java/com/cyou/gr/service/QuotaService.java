package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Quota;

public interface QuotaService {

	List<Quota> selectQuotaList();
	
	List<Quota> selectQuotaListBy();

	void saveOrUpdateQuota(Quota qu);

	void updownSort(Integer upSort, Integer upId, Integer downSort, Integer downId);

}

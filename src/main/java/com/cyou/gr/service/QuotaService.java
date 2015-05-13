package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Quota;

public interface QuotaService {

	List<Quota> selectQuotaList();

	void saveOrUpdateQuota(Quota qu);

	void deleteQuota(Integer id);

	void updownSort(Integer upSort, Integer upId, Integer downSort, Integer downId);

}

package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.QuotaMapper;
import com.cyou.gr.entity.Quota;
import com.cyou.gr.service.QuotaService;
@Service
@Transactional
public class QuotaServiceImpl implements QuotaService {
	@Autowired
	private QuotaMapper quotaMapper;
	@Override
	public List<Quota> selectQuotaList() {
		List<Quota> list=quotaMapper.selectQuotaList();
		return list;
	}
	@Override
	public void saveOrUpdateQuota(Quota qu) {
		if(qu.getId()==null){//新增
			Integer maxsort=quotaMapper.selectMaxSort();
			qu.setSort(maxsort+1);
			quotaMapper.insertSelective(qu);
		}else{//修改
			quotaMapper.updateByPrimaryKeySelective(qu);
		}
	}
	@Override
	public void deleteQuota(Integer id) {
		quotaMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId) {
		Quota up=new Quota();
		up.setId(upId);
		up.setSort(downSort);
		quotaMapper.updateByPrimaryKeySelective(up);
		Quota down=new Quota();
		down.setId(downId);
		down.setSort(upSort);
		quotaMapper.updateByPrimaryKeySelective(down);
	}

}

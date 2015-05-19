package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.FeeMapper;
import com.cyou.gr.dao.FeeTemplateMapper;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.service.FeeTemplateService;

@Service
@Transactional
public class FeeTemplateServiceImpl implements FeeTemplateService {
	@Autowired
	private FeeTemplateMapper feeTemplateMapper;
	@Autowired
	private FeeMapper feeMapper;

	@Override
	public List<FeeTemplate> selectFeeTemplatesByprocNodeId(Integer id) {
		List<FeeTemplate> list=feeTemplateMapper.selectFeetsByprocNodeId(id);
		for(FeeTemplate ft:list){
			ft.setIsUsed(feeMapper.isUsed(ft.getId())==null?false:true);
		}
		return list;
	}

}

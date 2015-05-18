package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.FeeTemplateMapper;
import com.cyou.gr.entity.FeeTemplate;
import com.cyou.gr.service.FeeTemplateService;

@Service
@Transactional
public class FeeTemplateServiceImpl implements FeeTemplateService {
	@Autowired
	private FeeTemplateMapper feeTemplateMapper;

	@Override
	public List<FeeTemplate> selectFeeTemplatesByprocNodeId(Integer id) {
		
		return feeTemplateMapper.selectFeetsByprocNodeId(id);
	}

}

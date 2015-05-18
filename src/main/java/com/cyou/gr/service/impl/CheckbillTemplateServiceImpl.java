package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillTemplateMapper;
import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.service.CheckbillTemplateService;
@Service
@Transactional
public class CheckbillTemplateServiceImpl implements CheckbillTemplateService {
@Autowired
private CheckbillTemplateMapper checkbillTemplateMapper;
	@Override
	public List<CheckbillTemplate> selectCheckbillTsByProcNodeId(Integer procNodeId) {
		return checkbillTemplateMapper.selectCheckbillTsByProcNodeId(procNodeId);
	}

}

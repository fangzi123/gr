package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.CheckbillMapper;
import com.cyou.gr.dao.CheckbillTemplateMapper;
import com.cyou.gr.entity.CheckbillTemplate;
import com.cyou.gr.service.CheckbillTemplateService;
@Service
@Transactional
public class CheckbillTemplateServiceImpl implements CheckbillTemplateService {
@Autowired
private CheckbillTemplateMapper checkbillTemplateMapper;
@Autowired
private CheckbillMapper checkbillMapper;
	@Override
	public List<CheckbillTemplate> selectCheckbillTsByProcNodeId(Integer procNodeId) {
		List<CheckbillTemplate> list=checkbillTemplateMapper.selectCheckbillTsByProcNodeId(procNodeId);
		for(CheckbillTemplate obj:list){
			obj.setIsUsed(checkbillMapper.isUsed(obj.getId())==null?false:true);
		}
		return list;
	}

}

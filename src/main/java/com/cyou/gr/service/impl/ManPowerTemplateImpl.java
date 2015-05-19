package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ManpowerMapper;
import com.cyou.gr.dao.ManpowerTemplateMapper;
import com.cyou.gr.entity.ManpowerTemplate;
import com.cyou.gr.service.ManPowerTemplateService;
@Service
@Transactional
public class ManPowerTemplateImpl implements ManPowerTemplateService {
@Autowired
private ManpowerTemplateMapper manpowerTemplateMapper;
@Autowired
private ManpowerMapper manpowerMapper;
	@Override
	public List<ManpowerTemplate> selectManpowerTemplatesByprocNodeId(Integer procNodeId) {
		List<ManpowerTemplate> list=manpowerTemplateMapper.selectManpowerTsByprocNodeId(procNodeId);
		for(ManpowerTemplate obj:list){
			obj.setIsUsed(manpowerMapper.isUsed(obj.getId())==null?false:true);
		}
		return list;
	}

}

package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.TaskBookTemplateMapper;
import com.cyou.gr.entity.TaskBookTemplate;
import com.cyou.gr.service.TaskBookTemplateService;

@Service
@Transactional
public class TaskBookTemplateServiceImpl implements TaskBookTemplateService {
	@Autowired
	private TaskBookTemplateMapper taskBookTemplateMapper;
	@Override
	public List<TaskBookTemplate> selectTaskbooktsByProcNodeId(Integer procNodeId) {
		return taskBookTemplateMapper.selectTaskbooktsByProcNodeId(procNodeId);
	}

}

package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.TaskBookTemplate;

public interface TaskBookTemplateService {

	List<TaskBookTemplate> selectTaskbooktsByProcNodeId(Integer id);

}

package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ProjectMapper;
import com.cyou.gr.entity.Project;
import com.cyou.gr.service.ProjectService;

@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public List<Project> selectProjectList(){
		List<Project> proList=projectMapper.selectProList();
		return proList;
	}

}

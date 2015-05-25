package com.cyou.gr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.ProNodeMapper;
import com.cyou.gr.entity.ProNode;
import com.cyou.gr.service.ProjectNodeService;
@Transactional
@Service
public class ProjectNodeServiceImpl implements ProjectNodeService {
	@Autowired
	private ProNodeMapper proNodeMapper;

	@Override
	public List<ProNode> selectProjNodeList(Integer projectId) {
		return proNodeMapper.selectProjNodeList(projectId);
	}

}

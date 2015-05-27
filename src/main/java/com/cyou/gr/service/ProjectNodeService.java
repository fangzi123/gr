package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.ProNode;

public interface ProjectNodeService {

	List<ProNode> selectProjNodeList(Integer projectId);

	ProNode selectProjectNodeRelatedById(Integer id);

}

package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Project;

public interface ProjectService {

	List<Project> selectProjectList();

	void saveOrUpdateProject(Project p);

	void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId);

}

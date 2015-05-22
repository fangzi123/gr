package com.cyou.gr.service;

import java.util.List;

import com.cyou.gr.entity.Project;
import com.cyou.gr.entity.vo.ProjectVo;

public interface ProjectService {

	List<Project> selectProjectList(Boolean flag);

	void saveOrUpdateProject(Project p);

	void updownSort(Integer upSort, Integer upId, Integer downSort,
			Integer downId);

	ProjectVo selectProjectRelatedById(Integer id);

}

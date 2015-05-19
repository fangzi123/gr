package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.TaskBookTemplate;

public interface TaskBookTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskBookTemplate record);

    int insertSelective(TaskBookTemplate record);

    TaskBookTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskBookTemplate record);

    int updateByPrimaryKey(TaskBookTemplate record);

	List<TaskBookTemplate> selectTaskbooktsByProcNodeId(Integer procNodeId);

	Byte selectMaxSort(Integer procNodeId);
}
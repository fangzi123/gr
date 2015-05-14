package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	List<Project> selectProList();

	Integer selectMaxSort();
}
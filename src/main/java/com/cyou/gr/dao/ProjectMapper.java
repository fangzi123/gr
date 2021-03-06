package com.cyou.gr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyou.gr.entity.Project;
import com.cyou.gr.entity.vo.ProjectVo;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

	List<Project> selectProList(@Param(value = "flag")Boolean flag);

	Integer selectMaxSort();

	ProjectVo selectProjectRelatedById(Integer id);

	List<Project> selectProjListByProcId(Integer processId);
}
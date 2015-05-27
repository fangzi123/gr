package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.ProNode;

public interface ProNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProNode record);

    int insertSelective(ProNode record);

    ProNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProNode record);

    int updateByPrimaryKey(ProNode record);

	List<ProNode> selectProjNodeList(Integer projectId);

	ProNode selectProjectNodeRelatedById(Integer id);
}
package com.cyou.gr.dao;

import com.cyou.gr.entity.ProNode;

public interface ProNodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProNode record);

    int insertSelective(ProNode record);

    ProNode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProNode record);

    int updateByPrimaryKey(ProNode record);

	ProNode selectProjNodeList(Integer projectId);
}
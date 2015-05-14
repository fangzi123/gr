package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.Process;

public interface ProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

	List<Process> selectProcessList();
}
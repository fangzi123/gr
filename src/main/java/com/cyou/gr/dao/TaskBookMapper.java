package com.cyou.gr.dao;

import com.cyou.gr.entity.TaskBook;

public interface TaskBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskBook record);

    int insertSelective(TaskBook record);

    TaskBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskBook record);

    int updateByPrimaryKey(TaskBook record);
}
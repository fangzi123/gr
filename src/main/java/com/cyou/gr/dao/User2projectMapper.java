package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.User2project;

public interface User2projectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User2project record);

    int insertSelective(User2project record);

    User2project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2project record);

    int updateByPrimaryKey(User2project record);

	void deleteAllByUserId(Integer userId);

	List<User2project> selectUser2projectsByUserid(Integer userId);
}
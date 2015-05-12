package com.cyou.gr.dao;

import java.util.List;

import com.cyou.gr.entity.User;
import com.cyou.gr.entity.vo.UserVo;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<UserVo> selectUserList();
}
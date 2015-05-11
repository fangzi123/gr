package com.cyou.gr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyou.gr.dao.UserMapper;
import com.cyou.gr.entity.User;
import com.cyou.gr.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

	@Override
	public User selectUserByName(String name) throws Exception {
		return userMapper.selectByName(name);
	}

}

package com.cyou.gr.service;

import com.cyou.gr.entity.User;


public interface UserService {
    public User selectUserByName(String name) throws Exception;
}

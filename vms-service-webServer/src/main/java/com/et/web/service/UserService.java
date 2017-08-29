package com.et.web.service;

import com.et.web.entity.User;

/**
 * Created by gaop on 2017/8/7.
 */
public interface UserService {

    public User getUser(String username,String password);
    public User getUserByUsername(String username);
}

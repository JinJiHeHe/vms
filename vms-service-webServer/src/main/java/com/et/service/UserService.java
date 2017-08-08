package com.et.service;

import com.et.entity.User;

/**
 * Created by gaop on 2017/8/7.
 */
public interface UserService {

    public User getUser(String username,String password);
}

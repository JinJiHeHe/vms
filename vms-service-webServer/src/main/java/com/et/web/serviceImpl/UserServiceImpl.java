package com.et.web.serviceImpl;

import com.et.web.dao.UserMapper;
import com.et.web.entity.User;
import com.et.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaop on 2017/8/7.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public User getUser(String username, String password) {
        System.out.println("username: "+username+" password:"+password);
         return userMapper.selectUser(username,password);
    }
}

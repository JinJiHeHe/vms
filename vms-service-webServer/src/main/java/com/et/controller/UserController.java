package com.et.controller;

import com.et.entity.User;
import com.et.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by gaop on 2017/8/7.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value="/login.do",method = RequestMethod.POST)
    public String login(String username,String password){
        System.out.println("username: "+username+" password:"+password);
        User user=userService.getUser(username,password);
        System.out.println("User:"+user);
        if(user!=null){

            return "index";
        }
        return "login";
    }
}

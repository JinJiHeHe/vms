package com.et.web.controller;

import com.et.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    @RequestMapping(value="/login.do",method = RequestMethod.GET)
    public String login(String username,String password){
        System.out.println("username: "+username+" password:"+password);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }
        catch (AuthenticationException e){
            e.printStackTrace();
            return "login";
        }

        return "index";
//        User user=userService.getUser(username,password);
//        System.out.println("User:"+user);
//        if(user!=null){
//
//            return "index";
//        }
//        return "login";
    }
}

package com.et.web.shiro;/**
 * Created by gaop on 2017/8/16.
 */

import com.et.web.entity.User;
import com.et.web.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @Description：shiro登入认证和授权
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/16 11:45
 */
public class MyShiroRealm extends AuthorizingRealm{
    @Resource
    private UserService userService;
    /*
     *  授权
     */

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollectio) {
         String currentUsername= (String)principalCollectio.getPrimaryPrincipal();
         System.out.println("授权...");
        User user=userService.getUserByUsername(currentUsername);
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addRole(user.getRole());
        return authorizationInfo;
    }
    /*
     *认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        User user=userService.getUserByUsername(username);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        return info;
    }
}

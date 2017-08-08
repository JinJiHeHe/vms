package com.et.dao;

import com.et.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by gaop on 2017/8/7.
 */
@Repository("userMapper")
public interface UserMapper {
@Select("select * from user u where u.username=#{0} and u.password=#{1}")
public User selectUser(String username,String password);
}

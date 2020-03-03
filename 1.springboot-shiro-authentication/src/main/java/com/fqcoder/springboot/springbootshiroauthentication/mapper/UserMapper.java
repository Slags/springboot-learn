package com.fqcoder.springboot.springbootshiroauthentication.mapper;

import com.fqcoder.springboot.springbootshiroauthentication.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/2/29 3:30
 * @Version 1.0
 */
public interface UserMapper {


    @Select("select * from tb_user where username=#{username}")
    User selectByName(String username);

}

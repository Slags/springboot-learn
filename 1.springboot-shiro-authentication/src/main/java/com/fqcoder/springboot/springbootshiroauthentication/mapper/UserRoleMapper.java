package com.fqcoder.springboot.springbootshiroauthentication.mapper;

import com.fqcoder.springboot.springbootshiroauthentication.model.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName UserRoleMapper
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 14:01
 * @Version 1.0
 */
public interface UserRoleMapper {

    /**
     *
     * 查询用户角色（可能一个用户有多个角色）
     * @param username
     * @return
     */
    @Select("select r.id,r.name,r.description from tb_role r " +
            "left join tb_user_role ur on(r.id = ur.role_id)" +
            "left join tb_user u on(u.id=ur.user_id)" +
            "where u.username =#{username}")
    List<Role> findByUserName(String username);

}

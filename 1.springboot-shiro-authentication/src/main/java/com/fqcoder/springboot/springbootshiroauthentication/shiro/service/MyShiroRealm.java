package com.fqcoder.springboot.springbootshiroauthentication.shiro.service;

import com.fqcoder.springboot.springbootshiroauthentication.mapper.RolePermissionMapper;
import com.fqcoder.springboot.springbootshiroauthentication.mapper.UserMapper;
import com.fqcoder.springboot.springbootshiroauthentication.mapper.UserRoleMapper;
import com.fqcoder.springboot.springbootshiroauthentication.model.Permission;
import com.fqcoder.springboot.springbootshiroauthentication.model.Role;
import com.fqcoder.springboot.springbootshiroauthentication.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MyShiroRealm
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/2/29 3:08
 * @Version 1.0
 */
@Service
public class MyShiroRealm  extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;



    /**
     * 获取用户角色和权限
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        if(principal == null){
            throw new AuthorizationException("principals should not be null");
        }
        User userInfo= (User) SecurityUtils.getSubject().getPrincipal();
        System.out.println("用户-->"+userInfo.getUsername()+"获取权限中");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //用户获取角色集
        List<Role> roleList=userRoleMapper.findByUserName(userInfo.getUsername());
        Set<String> roleSet=new HashSet<>();
        for (Role r:roleList){
            Integer roleId=r.getId();//获取角色id
            simpleAuthorizationInfo.addRole(r.getName());//添加角色名字
            List<Permission> permissionList=rolePermissionMapper.findByRoleId(roleId);
            for (Permission p:permissionList){
                //添加权限
                simpleAuthorizationInfo.addStringPermission(p.getName());
            }
        }

        System.out.println("角色为-> " + simpleAuthorizationInfo.getRoles());
        System.out.println("权限为-> " + simpleAuthorizationInfo.getStringPermissions());
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户输入的用户名密码
        String username= (String) token.getPrincipal();
        String password=new String((char[])token.getCredentials());

        System.out.println("用户输入--->username:"+username+"-->password:"+password);

        //在数据库中查询
        User userInfo=userMapper.selectByName(username);
        if (userInfo == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(userInfo.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, // 用户名
                userInfo.getPassword(), // 密码
                getName() // realm name
        );
        return authenticationInfo;
    }
}

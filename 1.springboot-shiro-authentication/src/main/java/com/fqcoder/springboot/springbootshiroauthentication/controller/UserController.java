package com.fqcoder.springboot.springbootshiroauthentication.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 15:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequiresPermissions("user:queryAll")
    @GetMapping("/queryAll")
    public String queryAll(){

        //只演示框架...功能不实现
        return "查询列表";
    }

    @RequiresPermissions("user:add")
    @GetMapping("/add")
    public String userAdd(){
        return "添加用户";
    }

    @RequiresPermissions("user:delete")
    @GetMapping("/delete")
    public String userDelete(){
        return "删除用户";
    }
}

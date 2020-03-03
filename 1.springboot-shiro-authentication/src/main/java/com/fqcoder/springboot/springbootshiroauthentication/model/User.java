package com.fqcoder.springboot.springbootshiroauthentication.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/2/29 3:31
 * @Version 1.0
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private Integer status;
}

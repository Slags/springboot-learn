package com.fqcoder.springboot.springbootshiroauthentication.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 13:55
 * @Version 1.0
 */
@Data
public class Role  implements Serializable {

    private Integer id;

    private String name;

    private String description;
}

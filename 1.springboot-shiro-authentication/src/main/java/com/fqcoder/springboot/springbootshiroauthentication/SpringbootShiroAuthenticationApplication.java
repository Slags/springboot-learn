package com.fqcoder.springboot.springbootshiroauthentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.fqcoder.springboot.springbootshiroauthentication.mapper")
public class SpringbootShiroAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroAuthenticationApplication.class, args);
    }

}

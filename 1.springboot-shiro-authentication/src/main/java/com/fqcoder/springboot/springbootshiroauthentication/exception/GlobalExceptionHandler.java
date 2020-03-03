package com.fqcoder.springboot.springbootshiroauthentication.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 15:44
 * @Version 1.0
 */
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException() {
        return "403";
    }
}

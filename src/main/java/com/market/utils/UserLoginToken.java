package com.market.utils;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType; 

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * 需要登录才能进行操作的注解UserLoginToken
 * @author Administrator
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}

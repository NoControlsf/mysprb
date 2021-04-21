package com.mysprb.mysprb.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * 请求数据解密
 * Created by shenfeng on 2021-4-19.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface SecurityParameter {
    //入参是否解密，默认解密
    boolean inDecode() default false;
    //出参是否加密，默认加密
    boolean outEncode() default false;
}
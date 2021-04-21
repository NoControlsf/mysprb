package com.mysprb.mysprb.utils.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysprb.mysprb.annotation.SecurityParameter;
import com.mysprb.mysprb.utils.AesEncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回数据加密
 * Created by shenfeng on 2021-4-19.
 */
@ControllerAdvice(basePackages = {"com.xbx.acc.controller"})
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {
    private static final Logger logger= LoggerFactory.getLogger("EncodeResponseBodyAdvice");
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        boolean encode=false;
        if(methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class)){
            //获取注解配置的包含的去除字段
            SecurityParameter securityParameter = methodParameter.getMethodAnnotation(SecurityParameter.class);
            encode=securityParameter.outEncode();
        }
        if(encode){
            logger.info("--对方法"+methodParameter.getMethod().getName()+"数据进行加密");
            ObjectMapper objectMapper=new ObjectMapper();
            try{
                String result=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                return AesEncryptUtils.encrypt(result);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("对方法"+methodParameter.getMethod().getName()+"数据进行加密异常:"+e.getMessage());
            }
        }
        return body;
    }
}

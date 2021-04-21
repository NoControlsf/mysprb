package com.mysprb.mysprb.utils.aop;

import com.mysprb.mysprb.annotation.SecurityParameter;
import com.mysprb.mysprb.utils.AesEncryptUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * Created by shenfeng on 2021-4-19.
 */
@ControllerAdvice(basePackages = {"com.xbx.acc.controller"})
public class DecodeRequestBodyAdvice implements RequestBodyAdvice {
    private static final Logger logger= LoggerFactory.getLogger("DecodeRequestBodyAdvice");
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        try{
            boolean encode=false;
            if(methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class)){
                //获取注解配置的包含和去除字段
                SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
                //入参是否需要解密
                encode=serializedField.inDecode();
            }
            if(encode){
                //入参需要解密
                logger.info("--对方法"+methodParameter.getMethod().getName()+"数据进行解密");
                return new MyHttpInputMessage(httpInputMessage);
            }else{
                return httpInputMessage;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("--对方法"+methodParameter.getMethod().getName()+"数据进行解密异常:"+e.getMessage());
            return httpInputMessage;
        }
//        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    class MyHttpInputMessage implements HttpInputMessage {
        private HttpHeaders headers;
        private InputStream body;

        public MyHttpInputMessage(HttpInputMessage httpInputMessage) throws Exception {
            this.headers=httpInputMessage.getHeaders();
            this.body= IOUtils.toInputStream(AesEncryptUtils.decrypt(easpString(IOUtils.toString(httpInputMessage.getBody(),"utf-8"))),"utf-8");
        }

        @Override
        public InputStream getBody() throws IOException {
            return body;
        }

        @Override
        public HttpHeaders getHeaders() {
            return headers;
        }
        public String easpString(String requestData){
            System.out.println("--requestData:"+requestData);
//            if(!Strings.isNullOrEmpty(requestData)){
//                String str="{\"requestData\":";
//                logger.info("--requestBody"+this.body);
//                if(!requestData.startsWith(str)){
//                    throw new RuntimeException("参数【requestData】缺失异常");
//                }else{
//                    int closeLen=requestData.length()-1;
//                    int openLen=str.length();
//                    String substring= StringUtils.substring(requestData,openLen,closeLen);
//                    return substring;
//                }
//            }
            return requestData;
        }
    }
}
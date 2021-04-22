package com.mysprb.mysprb.utils.interceptor;

import com.mysprb.mysprb.utils.AesEncryptUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Value("${encrypt.urls}")
    private String[] urlList;

    @Override
    public void apply(RequestTemplate template) {
        if (Arrays.asList(urlList).contains(template.url())) {//根据URL地址过滤请求
            log.info("请求参数为：{}", template.requestBody().asString());
            String param = template.requestBody().asString();
            try {
                // 加密
                param = AesEncryptUtils.encrypt(param);
            } catch (Exception e) {
                e.printStackTrace();
            }
            template.body(param);
            log.info("加密后参数为：{}", template.requestBody().asString());//?param=xxxxxx
        }
    }
}
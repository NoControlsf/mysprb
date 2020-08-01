package com.mysprb.mysprb.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
    /**
     * 定制mybatis 与配置文件二选一，一般配置文件就足够了
     * @return
     */
    /*@Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 设置驼峰命名和下划线命名的映射
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }*/
}

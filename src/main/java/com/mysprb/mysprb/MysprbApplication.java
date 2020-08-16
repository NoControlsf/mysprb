package com.mysprb.mysprb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 批量扫描mybatis的映射文件
 */
//@MapperScan(value = "com.mysprb.mysprb.mappers")
@SpringBootApplication
/**
 * 开启基于注解的缓存
 */
@EnableCaching
public class MysprbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysprbApplication.class, args);
	}

}


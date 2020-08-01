package com.mysprb.mysprb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 批量扫描mybatis的映射文件
 */
//@MapperScan(value = "com.mysprb.mysprb.mappers")
@SpringBootApplication
public class MysprbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysprbApplication.class, args);
	}

}


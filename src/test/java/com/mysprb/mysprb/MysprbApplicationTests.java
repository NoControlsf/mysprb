package com.mysprb.mysprb;

import org.springframework.boot.test.context.SpringBootTest;
/*import com.mysprb.mysprb.bean.MyBean;
import com.mysprb.mysprb.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;*/

import org.junit.Test;

//@RunWith(SpringRunner.class)
@SpringBootTest
//避免冲突
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MysprbApplicationTests {

	@Test
	public void test() {

	}
	/*@Autowired
	MyBean myBean;

	//日志记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		System.out.println(myBean);
		//日志记录
		logger.info(myBean.toString());

		//日志输出级别
		//logger.trace("跟踪信息");
		//logger.debug("");
		//logger.info("");
		//logger.warn("");
		//logger.error("");

	}

	@Autowired
	StringRedisTemplate stringRedisTemplate;    // 操作k-v都是字符串的

	*//**
	 * Redis常见的五大类型
	 * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
	 *          stringRedisTemplate.opsForValue();
	 *         stringRedisTemplate.opsForList();
	 *         stringRedisTemplate.opsForSet();
	 *         stringRedisTemplate.opsForHash();
	 *         stringRedisTemplate.opsForZSet();
	 *//*
	@Test
	public void test01(){
		//stringRedisTemplate.opsForValue().append("msg", "沈峰");
		String res = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(res);
	}

	@Autowired
	RedisTemplate redisTemplate;    // 操作k-v都是对象的
	@Autowired
	CacheService cacheService;

	@Test
	public void test02(){

		redisTemplate.opsForValue().set("employee",cacheService.getEmp(1));
		Object res = redisTemplate.opsForValue().get("employee");
		System.out.println(res.toString());
	}

	@Autowired
	RedisTemplate strRedisTemplate;    // 操作k-v都是对象的
	*//**
	 * 自定义序列化
	 *//*
	@Test
	public void test03(){

		strRedisTemplate.opsForValue().set("employee",cacheService.getEmp(1));
		Object res = strRedisTemplate.opsForValue().get("employee");
		System.out.println(res.toString());
	}*/

}


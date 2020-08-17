package com.mysprb.mysprb;

import com.mysprb.mysprb.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
//避免冲突
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisAppticationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;    // 操作k-v都是字符串的

    /**
     * Redis常见的五大类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *          stringRedisTemplate.opsForValue();
     *         stringRedisTemplate.opsForList();
     *         stringRedisTemplate.opsForSet();
     *         stringRedisTemplate.opsForHash();
     *         stringRedisTemplate.opsForZSet();
     */
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
    /**
     * 自定义序列化
     */
    @Test
    public void test03(){

        strRedisTemplate.opsForValue().set("employee",cacheService.getEmp(1));
        Object res = strRedisTemplate.opsForValue().get("employee");
        System.out.println(res.toString());
    }

}

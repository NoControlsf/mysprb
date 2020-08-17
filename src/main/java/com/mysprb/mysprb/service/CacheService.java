package com.mysprb.mysprb.service;

import com.mysprb.mysprb.bean.Employee;
import com.mysprb.mysprb.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @CacheConfig(cacheNames = "emp") 公共配置
 */
//@CacheConfig(cacheNames = "emp")
@Service
public class CacheService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存,以后再要相同的数据，直接从缓存中获取
     *
     * CacheManager管理多个cache组件，对缓存的真正的CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字
     * 几个属性
     *      cacheNames/value: 缓存的名字
     *      key: 缓存数据使用的key，可以用它来指定，默认使用方法参数的值 1-方法的返回值
     *          编写SpEL #id: 参数id的值  等同 #a0 #p0 #root.args[0]
     *                  #result: 返回结果的值
     *      keyGenerator: key的生成器；可以自己指定key的生成器的组件id
     *          key和keyGenerator二选一
     *      cacheManager:指定缓存管理器，或者指定cacheResolver指定缓存解析器 二选一
     *      condition: 指定符合条件的情况下才缓存
     *          condition = "#id > 0"
     *      unless: 否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *          unless = "#result == null"
     *      sync: 缓存是否使用异步模式
     *
     *  原理：
     *      1、自动配置类： CacheAutoConfiguration
     *      2、缓存配置类：
     *          org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *
     *          //被CaffeineCacheConfiguration代替，不再使用
     *          org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
     *
     *          org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *      3、哪个配置类默认生效：SimpleCacheConfiguration
     *      4、给容器中注册了一个CacheManager缓存管理器: ConcurrentMapCacheManager
     *      5、可以获取和创建ConcurrentMapCache类型的缓存组件
     *
     *  运行流程：
     * @Cacheable
     * 1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取
     *    （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     * 2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数
     *    key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key：
     *      SimpleKeyGenerator生成key的默认策略：
     *          如果没有参数： key=new SimpleKey();
     *          如果有一个参数： key=参数的值
     *          如果有多个参数： key=new SimpleKey(params);
     * 3、没有查到缓存就调用目标方法；
     * 4、将目标方法返回的结果，放到缓存中
     *
     *
     * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存
     * 如果没有就运行方法并将结果放入缓存，以后再来调用就可以直接使用缓存中的数据
     *
     * 核心：
     *      1、使用CacheManager(ConcurrentMapCacheManager)按照名字得到Cache（ConcurrentMapCache）组件
     *      2、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     *
     * @param id
     * @return
     */
    // @Cacheable(cacheNames = "emp", key = "#root.args[0]")
    // @Cacheable(cacheNames = {"emp","temp"}, key = "#id")
    // @Cacheable(cacheNames = {"emp","temp"}, condition = "#id > 0", unless = "#result == null")
    @Cacheable(cacheNames = "emp", unless = "#result == null")
    public Employee getEmp(int id){
        System.out.println("查询" + id + "号员工");
        return  employeeMapper.getEmpById(id);
    }

    /**
     * @CachePut: 即调用方法，又更新缓存数据
     * 修改了数据库的某个数据，同时更新缓存
     * 运行时机：
     * 1、先调用目标方法
     * 2、将目标方法的结果缓存起来
     */
    // http://localhost:8080/cache?id=1&lastName=Jack
    //@CachePut(cacheNames = "emp", key = "#employee.id")
    @CachePut(cacheNames = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict： 缓存清除
     * @param id
     * @return
     */
    // @CacheEvict(cacheNames = "emp", allEntries = true) 清除所有缓存
    // beforeInvocation = false 是否在方法执行之前 默认false
    //@CacheEvict(cacheNames = "emp", key = "#id", beforeInvocation = false)
    @CacheEvict(cacheNames = "emp", key = "#id", beforeInvocation = false)
    public String deleteEmp(int id){
        System.out.println("删除" + id + "号员工");
        int res = employeeMapper.deleteEmpById(id);
        if(res == 0){
            return "delete fail";
        }
        return "delete success";
    }

    /**
     * @Caching 缓存组合
     * @param employee
     * @return
     */
    /*@Caching(
            cacheable = {
                    @Cacheable(cacheNames = "emp")
            },
            put = {
                   @CachePut(cacheNames = "emp")
            }
    )*/
    public Employee insertEmp(Employee employee){
        System.out.println("insertEmp:" + employee);
        employeeMapper.insertEmp(employee);
        return employee;
    }
}

package com.mysprb.mysprb.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Administrator on 2018/12/26.
 */
//@RestController注解能够使项目支持Rest
@RestController
//@Controller
@SpringBootApplication
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/")
public class UserController {
    @RequestMapping("/homepage")
    public ModelAndView index(Map<String, Object> map){
        map.put("user", "Tyrone");
        ModelAndView mv = new ModelAndView();
        mv.addAllObjects(map);
        return mv;
    }

    @RequestMapping("/websocketpage")
    public ModelAndView websocketpage(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    //@ResponseBody
    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    //@ResponseBody
    //通过RequestMethod.POST表示请求需要时POST方式
    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    //@ResponseBody
    //在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体
    //目前主流的请求报文也都是JSON格式了，使用该注解就能够获取整个JSON报文体作为入参，使用JSON解析工具解析后获取具体的参数
    @RequestMapping(value = "/getUserByJson", method = RequestMethod.POST)
    String getUserByJson(@RequestBody String data){
        return "Json is " + data;
    }
}

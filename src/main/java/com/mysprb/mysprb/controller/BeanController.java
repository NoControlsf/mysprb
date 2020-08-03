package com.mysprb.mysprb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {
    @RequestMapping("/getMyBean")
    public Object getMyBean(){
        return "";
    }
}

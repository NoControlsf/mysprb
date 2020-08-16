package com.mysprb.mysprb.controller;

import com.mysprb.mysprb.bean.Employee;
import com.mysprb.mysprb.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/cache/query/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
        return cacheService.getEmp(id);
    }

    @PutMapping("/cache/update")
    public Employee updateEmployee(Employee employee){
        return cacheService.updateEmp(employee);
    }

    @PostMapping("/cache/insert")
    public Employee insertEmployee(Employee employee){
        return cacheService.insertEmp(employee);
    }

    @DeleteMapping("/cache/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return cacheService.deleteEmp(id);
    }
}

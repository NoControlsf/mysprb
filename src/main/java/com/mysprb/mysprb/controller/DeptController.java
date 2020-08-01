package com.mysprb.mysprb.controller;

import com.mysprb.mysprb.bean.Department;
import com.mysprb.mysprb.bean.Employee;
import com.mysprb.mysprb.mappers.DepartmentMapper;
import com.mysprb.mysprb.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") int id){
        return departmentMapper.getDeptById(id);
    }

    /**
     *  例：http://localhost:8080/dept?departmentName=家
     * @param department
     * @return
     */
    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") int id){
        return employeeMapper.getEmpById(id);
    }
}

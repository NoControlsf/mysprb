package com.mysprb.mysprb.mappers;

import com.mysprb.mysprb.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee getEmpById(int id);

    public void insertEmp(Employee employee);
}

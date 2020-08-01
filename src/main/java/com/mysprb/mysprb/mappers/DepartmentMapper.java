package com.mysprb.mysprb.mappers;

import com.mysprb.mysprb.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(int id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(int id);

    /**
     * useGeneratedKeys = true 使用自动生成的主键 默认是id
     * @param department
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}

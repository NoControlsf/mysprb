package com.mysprb.mysprb.entity;

import javax.persistence.*;

/**
 * JPA使用案例 使用JPA注解配置映射关系
 */
@Entity // 和数据表映射的类
@Table(name = "tbl_user") // 数据表名称 如果不写，默认与类名一致（配置完后会自动创建）
public class User {
    @Id // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private int id;
    @Column(name = "last_name", length = 50) // 这是和数据表对应的一列
    private String lastName;
    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

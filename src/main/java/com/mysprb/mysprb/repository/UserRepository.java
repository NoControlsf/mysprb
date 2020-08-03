package com.mysprb.mysprb.repository;

import com.mysprb.mysprb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository<User, Integer>  泛型包含 类名 主键类型
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}

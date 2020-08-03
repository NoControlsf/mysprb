package com.mysprb.mysprb.controller;

import com.mysprb.mysprb.entity.User;
import com.mysprb.mysprb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        // 通过主键查找如果找不到返回空
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 例：http://localhost:8080/user?lastName=%E5%BC%A0%E4%B8%89&email=33232@ss.com
     * @param user
     * @return
     */
    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}

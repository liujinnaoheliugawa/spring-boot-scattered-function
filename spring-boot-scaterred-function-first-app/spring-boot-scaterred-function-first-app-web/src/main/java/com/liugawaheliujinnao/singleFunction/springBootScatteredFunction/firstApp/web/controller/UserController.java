package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.web.controller;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.model.domain.User;
import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户控制器
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //保存使用 Spring Web MVC
    @PostMapping("/user/save")
    public User user(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}

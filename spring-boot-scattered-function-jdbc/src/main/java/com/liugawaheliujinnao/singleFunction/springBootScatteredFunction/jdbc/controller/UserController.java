package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.controller;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.domain.User;
import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description: 用户 RestController on WebMVC
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(() -> {
            return userRepository.save(user);
        });
        System.out.println("User Controller Thread name is " + Thread.currentThread().getName());
        return future.get();
    }
}

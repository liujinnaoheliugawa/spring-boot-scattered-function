package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.webflux;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.domain.User;
import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Component
public class UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        // 在 Spring Web MVC 中使用 @RequestBody
        // 在 Spring Web Flux 使用 ServerRequest
        // Mono<User> 类似于 Optional<User>
        System.out.println("User Handler Thread name is " + Thread.currentThread().getName());
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        // map 相当于转换工作
        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
        return ServerResponse.ok().body(booleanMono, Boolean.class);
    }
}

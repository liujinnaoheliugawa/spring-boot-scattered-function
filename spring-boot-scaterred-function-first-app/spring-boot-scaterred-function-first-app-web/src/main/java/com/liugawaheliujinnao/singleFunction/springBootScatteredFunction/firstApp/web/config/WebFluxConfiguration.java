package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.web.config;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.model.domain.User;
import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @Description: Web Flux 参数
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routerFunctionUsers(UserRepository userRepository) {
        Collection<User> users = userRepository.findAll();
        Flux<User> userFlux = Flux.fromIterable(users);
        return RouterFunctions.route(RequestPredicates.path("/users"),
                request -> ServerResponse.ok().body(userFlux, User.class));
    }
}

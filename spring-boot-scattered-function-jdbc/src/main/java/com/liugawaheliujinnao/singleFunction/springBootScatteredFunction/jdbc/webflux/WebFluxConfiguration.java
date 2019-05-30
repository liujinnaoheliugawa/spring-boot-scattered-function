package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.jdbc.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Description: Web Flux 配置
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userHandler) {
        System.out.println("Flux User Thread name is " + Thread.currentThread().getName());
        return route(POST("/web/flux/user/save"), userHandler::save);
    }
}

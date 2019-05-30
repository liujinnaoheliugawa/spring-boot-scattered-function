package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.firstApp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
public class SpringBootScatteredFunctionFirstAppWebApplication {

    public static void main( String[] args ) {
        SpringApplication springApplication = new SpringApplication(SpringBootScatteredFunctionFirstAppWebApplication.class);
        springApplication.run(args);
    }
}

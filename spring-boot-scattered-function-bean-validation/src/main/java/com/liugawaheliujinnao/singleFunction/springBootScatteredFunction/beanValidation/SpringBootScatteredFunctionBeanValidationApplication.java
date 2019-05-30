package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.web.UserControllerInterInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
public class SpringBootScatteredFunctionBeanValidationApplication  implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScatteredFunctionBeanValidationApplication.class, args);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserControllerInterInterceptor());
    }
}

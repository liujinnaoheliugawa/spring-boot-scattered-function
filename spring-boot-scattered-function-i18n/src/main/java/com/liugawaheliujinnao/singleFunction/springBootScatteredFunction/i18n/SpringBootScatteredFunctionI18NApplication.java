package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javaee")
public class SpringBootScatteredFunctionI18NApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScatteredFunctionI18NApplication.class, args);
    }
}

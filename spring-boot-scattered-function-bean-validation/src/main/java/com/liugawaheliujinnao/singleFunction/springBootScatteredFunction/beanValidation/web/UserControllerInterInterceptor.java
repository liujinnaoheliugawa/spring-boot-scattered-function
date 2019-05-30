package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.web;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Component
public class UserControllerInterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //把校验逻辑存放在这里
        return true;
    }

    //转换400 -> 200
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        Integer status = response.getStatus();
        if (status == HttpStatus.BAD_REQUEST.value()) {
            response.setStatus(HttpStatus.OK.value());
        }
    }
}

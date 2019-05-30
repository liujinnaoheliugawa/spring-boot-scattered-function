package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.spring.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestControllerAdvice(basePackages = "com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.spring.webmvc.controller")
public class RestControllerAdviser {

    @ExceptionHandler(value = {
            NullPointerException.class
            ,IllegalAccessException.class
            ,IllegalStateException.class})
    public Object handlerNPE(Throwable throwable) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", throwable.getMessage());
        return data;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object pageNotFound(HttpStatus status, HttpServletRequest request, Throwable throwable) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));
        return errors;
    }
}

package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Controller
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "index";
    }
}

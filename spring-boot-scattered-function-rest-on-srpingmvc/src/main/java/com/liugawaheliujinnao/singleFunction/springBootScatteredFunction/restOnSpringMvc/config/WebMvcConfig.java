package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.restOnSpringMvc.config;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.restOnSpringMvc.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.set(0, new MappingJackson2XmlHttpMessageConverter());
        converters.add(new PropertiesPersonHttpMessageConverter());
    }
}

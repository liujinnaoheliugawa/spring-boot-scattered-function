package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.spring;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

/**
 * @Description: {@link ResourceBundleMessageSource}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class ResourceBundleMessageSourceDemo {

    public static void main(String[] args) {
        String baseName = "static.default";
        //ResourceBundle + MessageFormat => MessageSource
        //不能重载
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //可以重载
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(baseName);
        System.out.println(messageSource.getMessage("message", new Object[]{"World"}, Locale.getDefault()));
    }
}

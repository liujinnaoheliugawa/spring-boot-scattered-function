package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javase;

import java.util.Locale;

/**
 * @Description: {@link Locale}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class LocaleDemo {

    public static void main(String[] args) {
        //安全 PropertyPermission
        //通过启动参数调整 -D => System.getProperty（"name","value");
        //硬编码调整 en_US，写死了，无法做到一份代码到处运行
        //Locale.setDefault(Locale.US);
        //输入默认 Locale
        System.out.println(Locale.getDefault());
        //通过构造器方式修改
        Locale locale = new Locale("en");

    }
}

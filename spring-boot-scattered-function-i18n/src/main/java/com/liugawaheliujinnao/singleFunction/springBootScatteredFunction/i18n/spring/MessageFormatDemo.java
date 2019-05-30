package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.spring;

import java.text.MessageFormat;

/**
 * @Description: {@link MessageFormat} 示例
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class MessageFormatDemo {

    public static void main(String[] args) {
        MessageFormat format = new MessageFormat("Hello, {0}, {1}!");
        System.out.println(format.format(new Object[]{"World", "Gupao"}));
    }
}

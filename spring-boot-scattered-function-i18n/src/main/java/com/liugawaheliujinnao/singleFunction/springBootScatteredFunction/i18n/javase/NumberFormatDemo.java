package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javase;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @Description: {@link NumberFormat}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class NumberFormatDemo {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(10000));

        numberFormat = NumberFormat.getNumberInstance(Locale.FRANCE);
        System.out.println(numberFormat.format(10000));
    }
}

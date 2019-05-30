package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: {@link DateFormat} 示例
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class DateFormatDemo implements Runnable {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
        new Thread(new DateFormatDemo()).start();
    }

    @Override
    public void run() { //重进入 ReentrantLock
        System.out.println(dateFormat.format(new Date()));
    }
}

package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.domain;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.validation.ValidCardNumber;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @Description: 用户模型
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class User {

    @Max(value = 10000)
    private long id;

    @NotNull
    //@NonNull @Lombok APT JSR305
    private String name;

    //卡号 -- GUPAO-123456789
    @NotNull
    @ValidCardNumber
    private String cardNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}

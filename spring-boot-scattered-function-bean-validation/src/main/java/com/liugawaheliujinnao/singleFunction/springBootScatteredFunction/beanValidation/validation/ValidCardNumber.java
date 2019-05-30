package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description: 合法 卡号 校验
 * 规则：
 * 通过员工的卡号来校验，需要通过工号的前缀和后缀来判断
 * 前缀必须以“GUPAO-”开头，后缀必须数字
 * 需要通过 Bean Validator 来校验
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(
        validatedBy = {ValidCardNumberConstraintValidator.class}
)
public @interface ValidCardNumber {

    String message() default "{com.liugawaheliujinnao.bean.validation.invalid.card.number.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

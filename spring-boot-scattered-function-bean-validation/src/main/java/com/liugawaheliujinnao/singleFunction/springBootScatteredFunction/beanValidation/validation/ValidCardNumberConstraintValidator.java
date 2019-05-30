package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.beanValidation.validation;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * @Description: {@link ValidCardNumber} {@link ConstraintValidator} 实现
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class ValidCardNumberConstraintValidator implements ConstraintValidator<ValidCardNumber, String> {

    @Override
    public void initialize(ValidCardNumber constraintAnnotation) {

    }

    /**
     * 规则：
     * 通过员工的卡号来校验，需要通过工号的前缀和后缀来判断
     * 前缀必须以“GUPAO-”开头，后缀必须数字
     * 需要通过 Bean Validator 来校验
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        //前半部分和后半部分
        String[] parts = StringUtils.split(s, "-");
        //为什么不用 String#split 方法，原因在于该方法使用了正则表达式
        //其次是 NPE 保护不够
        //如果在依赖中，没有 StringUtils.delimitedListToStringArray API 的话，可以使用
        //JDK 里面 StringTokenizer（不足类似于枚举 Enumeration API）
        //Apache commons-lang StringUtils
        if (ArrayUtils.getLength(parts) != 2) { //分割
            return false;
        }
        String prefix = parts[0];
        String suffix = parts[1];
        boolean isValidPrefix = Objects.equals(prefix, "GUPAO");
        boolean isValidInteger = StringUtils.isNumeric(suffix);
        return isValidPrefix && isValidInteger;
    }
}

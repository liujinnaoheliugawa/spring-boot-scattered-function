package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javase;

import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class EncodingResourceBundleControlProvider implements ResourceBundleControlProvider {

    @Override
    public ResourceBundle.Control getControl(String baseName) {
        return new ResourceBundleDemo.EncodedControl();
    }
}

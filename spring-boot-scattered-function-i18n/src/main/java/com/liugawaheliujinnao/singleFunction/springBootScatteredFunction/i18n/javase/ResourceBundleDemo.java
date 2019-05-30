package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.i18n.javase;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @Description: {@link ResourceBundle} 示例
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class ResourceBundleDemo {

    /**
     * ResourceBundle 实现，查找 properties 文件中的国际化内容
     * 默认实现是采用 ISO 8859-1，所以凡是出现中文就会乱码
     * 方法一：可以采用 native2ascii 方法，将打包后的资源文件进行转义，而不是直接在源码的方面解决，不好控制
     * 方法二：since Java 1.6，扩展 {@link ResourceBundle.Control}
     * 缺点：可移植性不强，不得不显式地传递 {@link ResourceBundle.Control}
     * 方法三：since Java 1.8，实现 ResourceBundleControlProvider
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        //package（目录） + resource 名称（不包含.properties）
        String baseName = "static.default";
        //基于 Java 1.6
        //显式地传递 EncodedControl
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, new EncodedControl("GBK"));
//        System.out.println(resourceBundle.getString("name"));
        //-Dfile.encoding=UTF-8 无效
        //native2ascii -> Unicode，只能作用于打包后的 class 文件
        //不显式传递，使用默认 ResourceBundleControlProvider spi 机制
//        resourceBundle = ResourceBundle.getBundle(baseName);
        System.out.println(resourceBundle.getString("name"));
    }

    {
        //PropertyResourceBundle -> new PropertyResourceBundle(InputStream);
//        ClassLoader classLoader = ResourceBundleDemo.class.getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("static/default_zh_CN.properties"); //字节流
//        Reader reader = new InputStreamReader(inputStream, "GBK"); //字符流，IDEA 中可以查看文件格式
//        ResourceBundle propertyResourceBundle = new PropertyResourceBundle(reader);
//        System.out.println("propertyResourceBundle.name : " + propertyResourceBundle.getString("name"));
    }

    public static class EncodedControl extends ResourceBundle.Control {

        private final String encoding;

        public EncodedControl(String encoding) {
            this.encoding = encoding;
        }

        public EncodedControl() {
            this("GBK");
        }

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format,
                                        ClassLoader loader, boolean reload)
                throws IOException {
            //资源查找规则
            String bundleName = toBundleName(baseName, locale);
            ResourceBundle bundle = null;
            final String resourceName = toResourceName(bundleName, "properties");
            if (resourceName == null) {
                return bundle;
            }
            final ClassLoader classLoader = loader;
            InputStream stream = classLoader.getResourceAsStream(resourceName);
            Reader reader = new InputStreamReader(stream, encoding);
            if (reader != null) {
                try {
                    bundle = new PropertyResourceBundle(reader);
                } finally {
                    reader.close();
                    stream.close();
                }
            }
            return bundle;
        }
    }
}

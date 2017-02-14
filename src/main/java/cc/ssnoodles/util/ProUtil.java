package cc.ssnoodles.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Filename: ProUtil
 * Description: 配置工具
 * Copyright: Copyright (c)2016
 *
 * @author: ssnoodles
 * @version: 1.0 Create at: 2017-01-05 22:56
 * <p/>
 * Modification History: Date Author Version Description
 * ------------------------------------------------------------------
 * 2017-01-05 ssnoodles 1.0 1.0 Version
 */
public class ProUtil {
    private static final String FILENAME = "app.properties";
    private static final String CODE = "gbk";
    private static Properties properties = new Properties();


    public static Properties getProperties() {
        return properties;
    }

    /**
     * 先加载外部文件，再加载内部.
     */
    static {
        getFromOutSide();
        if (properties == null) {
            getFromClasspath();
        }
    }

    /**
     *  classpath
     */
    public static void getFromClasspath() {
        try {
            properties.load(new InputStreamReader(
                    ProUtil.class.getClassLoader().getResourceAsStream(FILENAME), CODE));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  外部文件
     */
    public static void getFromOutSide() {
        try {
            properties.load(new InputStreamReader(new FileInputStream(FILENAME), CODE));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

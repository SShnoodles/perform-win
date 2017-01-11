package cc.ssnoodles.util;

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
    /**
     *  根据Key读取Value
     */
    public static String getValue(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(
                    ProUtil.class.getClassLoader().getResourceAsStream("app.properties"), "gbk"));
            return properties.getProperty(key);
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

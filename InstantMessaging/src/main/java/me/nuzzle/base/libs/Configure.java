package me.nuzzle.base.libs;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DESCRIPTION:
 *
 * @author:Jimmy.zhang
 */
public class Configure {

    private static Properties properties;

    static {
        InputStream is = Configure.class.getClassLoader().getResourceAsStream("config.properties");
        properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getString(String key) {
        return properties.getProperty(key, null);
    }

    public static String getString(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static int getInteger(String key, int defaultValue) {
        return NumberUtils.toInt(properties.getProperty(key), defaultValue);
    }
}

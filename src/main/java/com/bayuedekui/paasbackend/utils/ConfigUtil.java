package com.bayuedekui.paasbackend.utils;


import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static Properties properties=null;
    private static String configProperties = "application.properties";

    static{
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(configProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfigProperty(String key){
        return properties.getProperty(key);
    }



}

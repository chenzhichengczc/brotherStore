package com.brother.util;

import com.sun.istack.internal.Nullable;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PropertiesUtil {

    private static PropertiesUtil getPropValueIstance; //本类自己实例
    private static Properties properties = new Properties();
    private static InputStream is;

    /**
     * 获取本类对象(单例模式)
     * @return 本类对象
     */
    public static PropertiesUtil getInstance(){
        if(getPropValueIstance == null){
            getPropValueIstance = new PropertiesUtil();
        }
        return getPropValueIstance;
    }

    /**
     * 返回properties文件中属性的值
     * @param path properties文件路径
     * @param PropertyName properties文件中的属性名
     * @return properties文件中属性的值
     */
    public static String getValue(String path, String PropertyName){
        try {
            is = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
            properties.load(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常:路径或文件名有误!路径前请不要加\"/\"");
        }
        String propertyValue = (String) properties.get(PropertyName);
        return propertyValue;
    }

}

package com.bayuedekui.paasbackend.utils;

import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * 转化请求参数的工具类
 */
public class HttpServletRequestUtil {

    /**
     * 将请求过来的参数转化为int类型整数
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.parseInt(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    /**
     * 将请求中做的key转化为Long类型的数据
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request,String key){
        try {
            return Long.parseLong(request.getParameter(key));
        }catch(Exception e){
            return -1;
        }
        
    }

    /**
     * 将key类型的数据转化为Double类型的数据
     * @param request
     * @param key
     * @return
     */
    public static double getDouble(HttpServletRequest request,String key){
        try {
            return Double.parseDouble(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    /**
     * 将key 类型的数据转化为Boolean类型的数据
     * @param request
     * @param key
     * @return
     */
    public static boolean getBoolean(HttpServletRequest request,String key){
        try {
            return Boolean.parseBoolean(request.getParameter(key)); //采用Boolean.valueOf()返回的是Boolean对象,而不是基本数据类型
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 将key类型的数据转化为string类型的数据
     * @return
     */
    public static String getString(HttpServletRequest request ,String key){
        try {
            String result = request.getParameter(key);
            if(result !=null){
                return result.trim();
            }
            if("".equals(result)){
                return null;
            }
            return result;
        }catch (Exception e){
            return null;            
        }
    }
    
    
    
    
}

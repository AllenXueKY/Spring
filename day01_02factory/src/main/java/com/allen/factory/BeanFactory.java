package com.allen.factory;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 *      javaBean > 实体类
 *    他就是创建我们的service和dao对象的
 *
 *    第一个，需要配置文件来配置我们的service和dao
 *          配置的内容，唯一标识=全限定类名（key=value）
 *    第二个，通过配置文件中配置的内容，反射创建对象
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定于一个Map，用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象，并加载
            props.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据Bean的名称获取Bean对象
     * @param beanName
     * @return
     */
   /* public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

}

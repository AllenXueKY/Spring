package com.allen.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean 在计算机英语中，有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 *      javaBean > 实体类
 *
 *  它就是创建我们的service和dao对象的。
 *
 *  第一个，需要一个配置文件来配置service和dao
 *          配置的内容：唯一标识=全限定类名（key=value）
 *  第二个，通过读取配置文件中的配置的内容，反射创建对象
 *
 *  配置文件可以是xml，也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //使用静态代码块为Properties对象赋值
    static {
        //实例化对象
        props = new Properties();
        //获取properties文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}

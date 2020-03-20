package com.allen.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3、执行操作
        jdbcTemplate.execute("insert into account(name,money)VALUES('ddd',2222)");
        /*//准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?useSSL=false&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("991104");

        //1、创建对象
        JdbcTemplate template = new JdbcTemplate();
        //给template设置数据源
        template.setDataSource(ds);
        //2、执行操作
        template.execute("insert into account(name,money)VALUES('ccc',1000)");*/
    }
}

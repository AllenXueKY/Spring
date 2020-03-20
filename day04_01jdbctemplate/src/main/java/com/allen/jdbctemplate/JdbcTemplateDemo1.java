package com.allen.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
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
        template.execute("insert into account(name,money)VALUES('ccc',1000)");
    }
}

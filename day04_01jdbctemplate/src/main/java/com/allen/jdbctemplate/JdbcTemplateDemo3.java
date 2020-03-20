package com.allen.jdbctemplate;

import com.allen.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3、执行操作
        //保存
//        jdbcTemplate.update("insert into account(name,money) values(?,?) ","eee",3333f);
        //更新
//        jdbcTemplate.update("update account set name=?,money=? where id=?","allen",4567,7);
        //删除
//        jdbcTemplate.update("delete from account where id=?",8);
        //查询所有
        /*List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }*/
        //查询一个
        /*Account account = jdbcTemplate.queryForObject("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 7);
        System.out.println(account);*/
        //查询返回一行一列（使用聚合函数，但不加group by子句）
        Integer query = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println(query);
    }
}

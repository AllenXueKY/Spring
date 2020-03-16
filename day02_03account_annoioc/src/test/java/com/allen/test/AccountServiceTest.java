package com.allen.test;

import com.allen.domain.Account;
import com.allen.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试,测试我们的配置
 */
public class AccountServiceTest {
    ApplicationContext ac;
    AccountService as;
    @Before
    public void init(){
        //1、获取容器
        ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        as = ac.getBean("accountService",AccountService.class);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne() {
        Account account = as.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate() {
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }
    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }
}

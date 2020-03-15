package com.allen.ui;

import com.allen.factory.BeanFactory;
import com.allen.service.AccountService;
import com.allen.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
}

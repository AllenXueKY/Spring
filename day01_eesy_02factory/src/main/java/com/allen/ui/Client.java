package com.allen.ui;

import com.allen.factory.BeanFactory;
import com.allen.service.IAccountService;
import com.allen.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        as.saveAccount();
    }
}

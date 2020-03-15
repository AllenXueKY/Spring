package com.allen.factory;

import com.allen.service.AccountService;
import com.allen.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式提供默认构造函数）
 */
public class StaticFactory {
    public static AccountService getAccountService(){

        return new AccountServiceImpl();
    }
}
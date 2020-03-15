package com.allen.service.impl;

import com.allen.dao.AccountDao;
import com.allen.dao.impl.AccountDaoImpl;
import com.allen.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}

package com.allen.service.impl;

import com.allen.dao.AccountDao;
import com.allen.dao.impl.AccountDaoImpl;
import com.allen.factory.BeanFactory;
import com.allen.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao  = (AccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}

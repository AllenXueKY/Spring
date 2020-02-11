package com.allen.service.impl;

import com.allen.dao.IAccountDao;
import com.allen.dao.impl.AccountDaoImpl;
import com.allen.factory.BeanFactory;
import com.allen.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
    public void saveAccount(){
        accountDao.saveAccount();
    }
}

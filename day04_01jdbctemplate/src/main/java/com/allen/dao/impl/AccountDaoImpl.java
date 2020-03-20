package com.allen.dao.impl;

import com.allen.dao.AccountDao;
import com.allen.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 账户的持久层实现类
 */
@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Account findAccountById(Integer accountId) {
        return template.queryForObject("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
    }

    @Override
    public Account findAccountByName(String accountName) {
        return template.queryForObject("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
    }

    @Override
    public void updateAccount(Account account) {
        template.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}

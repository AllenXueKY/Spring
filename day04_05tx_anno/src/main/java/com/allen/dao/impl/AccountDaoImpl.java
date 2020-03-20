package com.allen.dao.impl;

import com.allen.dao.AccountDao;
import com.allen.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findAccountById(Integer accountId) {
        return getJdbcTemplate().queryForObject("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
    }

    @Override
    public Account findAccountByName(String accountName) {
        return getJdbcTemplate().queryForObject("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}

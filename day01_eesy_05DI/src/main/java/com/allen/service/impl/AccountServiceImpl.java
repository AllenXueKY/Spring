package com.allen.service.impl;

import com.allen.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //如果是经常变化的数据，并不适用注入的方式
    private String a;
    private Integer b;
    private Date c;

    public AccountServiceImpl(String a, Integer b, Date c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。" + a
                +  "," +  b + "," + c);
    }
}

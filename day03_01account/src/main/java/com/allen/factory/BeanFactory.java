package com.allen.factory;

import com.allen.domain.Account;
import com.allen.service.AccountService;
import com.allen.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 用于创建service的代理对象的工厂
 */
public class BeanFactory {

    private AccountService accountService;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }


    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取service代理对象
     * @return
     */
    public AccountService getAccountService(){
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1、开启事务
                            txManager.beginTransation();
                            //2、执行操作
                            rtValue = method.invoke(accountService, args);
                            //3、提交事务
                            txManager.commit();
                            //4、返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5、回滚操作
                            txManager.rollBack();
                            throw new RuntimeException(e);
                        } finally {
                            //6、释放连接
                            txManager.release();
                        }
                    }
        });
    }
}

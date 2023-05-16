package com.wang.service;

import org.springframework.transaction.annotation.Transactional;

// 业务层实现转账
public interface AccountService {
    /**
     *
     * @param out 转出方
     * @param in  转入方
     * @param money 交易金额
     */
//1. Spring注解式事务通常添加在业务层接口中而不会添加到业务层实现类中，降低耦合
//2. 注解式事务可以添加到业务方法上表示当前方法开启事务，也可以添加到接口上表示当前接口所有方法开启事务
@Transactional//配置当前接口方法具有事务
    void transfer(String out,String in,Double money);
}

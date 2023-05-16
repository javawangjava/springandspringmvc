package com.wang.service;

import org.springframework.transaction.annotation.Transactional;

// 业务层事项转账的日志
public interface LogService {
    //propagation设置事务属性：传播行为设置为当前操作需要新事务
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional
    void log(String out,String in,Double money);
}

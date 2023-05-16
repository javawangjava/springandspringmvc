package com.wang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
* AOP(Aspect Oriented Programming)面向切面编程，在不改变方法源代码的基础上对方法进行功能增强。
* 将共同的代码片段提取出来使用AOP编程，简化代码。
* AOP开发步骤：
* 【步骤一】单独定义通知类，并将通知类必须配置成Spring管理的bean【@Component】，将通知类设置为切面类【@Aspect】。
* 【步骤一】单独定义通知类，在通知类中定义通知方法。
* 【步骤三】在核心配置类中进行Spring注解包扫描和开启AOP功能【@EnableAspectJAutoProxy】
* 【步骤一】单独定义通知类，在通知类中定义通知方法。
* */
// 类名变量名都可以自己命名，见名知意。接口名/类名：大驼峰。对象名/方法名：小驼峰。


//@Component 通知类必须配置成Spring管理的bean，定义通知类
//@Aspect 设置当前类为切面类
@Component
@Aspect
public class MyAroundAdvice {
    //设置切入点，@Pointcut注解要求配置在方法上方
    @Pointcut("execution(void com.wang.dao.AccountDao.*Aop*(..) )")
    private void myPointcut(){}// 切入点方法

    // 说明切入点和连接点的关系
    @Around("myPointcut()")
    public Object myAroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------------------------------");
        Long startTime = System.currentTimeMillis();
        for (int i = 0 ; i<10000 ; i++) {
            //ProceedingJoinPoint对象调用连接点的方法
            pjp.proceed();
        }
        Long endTime = System.currentTimeMillis();
        Long totalTime = endTime-startTime;
        System.out.println("执行万次消耗时间：" + totalTime + "ms");
        return null;
    }

}

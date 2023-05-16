package com.wang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class DataAdvice {

    //@Pointcut("execution( boolean com.wang.service.*Service.openURL(..))")
    @Pointcut("execution(* com.wang.service.*Service.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
      //  这里先获取原目标方法的参数，也就是链接的URL和密码。
      Object[] args=pjp.getArgs();
        System.out.println(Arrays.toString(args));// 没剪切前的URL
        //先对链接去除前后空格
        for (int i = 0; i < args.length; i++) {
            // 判断参数是不是字符串
            if(args[i].getClass().equals(String.class)){
                args[i]=args[i].toString().trim();
            }
        }
        System.out.println(Arrays.toString(args));// 剪切后的URL
        // 注意下面这里将pjp方法获取的参数进行处理之后要返回到原方法中
        Object ret=pjp.proceed(args);// 将方法的参数去除前后空格后再传入原方法调用。原方法的返回值时Boolean,
        return ret;
    }

}

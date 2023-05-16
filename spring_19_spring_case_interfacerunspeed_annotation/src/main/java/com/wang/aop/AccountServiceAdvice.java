package com.wang.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component//通知类必须配置成Spring管理的bean
@Aspect//设置当前类为切面类
public class AccountServiceAdvice {

    //匹配业务层的所有方法
    @Pointcut("execution(* com.wang.service.*Service.*(..))")
    private void servicePt(){}

    @Around("servicePt()")
    public Object runSpeed(ProceedingJoinPoint pjp) throws Throwable {//由于无法预知原始方法运行后是否会抛出异常，因此环绕通知方法必须抛出Throwable对象
        Signature signature = pjp.getSignature();//获取执行的签名对象
        String methodName = signature.getName();//获取方法名
        String className = signature.getDeclaringTypeName();//获取接口/类全限定名

        long startTime = System.currentTimeMillis();
        for (int i = 0 ; i<1000 ; i++) {
            //ProceedingJoinPoint对象调用原始方法
            pjp.proceed();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime-startTime;
        System.out.println("万次执行："+className+"."+methodName+"---->"+totalTime +"毫秒");
        return null;// 这里只是要获得*Service中方法的万次执行时间，所以没有必要返回一万次的执行结果，那么这里返回null就可以
    }


}

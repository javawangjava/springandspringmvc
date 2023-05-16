package com.wang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

/*
* 切入点（Pointcut）：匹配连接点的式子。在SpringAOP中，一个切入点可以只描述一个具体方法，也可以匹配多个方法。
* 切入点定义依托一个不具有实际意义的方法进行，即无参数，无返回值，方法体无实际逻辑。
*  private void myPointcut(){}// 方法名myPointcut可以自己命名。
* 切入点表达式标准格式：动作关键字(访问修饰符 返回值类型 包名.类/接口名.方法名(参数) 异常名）
* 只有execution指示器是唯一的执行匹配，而其他的指示器都是用于限制匹配的。这说明execution指示器是我们在编写切点定义时最主要使用的指示器
* 其他动作关键字是用来限定的。
* 形式：@Pointcut("execution( 返回值类型 全类名限定.方法名(形参列表)异常名 )")
* @Pointcut("execution( 返回值类型 包名.类/接口名.方法名(参数) 异常名 )")
* execution()后面括号中的是用来描述该切入点可以匹配的方法。对于匹配的方法可以使用通配符来模糊匹配。
* 切入点方法就是@Pointcut中匹配到的方法
* 【*】：单个独立的任意符号，可以独立出现，也可以作为前缀或者后缀的匹配符出现，表示至少有一个【不能匹配空参方法】。
* 【..】：多个连续的任意符号，可以独立出现，常用于简化包名与参数的书写，【可以匹配空参方法】。
*
* 匹配的方法的描述技巧：
* 1.描述切入点通常描述接口；
* 2.返回值类型对于增删改类使用精准类型加速匹配，对于查询类使用*通配快速描述；
* 3.常用*做单个包描述匹配，或精准匹配；
* 4.接口名/类名书写名称与模块相关的采用*匹配，例如UserService书写成*Service，绑定业务层接口名；
* 5.方法名书写以动词进行精准匹配，名词采用*匹配，例如getById书写成getBy*,selectAll书写成selectAll
* 6.根据业务方法灵活调整
* */
//

//@Component 通知类必须配置成Spring管理的bean，定义通知类
//@Aspect 设置当前类为切面类
@Component
@Aspect
public class MyAroundAdvice {
    //设置切入点，@Pointcut注解要求配置在方法上方
    //@Pointcut("execution(void com.wang.dao.AccountDao.*Aop*(..) )")
    //@Pointcut("execution(* *.*.*.*.*Aop*(*) )")//参数写*就没有与之匹配的方法
    @Pointcut("execution(* *.*.*.*.*Aop*(..) )")//参数写..就没有与之匹配的方法

    private void myPointcut(){}// 切入点方法

    // 说明切入点和连接点的关系

    @Before("myPointcut()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }

}

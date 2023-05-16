package com.wang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
 * AOP(Aspect Oriented Programming)面向切面编程，在不改变方法源代码的基础上对方法进行功能增强。
 * 将共同的代码片段提取出来使用AOP编程，简化代码。
 * AOP开发步骤：
 * 【步骤一】单独定义通知类，并将通知类必须配置成Spring管理的bean【@Component】，将通知类设置为切面类【@Aspect】。
 * 【步骤一】单独定义通知类，在通知类中定义通知方法。
 * 【步骤三】在核心配置类中进行Spring注解包扫描和开启AOP功能【@EnableAspectJAutoProxy】
 * 【步骤一】单独定义通知类，在通知类中定义通知方法。
 *
 * 使用AOP调用原方法时，其实就是使用代理对象来调用方法，这时候也可以通过代理对象来获取原方法的形参和返回值，同时也可以获取异常信息，并对异常进行处理。
 * */
// 类名变量名都可以自己命名，见名知意。接口名/类名：大驼峰。对象名/方法名：小驼峰。
/*
* AOP通知类型
* AOP通知描述了抽取的共性功能，根据共性功能抽取的位置不同，最终运行代码时要将其加入到合理的位置。
* AOP通知共分为5种类型
    前置通知@Before：在切入点方法【匹配的方法】执行之前执行
    后置通知@After：在切入点方法执行之后执行，无论切入点方法【匹配的方法】内部是否出现异常，后置通知都会执行。
    环绕通知@Around(重点)：手动调用切入点方法【匹配的方法】并对其进行增强的通知方式。
    返回后通知@AfterReturning(了解)：在切入点方法【匹配的方法】执行之后执行，如果切入点方法内部出现异常将不会执行。
    抛出异常后通知@AfterThrowing(了解)：在切入点方法【匹配的方法】执行之后执行，只有当切入点方法内部出现异常之后才执行。
*
* 重点掌握环绕通知
* 1.环绕通知方法形参必须是ProceedingJoinPoint，表示正在执行的连接点，使用该对象的proceed()方法表示对原始对象方法进行调用，proceed()方法的返回值为原始对象方法的返回值。
* 2.环绕通知方法的返回值建议写成Object类型，用于将原始对象方法的返回值进行返回，哪里使用代理对象就返会哪里。调用的原方法没有返回值或者不需要接收原方法的返回值，那么环绕通知方法就返回null。
*
* */

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

/*
*AOP 通知获取数据
* JoinPoint对象描述了连接点方法的运行状态，可以获取到原始方法的调用参数。
* ProccedJointPoint是JoinPoint的子类。
* 通过JoinPoint或者 ProccedJointPoint对象getArgs()方法是获取原目标方法的参数。
* 方法的形参和返回值是可选的，那么可以获取方法形参或者返回值，然后对其进行处理。
    1.获取切入点方法的参数
        (1) JoinPoint ：适用于前置、后置、返回后、抛出异常后通知
        (2) ProceedJointPoint ：适用于环绕通知
    2.获取切入点方法返回值
        (1)返回后通知
        (2)环绕通知
    3.获取切入点方法运行异常信息
        (1)抛出异常后通知
        (2)环绕通知
*
* */
//@Component 通知类必须配置成Spring管理的bean，定义通知类
//@Aspect 设置当前类为切面类
@Component
@Aspect
public class MyAdvice {

    // public int myMethod0()
    //设置切入点，并设置需要匹配的方法。
    @Pointcut("execution(* com.wang.dao.AccountDao.myMethod0(..) )")
    //切入点定义无参数，无返回值，方法体无实际逻辑的方法，主要是使用名字。
    private void myPointcut0() {  // 切入点方法
    }


    //public void myMethod1()
    @Pointcut("execution(* com.wang.dao.AccountDao.myMethod1(..) )")
    private void myPointcut1() {  // 切入点方法
    }


    /*
     *  1.环绕通知方法形参必须是ProceedingJoinPoint，表示正在执行的连接点，使用该对象的proceed()方法表示对原始对象方法进行调用，proceed()方法的返回值为原始对象方法的返回值,
     * 按照合适格式返回proceed()方法的返回值。
     *  2.环绕通知方法的返回值建议写成Object类型，用于将原始对象方法的返回值进行返回，哪里使用代理对象就返会哪里。调用的原方法没有返回值或者不需要接收原方法的返回值，那么环绕通知方法就返回null。
     * 在五种通知中都可以获取到连接点方法的参数们。
     * */
    //@Around：环绕通知，在原始方法运行的前后执行  环绕通知@Around(重点)：手动调用切入点方法【匹配的方法】并对其进行增强的通知方式。
    // 对原始方法的调用可以不接收返回值，通知方法设置成void即可，如果接收返回值，必须设定为Object类型。

    // public int myMethod0()的返回值是int类型，这里将Around方法的返回值设置为Object类型，最后返回或者需要使用时转换为对应的类型
    @Around("myPointcut0()")
    public Object myAround0(ProceedingJoinPoint pjp) throws Throwable {//由于无法预知原始方法运行后是否会抛出异常，因此环绕通知方法必须抛出Throwable对象
        // ProceedingJoinPoint对象的getArgs()获取原始方法参数值，可以对参数进行处理
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("myMethod0执行之前，执行的部分");
        // 使用ProceedingJoinPoint对象的proceed()方法表示对原始对象方法进行调用，返回值为原始对象方法的返回值。
        Integer returnVal = (Integer)pjp.proceed();
        System.out.println("myMethod0执行之后，执行的部分");
        return returnVal;
    }


    @Around("myPointcut0()")
    public Object myAround1(ProceedingJoinPoint pjp) throws Throwable {//由于无法预知原始方法运行后是否会抛出异常，因此环绕通知方法必须抛出Throwable对象
        // ProceedingJoinPoint对象的getArgs()获取原始方法参数值，可以对参数进行处理
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));

        System.out.println("myMethod0执行之前，执行的部分");
        // 使用ProceedingJoinPoint对象的proceed()方法表示对原始对象方法进行调用，返回值为原始对象方法的返回值。
        String returnVal = (String)pjp.proceed();
        System.out.println("myMethod0执行之后，执行的部分");
        return returnVal;
    }


}

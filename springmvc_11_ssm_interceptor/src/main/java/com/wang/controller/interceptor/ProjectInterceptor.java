package com.wang.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 *
 * 拦截器（Interceptor）是一种动态拦截方法调用的机制，在SpringMVC中动态拦截控制器方法的执行；
 *   作用：
 *       1. 在指定的方法调用前后执行预先设定的代码;
 *       2. 阻止原始方法的执行;
 *       3. 总结：增强.
 *   核心原理：AOP思想
 *
 *
 * 拦截器和过滤器的区别:
 *       归属不同：Filter属于Servlet技术，Interceptor属于SpringMVC技术;
 *       拦截内容不同：Filter对所有访问进行增强，Interceptor仅针对SpringMVC的访问进行增强.
 *
 *
 * 拦截器代码实现:
 *      【第一步】定义拦截器:定义一个类，实现HandlerInterceptor接口即可;
 *      【第二步】配置加载拦截器:
 *          方式1：public class SpringMvcSupport extends WebMvcConfigurationSupport{}
 *          方式2：使用标准接口WebMvcConfigurer简化开发（注意：侵入式较强）
 *
 * 拦截器参数：
 *      【前置处理】：
 *          //原始方法调用前执行的内容；返回值类型可以拦截控制的执行，true放行，false终止
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler) throws Exception {
                System.out.println("preHandle..."+contentType);
                return true;
            }
             参数：1. request:请求对象；2. response:响应对象；3. handler:被调用的处理器对象，本质上是一个方法对象，对反射技术中的Method对象进行了再包装。
             返回值：返回值为false，被拦截的处理器将不执行。

        【后置处理】：
            //原始方法调用后执行的内容；现在开发机制不需要这一个
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object
            handler, ModelAndView modelAndView) throws Exception {
                System.out.println("postHandle...");
            }
            参数：modelAndView：如果处理器执行完成具有返回结果，可以读取到对应数据与页面信息，并进行跳转；
            注意：如果处理器方法出现异常了，该方法不会执行。

        【完成后处理】
            //原始方法调用完成后执行的内容
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object
            handler, Exception ex) throws Exception {
                System.out.println("afterCompletion...");
            }
            参数：ex:如果处理器执行过程中出现异常对象，可以针对异常情况进行单独处理
                注意：无论处理器方法内部是否出现异常，该方法都会执行。

*
*
*  拦截器链配置： 多个连接器工作流程分析
        1.当配置多个拦截器时，形成拦截器链；
        2.拦截器链的运行顺序参照拦截器添加顺序为准；
        3.当拦截器中出现对原始处理器的拦截，后面的拦截器均终止运行；
        4.当拦截器运行中断，仅运行配置在前面的拦截器的afterCompletion操作。
        5.拦截器链的运行顺序：
            preHandle：与配置顺序相同，必定运行；
            postHandle：与配置顺序相反，可能不运行；
            afterCompletion：与配置顺序相反，可能不运行。
*
 * */


//拦截器一般是拦截controller层的，所以可以设置在controller层下。也可以单独设置一个包。


@Component//注意当前类必须受Spring容器控制

//定义拦截器类ProjectInterceptor，实现HandlerInterceptor接口
public class ProjectInterceptor implements HandlerInterceptor {
    @Override
    //原始方法调用前执行的内容
    //返回值类型可以拦截控制的执行，true放行，false终止
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contentType = request.getHeader("Content-Type");
        HandlerMethod hm = (HandlerMethod)handler;
        System.out.println("原始方法调用前执行的内容:preHandle..."+contentType);
        return true;
    }

    @Override
    //原始方法调用后执行的内容
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("原始方法调用后执行的内容:postHandle...");
    }

    @Override
    //原始方法调用完成后执行的内容
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("原始方法调用完成后执行的内容:afterCompletion...");
    }

}


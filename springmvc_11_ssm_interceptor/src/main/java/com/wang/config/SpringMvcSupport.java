package com.wang.config;

import com.wang.controller.interceptor.ProjectInterceptor;
import com.wang.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/*
 *
 * 拦截器（Interceptor）是一种动态拦截方法调用的机制，在SpringMVC中动态拦截控制器方法的执行；
 *   作用：
 *       1. 在指定的方法调用前后执行预先设定的代码;
 *       2. 阻止原始方法的执行;
 *       3. 总结：增强.
 *   核心原理：AOP思想
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
 * */


// 配置加载拦截器的方式1和2是二选一的关系
// 配置加载拦截器方式1：public class SpringMvcSupport extends WebMvcConfigurationSupport{}
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    //配置第一个拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;
    //配置第二个拦截器
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    // 为了确保静态资源能够被访问到，需要设置静态资源过滤。
    //@Override
    //protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    //    registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    //}


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置多拦截器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books","/books/*");
    }

}

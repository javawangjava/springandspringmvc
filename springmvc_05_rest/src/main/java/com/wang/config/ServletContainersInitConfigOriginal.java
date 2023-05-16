//package com.wang.config;
//
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
//
//import javax.servlet.Filter;



///*
//AbstractDispatcherServletInitializer类是SpringMVC提供的快速初始化Web3.0容器的抽象类。
//AbstractDispatcherServletInitializer提供三个接口方法供用户实现。
//    1.createServletApplicationContext()方法，创建Servlet容器时，加载SpringMVC对应的bean并放入WebApplicationContext
//    对象范围中，而WebApplicationContext的作用范围为ServletContext范围，即整个web容器范围。
//    2.getServletMappings()方法，设定SpringMVC对应的请求映射路径，设置为/表示拦截所有请求，任意请求都将转入到SpringMVC进行处理。
//    3.createRootApplicationContext()方法，如果创建Servlet容器时需要加载非SpringMVC对应的bean，使用当前方法进行，使用方式同createServletApplicationContext()。
//
//*/


////创建web容器启动类，加载SpringMVC配置，并设置SpringMVC请求拦截路径
////web容器配置类
//public class ServletContainersInitConfigOriginal extends AbstractDispatcherServletInitializer {
//
//    //createServletApplicationContext()加载springmvc配置类SpringMvcConfig.class，产生springmvc容器（本质还是spring容器）
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        //无参构造器AnnotationConfigWebApplicationContext初始化WebApplicationContext对象
//        AnnotationConfigWebApplicationContext applicationContext=new AnnotationConfigWebApplicationContext();
//        //register()加载指定配置类SpringMvcConfig.class
//        applicationContext.register(SpringMvcConfig.class);
//        return applicationContext;
//    }
//
//    //getServletMappings()设置由springmvc控制器处理的请求映射路径
//    @Override
//    protected String[] getServletMappings() {
//        // 所有的请求都归SpringMvc管
//        return new String[]{"/"};
//    }
//
//    //createRootApplicationContext()加载spring配置类
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null; //不设置spring配置类
//
//        //AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        //ctx.register(SpringConfig.class);
//        //return ctx;
//    }
//
//    //POST请求传递的参数中文乱码处理
//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        return new Filter[]{filter};
//    }
//}

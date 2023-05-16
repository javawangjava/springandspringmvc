package com.wang.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;


// 创建web容器启动类，加载SpringMVC配置，并设置SpringMVC请求拦截路径
// web容器配置类后面用这个简化版的方便
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //getRootConfigClasses()加载Spring配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
        //return new Class[0];// 不加载配置类
    }


    //getServletConfigClasses()加载Springmvc配置类,产生springmvc容器（本质还是spring容器）
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
        //return new Class[0];// 不加载配置类
    }


    //getServletMappings()设置由Springmvc控制器处理的请求映射路径，设置为/表示拦截所有请求，任意请求都将转入到SpringMVC进行处理。
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
        //return new String[0];// 不加载配置类
    }


    //SpringMVC的POST请求传递的参数中文乱码处理
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }

}

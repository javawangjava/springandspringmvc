package com.wang.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//Servlet是JavaWeb最为核心的内容，它是Java提供的一门动态web资源开发技术
//ServletConfig配置类，加载SpringMvcConfig和SpringConfig配置类
//getRootConfigClasses()是Spring容器，
//getServletConfigClasses()是SpringMvc容器，
//SpringMvc容器可以访问Spring容器，Spring容器不可以访问SpringMvc容器。

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //getRootConfigClasses()加载Spring配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
        //return new Class[0];// 不加载配置类
    }

    //getServletConfigClasses()加载Springmvc配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
        //return new Class[0];// 不加载配置类
    }
    //getServletMappings()设置由Springmvc控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
        //return new String[0];// 不加载配置类
    }

    //POST请求传递的参数中文乱码处理
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}

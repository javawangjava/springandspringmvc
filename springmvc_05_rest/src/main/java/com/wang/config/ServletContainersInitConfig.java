package com.wang.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

// web配置类简化开发，仅设置配置类类名即可
// 后面用这个简化版的方便
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //getRootConfigClasses()加载Spring配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class[]{SpringConfig.class};
        return new Class[0];
    }

    //getServletConfigClasses()加载Springmvc配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
        //return new Class[0];
    }

    //getServletMappings()设置由Springmvc控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
        //return new String[0];
    }

    //POST请求传递的参数中文乱码处理
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }

}

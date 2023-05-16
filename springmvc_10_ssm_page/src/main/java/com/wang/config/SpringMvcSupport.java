package com.wang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/*
* SpringMVC静态资源放行：
*  静态资源：可以理解为内容固定的页面，包括 HTML、CSS、JS、图片文件等等。
*  浏览器发起请求后服务器根据 URL 查找文件，并将文件内容作为响应，而无需 Java 代码处理业务逻辑，访问效率较高。
*  因为在SpringMVC中DispatcherServlet也采用了 “/” 作为url-pattern, 所以静态资源的访问也会进入前端控制器，前端控制器会根据路径在对应的Handler处理请求，但是肯定没有这样的请求地址，所以造成静态资源不能完成访问。
*  SpringMVC中提供了注解配置的接口WebMvcConfigurationSupport，专门负责提供项目中需要的springmvc配置的特定功能支持，包括且不仅仅包括了静态资源放行的功能接口、拦截器接口、视图控制器接口等。开发人员只需继承此类并加载到springmvc核心容器即可。
*
* */


/*
 * 设置SpringMvc的配置类SpringMvcSupport。为了确保静态资源能够被访问到，需要设置静态资源过滤。
 * 用于补充springmvc的配置：通常用于静态资源放行、拦截器、视图控制器等的功能配置
 * 使用注解@Configuration将其标记为一个配置类，在Springmvc核心容器中可通过扫描包加载到
 */

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
         * 配置静态资源放行
         * 等同于在xml中配置<mvc:resources mapping="" location=""/>
         * @param registry
         */
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}

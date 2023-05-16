package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//SpringMVC核心配置类（设置配置类，扫描controller包，加载Controller控制器bean），本质上还是一个spring配置类【和Spring配置类设置一样】

/*
*SpringMVC相关的bean(表现层bean【Controller】)的加载方式:SpringMvc配置类只加载Controller控制器bean。
*SpringMVC加载的bean设定扫描范围为精准范围，SpringMVC加载的bean对应的包均在*.*.controller【例如：com.itheima.controller】包内。
*@EnableWebMvc:配置类注解,SpringMVC配置类定义上方,开启SpringMVC多项辅助功能。开启json数据类型自动转换。
*/


@Configuration
//SpringMVC相关的bean(表现层bean【Controller】)的加载方式:SpringMvc配置类只加载Controller控制器bean。
@ComponentScan("com.wang.controller")

public class SpringMvcConfig {
}

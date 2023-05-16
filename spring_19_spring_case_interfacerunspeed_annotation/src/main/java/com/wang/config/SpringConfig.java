package com.wang.config;

import org.springframework.context.annotation.*;

/*
 *Spring3.0开启了纯注解开发模式，使用Java类替代配置文件，Java类代替Spring核心配置文件。将读取Spring核心配置文件初始化容器对象切换为读取Java配置类初始化容器对象。
 * @Configuration注解用于设定当前类为配置类；
 * @ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式；
 * @PropertySource加载properties配置文件
 * 将第三方独立的配置类加入核心配置类：方式1：@Import注解导入式；或者方式2：@ComponentScan扫描式
 * @EnableAspectJAutoProxy//开启注解开发AOP功能
 * */
@Configuration
@ComponentScan("com.wang")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableAspectJAutoProxy//开启注解开发AOP功能
public class SpringConfig {
}

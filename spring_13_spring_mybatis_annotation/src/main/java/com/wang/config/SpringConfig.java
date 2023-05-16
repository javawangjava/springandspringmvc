package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/*
 *Spring3.0开启了纯注解开发模式，使用Java类替代配置文件，Java类代替Spring核心配置文件。将读取Spring核心配置文件初始化容器对象切换为读取Java配置类初始化容器对象。
 * @Configuration注解用于设定当前类为配置类；
 * @ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式；
 * @PropertySource加载properties配置文件
 * 将第三方独立的配置类加入核心配置类：方式1：@Import注解导入式；或者方式2：@ComponentScan扫描式
 * */

/*
 *   Spring整合mybatis
 *      【第一步】导入Spring整合Mybatis依赖;
 *      【第二步】创建JdbcConfig配置DataSource数据源;
 *      【第三步】创建MybatisConfig整合mybatis;
 *      【第四步】创建SpringConfig主配置类进行包扫描和加载其他配置类。
 *
 */

@Configuration
@ComponentScan("com.wang")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {
}

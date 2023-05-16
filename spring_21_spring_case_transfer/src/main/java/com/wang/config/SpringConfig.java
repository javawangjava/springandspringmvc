package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 对于RuntimeException类型异常或者Error错误，Spring事务能够进行回滚操作。但是对于编译器异
//常，Spring事务是不进行回滚的，所以需要使用rollbackFor来设置要回滚的异常。

@Configuration// @Configuration注解用于设定当前类为配置类
@ComponentScan("com.wang")// @ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式
// 如果@Value()中使用了EL表达式读取properties属性文件中的内容，那么就需要加载properties属性文件
@PropertySource("classpath:jdbc.properties")//@PropertySource：加载类路径jdbc.properties文件
@Import({JdbcConfig.class,MybatisConfig.class})// 导入其他配置类
//开启注解式事务驱动
@EnableTransactionManagement
public class SpringConfig {
}

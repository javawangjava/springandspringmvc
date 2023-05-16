package com.wang.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/*
 * Spring管理第三方Bean对象的方式
 * 【步骤一】写一个第三方独立的配置类，使用该配置类来获取第三方的Bean对象；
 * 【步骤二】在第三方独立的配置类中定义一个返回值类型就是要管理的对象的类型的方法，并且该方法使用@Bean进行注解。@Bean表示该方法的返回值是一个Bean对象，添加到IOC容器中。。
 *  定义了Bean对象之后，可能需要对Bean对象中传入参数【注入资源】：
 * 注解开发为第三方Bean的简单类型依赖注入：@Value()。如果@Value()中使用了EL表达式读取properties属性文件中的内容，那么就需要加载properties属性文件。
 * 注解开发为第三方Bean的引用类型依赖注入:引用类型注入只需要将引用类型变量设置为@Bean注解的方法的形参即可【@Bean注解的方法就是获取第三方Bean对象的方法】，容器会根据类型自动装配对象。Spring会自动从IOC
 * 容器中找到对应引用类型对象赋值bean定义方法设置形参，如果没有就会报错。
 * */

/*
 * Spring整合mybatis
 * 创建MybatisConfig整合mybatis
 * */

//MybatisConfig配置类
public class MybatisConfig {

    // *Factory一般是产生工厂类的对象的方法【工厂类是用来获取*类型对象的方法】；*FactoryBean一般是产生工厂类的Beand对象的方法。
    // 所以下面方法是定义一个返回值是SqlSessionFactoryBean的方法，用于获取SqlSessionFactoryBean类型一个对象【使用SqlSessionFactoryBean封装SqlSessionFactory需要的环境信息】。
    // SqlSessionFactoryBean是用于产生SqlSessionFactory对象的。只是该对象是Bean类型的对象【由IOC进行创建或者管理的对象】，

    // SqlSessionFactoryBean是用于产生SqlSessionFactory对象的。只是该对象是Bean类型的对象【由IOC进行创建或者管理的对象】，已经提供好的
    //定义bean，SqlSessionFactoryBean，用于产生SqlSessionFactory对象
    //@Bean("sqlSessionFactoryBean")

    /*   注解开发为第三方Bean的引用类型依赖注入:引用类型注入只需要将引用类型变量设置为@Bean注解的方法的形参即可【@Bean注解的方法就是获取第三方Bean对象的方法】，
        容器会根据类型自动装配对象。Spring会自动从IOC容器中找到对应引用类型对象赋值bean定义方法设置形参，如果没有就会报错。
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {// 引用类型dataSource注入只需要将引用类型变量设置为@Bean注解的方法的形参即可
        // SqlSessionFactoryBean是用于产生SqlSessionFactory对象的。只是该对象是Bean类型的对象【由IOC进行创建或者管理的对象】，已经提供好的
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.wang.domain");// 设置类型别名
        ssfb.setDataSource(dataSource);// 这里就是将
        return ssfb;
    }


    // 使用MapperScannerConfigurer加载Dao接口，创建代理对象保存到IOC容器中
    // 定义bean，返回MapperScannerConfigurer对象
    //@Bean("mapperScannerConfigurer")
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        // MapperScannerConfigurer类是用来加载Dao接口，创建代理对象保存到IOC容器中
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.wang.dao");
        return msc;
    }

}


package com.wang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
* Spring整合JDBC，返回DataSource的Bean对象
* 创建JdbcConfig配置DataSource数据源
* */


// JdbcConfig配置类
public class JdbcConfig {
    // 注解开发为第三方Bean的简单类型依赖注入：@Value()。如果@Value()中使用了EL表达式读取properties属性文件中的内容，那么就需要加载properties属性文件。
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //配置连接池
    // 定义一个方法得到要管理的对象DataSource，添加@Bean，表示当前方法的返回值是一个bean对象，添加到IOC容器中。也可以省略Bean的id。
    //@Bean("dataSource")
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // Spring事务管理需要的平台事务管理器对象
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager ds = new DataSourceTransactionManager();
        ds.setDataSource(dataSource);
        return ds;
    }
}

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
 * 下面是将第三方独立的配置类加入核心配置类的方式：
 * 方式1和2都是合理的。直接将将第三方的Bean写进核心配置类不符合解耦合思想【虽然行的通】
 * 方式1：@Import注解导入式
 * 方式2：@ComponentScan扫描式
 * */

// 方式2：导入式  建议使用该模式
// 使用@Import注解手动加入配置类到核心配置，此注解只能添加一次，多个数据请用数组格式
@Configuration
@PropertySource("jdbc.properties")
//@ComponentScan("com.wang.dao")
@ComponentScan("com.wang")


// 下面4个import切换
//@Import(JdbcConfig1.class)
//@Import(JdbcConfig2.class)
@Import({JdbcConfig3.class})
//@Import({JdbcConfig4.class})
public class SpringConfig {

}



/*
// 方式2：扫描式
// 使用@ComponentScan注解扫描配置类所在的包，加载对应的配置类信息

@Configuration
@ComponentScan({"com.wang.config","com.wang.dao"})
public class SpringConfig {
}
*/



/*
// 不合理方式：不建议将第三方的Bean写进核心配置类。知道这么写是行的通的就行
@Configuration
@ComponentScan("com.wang")
public class SpringConfig {
    //@Bean("dataSource")
    @Bean
    // 1.定义一个方法得到要管理的对象
    // 2.添加@Bean，表示当前方法的返回值是一个bean。
    public DataSource dataSource(){
        DruidDataSource ds=new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/db5?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("1234");
        return ds;
    }
}
*/



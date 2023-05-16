package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
*
// Spring和SpringMVC是不同的架构，对应简化不同的三个层。因此加载相应的Bean对象时一般要分开处理。
// SpringMVC相关的bean(表现层bean【Controller】)
// Spring相关的Bean(业务层bean【Service】,持久层Dao【@Repository】)
*
* SpringMVC相关的bean(表现层bean【Controller】)的加载方式：
* 1.SpringMVC相关bean加载控制:SpringMVC加载的bean设定扫描范围为精准范围，SpringMVC加载的bean对应的包均在*.*.controller【例如：com.itheima
* .controller】包内。
* Spring相关的Bean(业务层bean【Service】,持久层Dao【@Repository】)的加载方式：
* 1. 方式一：Spring加载的bean设定扫描范围包含Controller，Service和Repository三层，然后再排除Controller。【Spring加载的bean设定扫描范围为com
* .itheima，排除掉controller包内的bean】
* 2. 方式二：Spring加载的bean设定扫描范围为精准范围，例如service包、dao包等
* 3. 方式三：不区分Spring与SpringMVC的环境，加载到同一个环境中
*
* */


/*
//
//Spring加载相关的Bean方式一：Spring加载的bean设定扫描范围包含Controller，Service和Repository三层，然后再排除Controller。
//设置spring配置类加载bean时的过滤规则，当前要求排除掉表现层【Controller】对应的bean。
//excludeFilters属性：设置扫描加载bean时，排除的过滤规则。
//type属性：设置排除规则，当前使用按照bean定义时的注解类型进行排除
//classes属性：设置排除的具体注解类，当前设置排除@Controller定义的bean。
//Spring加载相关的Bean方式1：Spring加载的bean设定扫描范围包含Controller，Service和Repository三层的上一次，然后再过滤掉Controller。其实就是取余下的部分。
@Configuration
@ComponentScan(value="com.wang",
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
    )
)
public class SpringConfig {
}

*/


/*
*
* SSM整合:
* 1.MyBatis:jdbc.properties+JdbcConfig+MybatisConfig；
* 2.Spring:SpringConfig;
* 3.SpringMVC:ServletConfig+SpringMvcConfig;
*
* SSM整合配置：
* 【步骤一】：创建工程，添加依赖和插件；
* 【步骤二】：Spring整合Mybatis；
*       1.创建数据库和表；
*       2.jdbc.properties属性文件；
*       3.JdbcConfig配置类；
*       4.MybatisConfig配置类；
*       5.SpringConfig配置类
* 【步骤三】：Spring整合SpringMVC；
*       1.SpringMvcConfig配置类；
*       2.ServletConfig配置类实现AbstractAnnotationConfigDispatcherServletInitializer，加载SpringMvcConfig和SpringConfig配置类；
*
* getRootConfigClasses()加载Spring容器，
* getServletConfigClasses()是加载SpringMvc容器，
* SpringMvc容器可以访问Spring容器，Spring容器不可以访问SpringMvc容器。
* */



/*
*
* 功能模块：
* 1.表与实体类；在MySQL数据库中创建数据库和表，在项目中定义实体类【pojo类】
* 2.dao【数据层】（接口+自动代理）：数据层接口测试（整合JUnit）；
* 3.service【业务层】（接口+实现类）：业务层接口测试（整合JUnit）；
* 4.controller【表现层】（类）：表现层接口测试（PostMan）
*
*
* 功能模块开发步骤：
* 注意只有在数据层，业务层和表现层的实现类上面使用@Component来标识Bean对象。
* 【步骤一】：数据层开发(BookDao)；
*       1.定义pojo类就是实体类【Book实体类】；
*       2.数据层Dao【mappper】一般写成接口形式+注解形式【BookDao接口】；
* 【步骤二】：业务层开发(BookService/BookServiceImpl)；
*       业务层Service一般写接口和实现类；
*       接口中的方法一般要见名知意，并且要写文档注释。增删查改要有返回值。
*       1.定义Service接口并在接口中开启事务管理【@Transactional //表示所有方法进行事务管理】【BookService接口】；
*       2.定义Service接口实现类【BookServiceImpl实现类】；
* 【步骤三】：表现层开发(BookController)；
*       1.定义表现层的类；
*
*
* 接口测试：应该写完一层测试一层；Spring整合Junit做测试时要注意test文件夹和main文件夹的结构层次相对应。
* 【步骤一】：数据层开发(BookDao)写完了测试Dao层：数据层接口测试（整合JUnit）；；
* 【步骤二】：业务层开发(BookService)写完了测试Service层：业务层接口测试（整合JUnit）；；
* 【步骤三】：表现层开发(BookController)写完了测试Controller层：表现层接口测试（PostMan）；
*

*
* * */


// Spring：SpringConfig配置类
// Spring加载相关的Bean方式2：Spring加载的bean设定扫描范围为精准范围，例如service包、dao包等
@Configuration
@ComponentScan({"com.wang.service"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableTransactionManagement//开启Spring事务管理

public class SpringConfig {
}

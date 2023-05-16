package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 *Spring3.0开启了纯注解开发模式，使用Java类替代配置文件，Java类代替Spring核心配置文件。将读取Spring核心配置文件初始化容器对象切换为读取Java配置类初始化容器对象。
 * @Configuration注解用于设定当前类为配置类；
 * @ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式；
 * @PropertySource加载properties配置文件
 * 将第三方独立的配置类加入核心配置类：方式1：@Import注解导入式；或者方式2：@ComponentScan扫描式
 * */

/*
* 配置不加载系统属性
* 如果属性文件中配置的不是jdbc.username，而是username=root666，那么使用${username}获取到的不是root666，而是计算机的名称
* 系统属性的优先级比我们属性文件中的高，替换了我们的username=root666。
*  解决1：换一个名称，例如不叫username，叫jdbc.username。
解决2：使用system-properties-mode="NEVER"属性表示不使用系统属性。
<context:property-placeholder location="jdbc.properties" system-properties-mode="NEVER"/>
* */

/*
* 不管是使用配置文件还是配置类，都必须进行对应的Spring注解包扫描才可以使用。@Autowired默认按照类型自动装配，
* 如果IOC容器中同类的Bean有多个，那么默认按照变量名和Bean的名称匹配，建议使用@Qualifier注解指定要装配的bean名称
* */
@Configuration
@ComponentScan("com.wang")
@PropertySource("AccountArgsValue.peoperties")
public class AccountSpringConfig {
}

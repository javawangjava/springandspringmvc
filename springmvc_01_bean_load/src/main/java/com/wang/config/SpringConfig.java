package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


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


//设置spring配置类加载bean时的过滤规则，当前要求排除掉表现层【Controller】对应的bean。
//excludeFilters属性：设置扫描加载bean时，排除的过滤规则。
//type属性：设置排除规则，当前使用按照bean定义时的注解类型进行排除
//classes属性：设置排除的具体注解类，当前设置排除@Controller定义的bean。

//情况2：Spring加载时不加载SpringMVC相关的bean(表现层bean【Controller】)。
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

/*
//情况2：Spring加载时不加载SpringMVC相关的bean(表现层bean【Controller】)。
// Spring加载相关的Bean方式2：Spring加载的bean设定扫描范围为精准范围，例如service包、dao包等
@Configuration
@ComponentScan({"com.wang.dao","com.wang.service"})
public class SpringConfig{
}
*/



/*

// 情况1：下面这种是Spring加载时加载了SpringMVC相关的bean(表现层bean【Controller】)，所以Spring对应的对象可以访问Controller对应的对象和方法。
@Configuration
@ComponentScan("com.wang")// 加载时包含了Controller层的包，所以可以访问Controller层
public class SpringConfig{
}

*/

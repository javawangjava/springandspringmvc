package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller：类注解，设定SpringMVC的核心控制器bean【就是表现层web层的Bean对象】。
//@RequestMapping：类/方法注解,设置当前控制器方法请求访问路径【设置映射路径为，即外部访问路径】，如果设置在类上统一设置当前控制器方法请求访问路径前缀。类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径。
//@ResponseBody:方法注解,设置响应体。设置当前方法的返回值为指定json数据。

/*
 * 对于SpringMVC而言，Controller方法返回值默认表示要跳转的页面，没有对应的页面就会报错。
 * 如果不想跳转页面而是响应数据，那么就需要在方法上使用@ResponseBody注解。
 * */


// 注意这里UserRequestMappingController和User2RequestMappingController的访问不一样，不能同一个路径指向不同的内容


// 定义处理请求的功能类（User2Controller）
//@RequestMapping：类/方法注解,设置当前控制器方法请求访问路径【设置映射路径为，即外部访问路径】，如果设置在类上统一设置当前控制器方法请求访问路径前缀。类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径。
@Controller//// 定义表现层控制器bean
//类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径。
@RequestMapping("/user2")
public class User2RequestMappingController {
    //@RequestMapping：设置映射路径为/user/put，即外部访问路径
    @RequestMapping("/put")
    //@ResponseBody：设置响应体。设置当前方法的返回值为指定json数据（本质上是一个字符串信息）
    @ResponseBody
    public String put(){
        System.out.println("User2Controller 的put()方法运行了");
        return "{'info':'spring'}";
    }

    //设置映射路径为/user/delete，即外部访问路径
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println("User2Controller 的delete()方法运行了");
        return "{'info':'springmvc'}";
    }
}

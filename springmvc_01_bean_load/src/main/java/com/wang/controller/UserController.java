package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@Controller：类注解，设置设定SpringMVC的核心控制器bean【就是表现层web层的Bean对象】
//@RequestMapping：类/方法注解,设置当前控制器方法请求访问路径，如果设置在类上统一设置当前控制器方法请求访问路径前缀。类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径

//@ResponseBody:方法注解,设置当前控制器方法响应内容为当前返回值，无需解析。

/*
* //@RequestMapping("/../..")：设置映射路径为，即外部访问路径
* 对于SpringMVC而言，Controller方法返回值默认表示要跳转的页面，没有对应的页面就会报错。
* 如果不想跳转页面而是响应数据，那么就需要在方法上使用@ResponseBody注解。
* */


// 定义处理请求的功能类（UserController）


@Controller//// 定义表现层控制器bean
public class UserController {
    @RequestMapping("/put")//@RequestMapping：设置映射路径为/put，即外部访问路径
    @ResponseBody//@ResponseBody：设置响应体。设置当前方法的返回值为指定json数据（本质上是一个字符串信息）
    public String put(){
        System.out.println("UserController 的put()方法运行了");
        return "{'info':'spring'}";
    }

}

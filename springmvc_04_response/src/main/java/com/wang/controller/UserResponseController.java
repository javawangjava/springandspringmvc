package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//@Controller：类注解，设定SpringMVC的核心控制器bean【就是表现层web层的Bean对象】。
//@RequestMapping：类/方法注解,设置当前控制器方法请求访问路径【设置映射路径为，即外部访问路径】，如果设置在类上统一设置当前控制器方法请求访问路径前缀。类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径。
//@ResponseBody：方法注解，设置当前控制器[方法]返回值作为响应体。


/*
 * 对于SpringMVC而言，Controller方法返回值默认表示要跳转的页面，没有对应的页面就会报错。也就是跳转页面时不需要使用@ResponseBody注解。
 * 如果不想跳转页面而是响应数据，那么就需要在方法上使用@ResponseBody注解。
 *
 * @ResponseBody：方法注解，设置当前控制器[方法]返回值作为响应体。不同的响应体
 * 【类型1】：响应页面/跳转页面：返回值为String类型，设置返回值为页面名称【return "page.jsp";】，即可实现页面跳转；跳转页面时不需要使用@ResponseBody注解。
 * 【类型2】：响应文本数据：返回值为String类型，设置返回值为任意字符串信息，即可实现返回指定字符串信息，需要依赖@ResponseBody注解；
 * 【类型3】：响应json数据：
 *      响应json形式POJO对象：返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖@ResponseBody注解和@EnableWebMvc注解；
 *      响应json形式POJO集合对象：返回值为集合对象，设置返回值为集合类型，集合的泛型约束<>内为集合中pojo对象的类型，即可实现返回对应集合的json数组数据，需要依赖@ResponseBody注解和@EnableWebMvc注解。
 *
 * */

// 定义处理请求的功能类（UserResponseController）

@Controller// 定义表现层控制器bean
public class UserResponseController {

    // 【类型1】：响应页面/跳转页面：返回值为String类型，设置返回值为页面名称【return "page.jsp";】，即可实现页面跳转；跳转页面时不需要使用@ResponseBody注解。
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "page.jsp";
    }

    // 【类型2】：响应文本数据：返回值为String类型，设置返回值为任意字符串信息，即可实现返回指定字符串信息，需要依赖@ResponseBody注解；
    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println("返回纯文本数据");
        return "response text";
    }

    // 【类型3】：响应POJO对象：返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖@ResponseBody注解和@EnableWebMvc注解；
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setAge(25);
        return user;
    }


    // 【类型4】：响应POJO集合对象：返回值为集合对象，设置返回值为集合类型，集合的泛型约束<>内为集合中pojo对象的类型，即可实现返回对应集合的json数组数据，需要依赖@ResponseBody
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User();
        user1.setId(2);
        user1.setName("张三");
        user1.setAge(18);

        User user2 = new User();
        user2.setId(3);
        user2.setName("李四");
        user2.setAge(20);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }

}

package com.wang;

import com.wang.config.SpringConfig;

import com.wang.controller.UserController;
import com.wang.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForBeanLoad {
    public static void main(String[] args) {

        // 下面这两种方式的作用一样的语句功能一样，先无参构造器初始化，然后再加载配置类获得相应的Bean对象。
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.register(SpringConfig.class);
        //System.out.println(ctx.getBean(UserController.class));

        /*
        // 情况1：下面这种是Spring加载时加载了SpringMVC相关的bean(表现层bean【Controller】)，所以Spring对应的对象可以访问Controller对应的对象和方法。
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(ctx.getBean(UserController.class));
        System.out.println(ctx.getBean(UserService.class));
        */

        //情况2：Spring加载时不加载SpringMVC相关的bean(表现层bean【Controller】),所以Spring就不能访问Controller层的数据。
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        //System.out.println(ctx.getBean(UserController.class));
        System.out.println(ctx.getBean(UserService.class));

    }
}

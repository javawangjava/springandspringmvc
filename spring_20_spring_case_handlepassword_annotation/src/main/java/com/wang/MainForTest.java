package com.wang;

import com.wang.config.SpringConfig;
import com.wang.service.ResourcesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForTest {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourcesService resourcesService = ctx.getBean(ResourcesService.class);

        boolean flag = resourcesService.openURL("  http://pan.baidu.com/haha   ", "  1234 ");
        System.out.println(flag);
    }
}

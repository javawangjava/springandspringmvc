package com.wang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wang")
// @EnableAspectJAutoProxy开启Spring对AOP注解驱动支持
@EnableAspectJAutoProxy
public class SpringConfig {
}

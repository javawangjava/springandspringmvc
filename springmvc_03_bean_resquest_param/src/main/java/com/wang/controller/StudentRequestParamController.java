package com.wang.controller;

import com.wang.domain.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
*
* SpringMVC的GET/POST请求参数乱码处理：
*   【GET请求中文乱码问题】：解决：在pom.xml添加tomcat7插件处配置UTF-8字符集，解决GET请求中文乱码问题。
*   tomcat 8.0版本之后GET请求就不再出现中文乱码问题，但是我们使用的是tomcat7插件，所以会出现GET请求中文乱码问题。
*   【POST请求中文乱码问题】：在加载SpringMVC配置的配置类中指定字符过滤器。
*       //POST请求传递的参数中文乱码处理
        @Override
        protected Filter[] getServletFilters() {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            filter.setEncoding("UTF-8");
            return new Filter[]{filter};
        }
*
* */


//@Controller：类注解，设定SpringMVC的核心控制器bean【就是表现层web层的Bean对象】。
//@EnableWebMvc:配置类注解,SpringMVC配置类定义上方,开启SpringMVC多项辅助功能。根据类型匹配对应的类型转换器。
//@RequestMapping：类/方法注解,
// 设置当前控制器方法请求访问路径【设置映射路径为，即外部访问路径】，如果设置在类上统一设置当前控制器方法请求访问路径前缀。类上方配置的请求映射与方法上面配置的请求映射连接在一起，形成完整的请求映射路径。
//@RequestParam:形参注解,SpringMVC控制器方法形参定义前面,绑定请求参数与处理器方法形参间的关系。
//@RequestBody：形参注解，SpringMVC控制器方法形参定义前面，将请求中请求体所包含的数据传递给请求参数，此注解一个处理器方法只能使用一次
//@ResponseBody:方法注解,设置响应体。


/*
 * 对于SpringMVC而言，Controller方法返回值默认表示要跳转的页面，没有对应的页面就会报错。
 * 如果不想跳转页面而是响应数据，那么就需要在方法上使用@ResponseBody注解。
 * */


/*
@RequestBody、@RequestParam与@PathVariable区别和应用
    区别：
        @RequestParam表示用于接收url地址传参【基本数据类型和String类型】，表单传参【application/x-www-form-urlencoded】；
        @RequestBody表示用于接收json数据【application/json】；
        @PathVariable用于接收路径参数，使用{参数名称}描述路径参数；
    应用：
        后期开发中，发送请求参数超过1个时，以json格式为主，@RequestBody应用较广；
        如果发送非json格式数据，选用@RequestParam接收请求参数；
        采用RESTful进行开发，当参数数量较少时，例如1个，可以采用@PathVariable接收请求路径变量，通常用于传递id值。
* */


/*
 *Request请求五种类型参数传递：
 * 【类型1】：普通参数【其实就是基本类型参数和String类型变量】：
 *    情况1：当请求参数与形参名称相同且一一对应即可完成参数传递；
 *    情况2：当请求参数名与形参名称不同，使用@RequestParam绑定参数关系【建立请求参数名称和形参名称的映射】；
 * 【类型2】：POJO参数【普通Java对象”（Plain Old Java Object），POJO其实就是没有使用任何框架的对象】
 *    情况1：无嵌套POJO参数【即对象没有包装且对象的成员变量全是普通参数】：请求参数名与方法中POJO类型的形参对象的成员属性名相同即可接收参数。即请求形参与该方法的形参对应的POJO对象对应的类中成员变量名和类型对应。
 *    【无嵌套的pojo对象的单个参数就可以看作普通参数，但是格式和名称必须对应】，否则无法封装。
 *    情况2：嵌套POJO参数【POJO对象中包含POJO对象】：嵌套属性按照层次结构设定名称即可完成参数传递【例如：Person类有Pojo对象studet的属性,Student类有name属性，那么Person的属性
 * student.name】。
 * 【类型3】：数组保存普通参数：普通参数的请求参数名与数组形参对象属性名相同且请求参数为多个，定义数组类型即可接收参数。同名普通请求参数可以直接映射到对应名称的形参数组对象中【实参参数名就是形参数组名】。
 * 【类型4】：集合保存普通参数：普通参数的请求参数名与集合形参集合对象名相同且请求参数为多个，使用@RequestParam绑定参数关系。同名普通请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据。
 * 【类型5】：json数据形式参数传递：
 *    json数据的几种形式：json普通数组（["","","",...]）；json对象（{key:value,key:value,...}）；json对象数组（[{key:value,...},{key:value,..
 * .}]）。
 *    在方法中使用形参@RequestBody注解来表明是传递json数据；使用都需要开启json数据格式的自动转换，在配置类中开启@EnableWebMvc。
 *
 *    情况1：json格式普通数组:["","","",...]【就是多个普通参数，不是以键值对的形式存在的】：以List<？>形式接收。泛型约束<？>的数据类型中就是多个普通参数的类型。如["game","music",
 * "travel"]。
 *    情况2：json对象:{key:value,key:value,...}：要求属性名称一一对应。【就是实体类对象的实例成员变量以键值对形式传入，在一个大括号内使用键值对表示完一个对象的成员变量的变量名和属性值。】{"id
 * ":10,"name":"张三","money":100}。
 *    情况3：json对象数组:[{key:value,key:value,...},{key:value,key:value,..
 * .}]：POJO集合参数：json数组数据与集合泛型属性名相同，定义List类型形参即可接收参数。就是以json形式的多个对象的组成的数组。
 *
 * */


/*
 *
 *@DateTimeFormat：形参注解，SpringMVC控制器方法形参前面，设定日期时间型数据格式，pattern：指定日期时间格式字符串【自己业务要求写就可以】。
 *使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
 * */


//请求参数 request的参数接收格式
@Controller
public class StudentRequestParamController {
    //【类型1】普通参数【其实就是基本类型参数和String类型变量】：情况1：当请求参数与形参名称相同且一一对应即可完成参数传递；
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递 name ==> " + name);
        System.out.println("普通参数传递 age ==> " + age);
        return "{'module':'common param'}";
    }

    //【类型1】：普通参数【其实就是基本类型参数和String类型变量】：当请求参数名与形参名称不同，使用@RequestParam绑定参数关系【建立请求参数名称和形参名称的映射】；
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String username, int age) {
        System.out.println("普通参数传递 username ==> " + username);
        System.out.println("普通参数传递 age ==> " + age);
        return "{'module':'common param different name'}";
    }

    //【类型2】：POJO参数【普通Java对象”（Plain Old Java Object），POJO其实就是没有使用任何框架的对象。即方法形参是对象】
    // 情况1：无嵌套POJO参数【即对象没有包装且对象的成员变量全是普通参数】：请求参数名与方法中POJO类型的形参对象的成员属性名相同即可接收参数。即请求形参与该方法的形参对应的POJO对象对应的类中成员变量名和类型对应。
    // 【无嵌套的pojo对象的单个参数就可以看作普通参数，但是格式和名称必须对应】，否则无法封装。
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(Student student) {
        System.out.println("pojo参数传递 student ==> " + student);
        return "{'module':'pojo param'}";
    }

    //【类型2】：POJO参数【普通Java对象”（Plain Old Java Object），POJO其实就是没有使用任何框架的对象】
    //情况2：嵌套POJO参数【POJO对象中包含POJO对象】：嵌套属性按照层次结构设定名称即可完成参数传递【例如：Person类有Pojo对象studet的属性,
    // Student类有name属性，那么Person的属性 student.name】。
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(Student student) {
        System.out.println("pojo嵌套pojo参数传递 student ==> " + student);
        return "{'module':'pojo contain pojo param'}";
    }


    //【类型3】：数组保存普通参数：普通参数的请求参数名与数组形参对象属性名相同且请求参数为多个，定义数组类型即可接收参数。同名普通请求参数可以直接映射到对应名称的形参数组对象中【实参参数名就是形参数组名】。
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] arrs) {
        System.out.println("数组参数传递 arrs ==> " + Arrays.toString(arrs));
        return "{'module':'array param'}";
    }

    // 【类型4】：集合保存普通参数：普通参数的请求参数名与集合形参集合对象名相同且请求参数为多个，使用@RequestParam绑定参数关系。同名普通请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据。
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> lists) {
        System.out.println("集合参数传递 lists ==> " + lists);
        return "{'module':'list param'}";
    }


    // 【类型5】：json数据形式参数传递：
    //  在方法中使用形参@RequestBody注解来表明是传递json数据；使用都需要开启json数据格式的自动转换，在配置类中开启@EnableWebMvc。
    //  情况1：json格式普通数组:["","","",...]【就是多个普通参数，不是以键值对的形式存在的】：以List<？>形式接收。泛型约束<？>的数据类型中就是多个普通参数的类型。
    //  如["game","music",* "travel"]。
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> " + likes);
        return "{'module':'list common for json param'}";
    }


    // 【类型5】：json数据形式参数传递：
    //  在方法中使用形参@RequestBody注解来表明是传递json数据；使用都需要开启json数据格式的自动转换，在配置类中开启@EnableWebMvc。
    //  情况2：json对象:{key:value,key:value,...}：要求属性名称一一对应。【就是实体类对象的实例成员变量以键值对形式传入，在一个大括号内使用键值对表示完一个对象的成员变量的变量名和属性值。】
    //   {"id":10,"name":"张三","money":100}。
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody Student student) {
        System.out.println("pojo(json)参数传递 user ==> " + student);
        return "{'module':'pojo for json param'}";
    }


    // 【类型5】：json数据形式参数传递：
    //  在方法中使用形参@RequestBody注解来表明是传递json数据；使用都需要开启json数据格式的自动转换，在配置类中开启@EnableWebMvc。
    //  情况3：json对象数组:[{key:value,key:value,...},{key:value,key:value,...}]：POJO集合参数：json数组数据与集合泛型属性名相同，定义List类型形参即可接收参数。
    //  就是以json形式的多个对象的组成的数组。

    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<Student> list) {
        System.out.println("list pojo(json)参数传递 list ==> " + list);
        return "{'module':'list pojo for json param'}";
    }

    // @DateTimeFormat：形参注解，SpringMVC控制器方法形参前面，设定日期时间型数据格式，pattern：指定日期时间格式字符串【自己业务要求写就可以】。
    // 使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
    @RequestMapping("/dataParam")
    @ResponseBody
    public String dataParam(Date date,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date2) {
        System.out.println("参数传递 date ==> " + date);
        System.out.println("参数传递 date1(yyyy-MM-dd) ==> " + date1);
        System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> " + date2);
        return "{'module':'data param'}";
    }


}

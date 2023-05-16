package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/*
 *
 * REST风格：
 *   1.REST（Representational State Transfer），表现形式状态转换；隐藏资源的访问行为，无法通过地址得知对资源是何种操作，简化书写；
 *   2.REST风格访问资源时使用行为动作区分对资源进行了何种操作；【就是不是在路径中包含操作的信息】，修改为模块名+动作。【就是5说的形式】
 *   3.根据REST风格对资源进行访问称为RESTful；约定不是规范，可以打破，所以称REST风格；
 *   4.REST风格描述模块的名称通常使用复数，也就是加s的格式描述，表示此类资源，而非单个资源，例如：users、books；
 *   5.Rest风格如何通过路径传递参数：在Controller中定义方法时设定"http请求动作(请求方式)"和"设定请求参数（路径变量）"。
 *
 *
 *
 *          Rest快速开发：简化前后对比
 *              0.REST风格操作简化前：使用@RequestMapping(value = "请求路径",method = RequestMethod.请求方式)来注解，设置当前方法的请求路径和REST风格的请求方式。
 *              1.在Controller类上使用@RequestMapping定义共同的访问路径。
 *              2.REST风格操作简化后：使用@GetMapping，@PostMapping， @PutMapping，@DeleteMapping代替@RequestMapping(method=RequestMethod.XXX)。
 *
 *                      方法注解，设置基于SpringMVC的RESTful开发当前控制器方法请求访问路径与请求动作，每种对应一个请求动作，例如@GetMapping对应GET请求。
 *                      设置当前请求方法为POST，表示REST风格中的添加操作为例：@PostMapping("请求路径")     《==》   @RequestMapping(value ="请求路径" ,method = RequestMethod.POST)
 *                      参数传递：
 *                          【方式一】如果请求路径中有单个参数就需要使用@PathVariable注解：@PathVariable：请求路径的形参注解，SpringMVC 控制器方法形参定义前面，绑定路径参数与处理器方法形参间的关系，要求路径参数名与形参名一一对应。
 *                              @PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符{形参}，并且占位符名称与方法形参名称相同。如果名称不对应，那么就需要在@PathVariable中指定占位符的名称@PathVariable("占位符的名称")。
 *                          【方式二】@RequestBody：形参注解，SpringMVC控制器方法形参定义前面，将请求中请求体所包含的数据以json形式传递给请求参数，此注解一个处理器方法只能使用一次。
 *                      【添加】：@PostMapping("请求路径")     《==》   @RequestMapping(value ="请求路径" ,method = RequestMethod.POST)
 *                      【删除】：@DeleteMapping("请求路径")   《==》   @RequestMapping(value ="请求路径" ,method = RequestMethod.DELETE)
 *                      【查询】：@GetMapping("请求路径")      《==》   @RequestMapping(value ="请求路径" ,method = RequestMethod.GET)
 *                      【修改】：@PutMapping("请求路径")      《==》   @RequestMapping(value ="请求路径" ,method = RequestMethod.PUT)
 *
 *                      @GetMapping @PostMapping @PutMapping @DeleteMapping：
 *                              方法注解；基于SpringMVC的RESTful开发控制器方法定义上方；设置当前控制器方法请求访问路径与请求动作，每种对应一个请求动作，例如@GetMapping对应GET请求。
 *
 *
 *              3.@RestController：类注解，设置当前控制器类为RESTful风格，等同于@Controller与@ResponseBody两个注解组合功能。
 *
 *
 * */


//REST风格操作没有简化的
@Controller
public class UserRestController {

    // REST风格【添加】：@PostMapping("/../{id}")     《==》   @RequestMapping(value =/../{id} ,method = RequestMethod.POST)
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    @ResponseBody
    public String save(){
        System.out.println("POST：user save...");
        return "{'module':'user save'}";
    }

    // REST风格【【删除】：@DeleteMapping("/../{id}")   《==》   @RequestMapping(value =/../{id} ,method = RequestMethod.DELETE)
    //@PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符，并且占位符名称与方法形参名称相同
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        System.out.println("DELETE：user delete..." + id);
        return "{'module':'user delete'}";
    }

    // REST风格【查询】：@GetMapping("/../{id}")      《==》   @RequestMapping(value =/../{id} ,method = RequestMethod.GET)
    //@PathVariable注解用于设置路径变量（路径参数），要求路径上设置对应的占位符{id}，并且占位符名称与方法形参名称相同
    @RequestMapping(value = "/users/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println("GET：user getById..."+id);
        return "{'module':'user getById'}";
    }

    // REST风格【查询】：@GetMapping("/../{id}")      《==》   @RequestMapping(value =/../{id} ,method = RequestMethod.GET)
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        System.out.println("GET：user getAll...");
        return "{'module':'user getAll'}";
    }

    // REST风格【修改】：@PutMapping("/../{id}")      《==》   @RequestMapping(value =/../{id} ,method = RequestMethod.PUT)
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("PUT：user update..."+user);
        return "{'module':'user update'}";
    }


}












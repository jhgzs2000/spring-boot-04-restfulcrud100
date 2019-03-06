package com.zbw.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @author zhangbin
 * @{DATE} - 20:00
 */
@Controller
public class HelloController {
   /* @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "hello world 2019！！！";
    }

    
    @RequestMapping("/success")
    public String success(Map<String,Object> map){

        map.put("hello","<h1>你好!</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        return "success";
    }

}

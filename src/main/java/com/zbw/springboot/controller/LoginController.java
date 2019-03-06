package com.zbw.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhangbin
 * @{DATE} - 15:15
 */
@Controller
public class LoginController {

    @PostMapping(value="/user/login")
    //@RequestMapping(value="/user/login",method= RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登陆成功,防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","登录失败");
            return "login";
        }


    }

}

package com.zbw.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangbin
 * @{DATE} - 16:30
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
    //目标方法执行之前
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            //未登录，跳转到登录页面
            request.setAttribute("msg","没有权限，请先登录!!!");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }


    }


}

package com.example.demo.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取uri
        String uri=request.getRequestURI();
        //如果请求地址是开放地址，放行（返回true）
        if(uri.indexOf("login.do")>=0||uri.indexOf("login.html")>=0){
            return true;
        }
        //获取session中的username的属性值username
        String token=(String) request.getSession().getAttribute("token");
        //如果username!=null,放行
        if(token!=null){
            //返回true表示放行，向下执行
            return true;
        }
        //执行到这一步，说明用户没有登录，进入登录页面（使用）
        response.sendRedirect("/login.html");
        //返回false,表示拦截，不向下执行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

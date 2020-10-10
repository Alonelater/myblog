package com.myblog.interceptor;

import jdk.nashorn.internal.ir.IfNode;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user")==null){
            request.getSession().setAttribute("message","请登录再继续操作");
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}

package com.myblog.config;

import com.myblog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //添加拦截映射规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截黑名单下面的白名单
        List<String> list = new ArrayList<>();
        list.add("/admin");
        list.add("/admin/login");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns(list);

    }
}

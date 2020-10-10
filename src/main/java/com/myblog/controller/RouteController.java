package com.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @RequestMapping("/")
    public String index() {

        return "index";
    }
    @RequestMapping("/blog")
    public String blog() {

        return "blog";
    }

    @RequestMapping("/login")
    public String login() {

        return "admin/login";
    }
}

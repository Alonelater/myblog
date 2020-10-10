package com.myblog.controller.admin;

import com.myblog.pojo.User;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private UserService userService;

    //登录页映射
    @GetMapping()
    public String loginPage(){
        return "/admin/login";
    }

    //登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes){


        User user = userService.checkUser(username, password);
        if (user!=null){
            //如果用户不为空 我们设置密码为空后再传给界面
            user.setPassword(null);
            session.setAttribute("user",user);
            return "/admin/index";
        }else {

            //携带一些消息 由于下面是重定向 所以我们这了使用的是另外一种方式传递信息
            redirectAttributes.addFlashAttribute("message","用户名或密码错误");

            //如果不存在我们就让他重定向回去登录界面 根据上面的请求路径映射
            return "redirect:/admin";
        }



    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }


}

package com.shop.controller;

import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("doLogin")
    public String doLogin() {
        return "login";
    }


    @RequestMapping("/login")
    public String login(String username,String userpassword,String vrifyCode, HttpSession session, Model model) {
        String randomCode = (String) session.getAttribute("vrifyCode");
        System.out.println("页面传过来的vrifyCode:" + vrifyCode);
        System.out.println("session中获取的验证码:" + randomCode);

        //判断
        if (!randomCode.equals(vrifyCode)) {
            //提示 验证码不正确
            model.addAttribute("errorMsg", "验证码错误");
            return "login";
        } else {
            //相等TODO
            List<User> userList = userService.login(username,userpassword);

            if(userList != null && userList.size()>0){
                return "redirect:/queryAuctions";
            }else{

                model.addAttribute("errorMsg","用户名或密码错误");
                return "login";
            }

        }
    }
}



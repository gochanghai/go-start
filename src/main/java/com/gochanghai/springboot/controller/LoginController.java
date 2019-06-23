package com.gochanghai.springboot.controller;

import com.gochanghai.springboot.dto.LoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
public class LoginController {

    //用户登录
    @PostMapping("login")
    public String loginUser(@RequestBody LoginDTO dto, HttpSession session) {
        //把前端输入的username和password封装为token
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUsername(), dto.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            return "ok";
        } catch (Exception e) {
            return "login";
        }
    }

    //退出登录
    @PostMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

}

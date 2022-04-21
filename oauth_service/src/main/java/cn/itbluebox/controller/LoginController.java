package cn.itbluebox.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login")
    public String login() {
        System.out.println("执行登录方法");
        return "redirect:main.html";

    }
}

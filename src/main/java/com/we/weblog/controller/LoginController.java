package com.we.weblog.controller;

import com.we.weblog.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@EnableAutoConfiguration注释，此注释自动载入应用程序所需的所有Bean
@Controller
public class LoginController {


    private  static UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService){
        this.userService = userService;
    }
    /**
     *  表单提交真正的登陆 检验session
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("/login1.action")
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean result = userService.checkLogin(username,password);
        if (result) {
            IndexController.loginStatus = true;
            userService.addSession(request,username);
            response.sendRedirect("/admin/main.html");
        }else {
            //登陆失败给他一个失败信息
            response.sendRedirect("/login?reuslt=fail");
        }
    }


    /**
     *  捕获login请求 这里并不是登陆
     */
    @GetMapping("/login")
    public void goLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String result = request.getParameter("result");
        if(result !=null && request.equals("fail")){
            //这里前端接收信息显示错误
        }

        response.sendRedirect("/login1.html");
    }


    @GetMapping("/logout")
    public void quitLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //销毁session
        userService.destorySession(request);
        IndexController.loginStatus = false;
        response.sendRedirect("/login.html");

    }
}

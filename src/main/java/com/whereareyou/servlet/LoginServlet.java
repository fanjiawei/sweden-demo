package com.whereareyou.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 家玮 on 2014/7/27.
 */
@Singleton
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsernamePasswordToken token = new UsernamePasswordToken(req.getParameter("username"), req.getParameter("password"));
        if(req.getParameter("rememberMe")!=null){
            token.setRememberMe(true);
        }
        SecurityUtils.getSubject().login(token);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

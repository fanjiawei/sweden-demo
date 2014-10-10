package com.whereareyou.servlet;

import com.google.inject.Provider;
import com.whereareyou.model.User;
import com.whereareyou.service.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class IndexServlet extends HttpServlet {
    private final UserService userService;

    @Inject
    public IndexServlet(Provider<UserService> userServiceProvider) {
        userService = userServiceProvider.get();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        if(user==null){
            user = userService.getCurrentUser();
            req.getSession().setAttribute("user",user);
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}

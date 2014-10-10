package com.whereareyou;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.whereareyou.model.User;
import com.whereareyou.servlet.IndexServlet;
import com.whereareyou.servlet.LoginServlet;
import com.whereareyou.servlet.Page1Servlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;

/**
 * Created by 家玮 on 2014/5/19.
 */
public class InitListener extends GuiceServletContextListener{
    final Logger logger = LoggerFactory.getLogger(InitListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.print("init 开始");
        try{
            User user = new User();
            user.setUsername("admin");
            user.setPassword("1234");

            Util.save(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        super.contextInitialized(servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new Modules(),new ServletModule(){
            @Override
            protected void configureServlets() {
//                serve("/position/*","/position").with(PositionServlet.class);
//                serve("/relationship/*","/relationship").with(RelationshipServlet.class);
                serve("/login").with(LoginServlet.class);
//                serve("/").with(IndexServlet.class);
                serve("/save").with(Page1Servlet.class);
//                filter("/*").through(MyFilter.class);
            }
        });
    }
}
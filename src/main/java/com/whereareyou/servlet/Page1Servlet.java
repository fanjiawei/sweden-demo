package com.whereareyou.servlet;

import com.google.inject.Provider;
import com.whereareyou.Util;
import com.whereareyou.model.InputValue;
import com.whereareyou.provider.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 家玮 on 2014/10/4.
 */
@Singleton
public class Page1Servlet extends HttpServlet {
    final static Logger log = LoggerFactory.getLogger(Page1Servlet.class);
    private final EntityManager em;
    @Inject
    public Page1Servlet(Provider<EntityManager> entityManagerProvider){this.em = entityManagerProvider.get();}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("hehehhehe");
        String dateParam = req.getParameter("date");
        Date date;
        try {
            if(null == dateParam || "".equals(dateParam)){
                throw new Exception();
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            date = dateFormat.parse(dateParam);
        } catch (Exception e) {
            e.printStackTrace();
            Writer writer = resp.getWriter();
            writer.write("Field date is invalid");
            writer.flush();
            writer.close();
            return;
        }
        for(int i=1;i<=25;i++){
            String value = req.getParameter("input_"+i);
            if(isInteger(value)){
                em.getTransaction().begin();
                Query query = em.createQuery("delete from InputValue iv where iv.name=:name and iv.date=:date");
                query.setParameter("name","input "+i);
                query.setParameter("date",date);
                query.executeUpdate();
                em.getTransaction().commit();
                InputValue inputValue = new InputValue();
                inputValue.setDate(date);
                inputValue.setValue(Integer.parseInt(value));
                inputValue.setName("input "+i);
                Util.save(inputValue);
            }
        }
        resp.sendRedirect("page2.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}

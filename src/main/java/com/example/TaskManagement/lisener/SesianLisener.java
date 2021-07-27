package com.example.TaskManagement.lisener;

import com.mysql.cj.Session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SesianLisener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.print("Session created !!!! :ID");
        System.out.println(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.print("Sesion destroyed !!!! :ID");
        System.out.println(se.getSession().getId());
    }
}

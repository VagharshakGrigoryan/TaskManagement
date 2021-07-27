package com.example.TaskManagement.lisener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AplicatinLissener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Welcomne");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("bay bay");
    }
}

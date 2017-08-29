package com.et.web.main;

import com.et.terminalserver.terminalaccess.main.MainStartUp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/28 9:30
 */
public class MainStartUpServlet implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        MainStartUp startUp=new MainStartUp(servletContext);
        startUp.startUp();
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}

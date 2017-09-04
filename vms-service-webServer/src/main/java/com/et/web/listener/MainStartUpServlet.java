package com.et.web.listener;

import com.et.terminalserver.terminalaccess.main.MainStartUp;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/28 9:30
 */
public class MainStartUpServlet extends ContextLoaderListener {

    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        ServletContext servletContext=sce.getServletContext();
        MainStartUp startUp=new MainStartUp(servletContext);
           startUp.startUp();
    }

    public void contextDestroyed(ServletContextEvent sce) {
         super.contextDestroyed(sce);
    }
}

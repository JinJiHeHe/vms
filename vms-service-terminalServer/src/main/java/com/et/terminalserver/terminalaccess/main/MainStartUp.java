package com.et.terminalserver.terminalaccess.main;

import com.et.terminalserver.common.server.MainServerSupport;

import javax.servlet.ServletContext;

/**
/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/25 10:24
 */
public class MainStartUp {
    ServletContext servletContext;
    public MainStartUp(ServletContext servletContext){
        this.servletContext=servletContext;
    }
    public void startUp(){
        System.out.println("aaaa");
           new MainServerSupport().process(servletContext);
           System.out.println("sss");
    }

}

package com.et.terminalserver.terminalaccess.main;

import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.common.server.MainServerSupport;

import javax.servlet.ServletContext;

/**
/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/25 10:24
 */
public class MainStartUp  {
    public LocalCache cache= LocalCacheManager.getCache("test");
    ServletContext servletContext;
    public MainStartUp(ServletContext servletContext){
        this.servletContext=servletContext;
    }
    public void startUp(){
        cache.put("test","hahahahahhhahha");
           Thread thread=new Thread(new MainServerSupport(servletContext));
           thread.start();
    }

}

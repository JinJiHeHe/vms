package com.et.terminalserver.terminalaccess.main;

import com.et.terminalserver.common.server.ServerSupport;

/**
/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/25 10:24
 */
public class MainStartUp {
    String applicationConfig;
    public void startUp(){
        String [] param={applicationConfig};
        System.out.println("aaaa");
           new ServerSupport().process(param);
           System.out.println("sss");
    }

    public String getApplicationConfig() {
        return applicationConfig;
    }

    public void setApplicationConfig(String applicationConfig) {
        this.applicationConfig = applicationConfig;
    }
}

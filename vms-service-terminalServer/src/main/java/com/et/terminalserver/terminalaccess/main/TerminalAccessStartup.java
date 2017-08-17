package com.et.terminalserver.terminalaccess.main;

import com.et.terminalserver.common.server.ServerSupport;

/**
 * @description:终端接入服务入口
 * @author:gaop
 * @version:1.0
 * @Date:2017/8/11 15:56
 */
public class TerminalAccessStartup {
    public  static void main(String[] args) {
        new ServerSupport().process(args);
    }
}

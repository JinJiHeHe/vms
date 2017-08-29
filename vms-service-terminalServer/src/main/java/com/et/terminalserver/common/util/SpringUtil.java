package com.et.terminalserver.common.util;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description spring单例
 * @author maple
 * @version V1.0
 * @Date 2015年4月21日 上午11:24:55
 * @mail rw222222@126.com
 */

public class SpringUtil {

	
	private static FileSystemXmlApplicationContext ctx;
	private static String PATH = "/vms-service-terminalServer/src/main/resources/applicationContext.xml";

	public static Object getBean(String beanName) {

		return ctx.getBean(beanName);
	}

	public static void start() {
		ctx.start();
	}

	public static void stop(){
		ctx.destroy();
		ctx.stop();
		ctx.close();
	}
	public static void init(String path) {
		if (null != path)
			PATH = path;
		ctx = new FileSystemXmlApplicationContext(PATH);
	}
}

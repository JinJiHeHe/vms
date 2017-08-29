package com.et.terminalserver.protocols.protocols.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class BaseClassLoader extends URLClassLoader{

	public BaseClassLoader(URL[] urls) {
		super(urls);
	}
	
	public Class<?> loadClass(String name, boolean resolve)throws ClassNotFoundException {
		
		return super.loadClass(name, resolve);
	}
	
	public void addJar(URL url){
		super.addURL(url);
	}
	
}

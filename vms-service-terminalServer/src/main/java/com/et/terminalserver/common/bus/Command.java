package com.et.terminalserver.common.bus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 监听器所传输的指令
 * @author maple
 * @version V1.0
 * @Date 2015年7月3日 下午5:27:55
 * @mail rw222222@126.com
 */
public class Command {

	//流水号计数器
	private final static AtomicInteger counter = new AtomicInteger();
	
	//流水号(这个东西 作为后台的流水号)
	private int opts = counter.getAndIncrement()>=65534?counter.addAndGet(-65535):counter.get();

	//指令ID
	private int code;

	//参数对象
	private Object param;

	//结果
	private Object result;

	//
	private boolean isSync = false;
	
	//指令来源
	private String source;

	public boolean isSync() {
		return isSync;
	}

	public void setSync(boolean isSync) {
		this.isSync = isSync;
	}

	public int getOpts() {
		return opts;
	}

	public void setOpts(int opts) {
		this.opts = opts;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getParam() {
		return param;
	}

	public void setParam(Object param) {
		this.param = param;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Command [opts=" + opts + ", code=" + code + ", param=" + param
				+ "]";
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 65540; i++) {
			Command command=new Command();
			System.out.println(command.getOpts());
		}
	}

}

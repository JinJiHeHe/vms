package com.et.terminalserver.common.util.xml;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Project CNPC_VMS
 * @Title module_name
 * @Description TODO
 * @author guanhl
 * @date 2014年8月7日 上午9:20:17
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class XmlException extends Exception {
	/**
	 * @Description 构造方法
	 */
	public XmlException() {
		this.errors = new ArrayList(0);
	}

	/**
	 * @Description 构造方法
	 */
	public XmlException(String msg) {
		super(msg);
		this.errors = new ArrayList(1);
		this.errors.add(msg);
	}

	/**
	 * @Description 构造方法
	 */
	public XmlException(Collection errors) {
		super(errors.toString());
		this.errors = errors;
	}

	/**
	 * @Description 获取异常
	 */
	public Collection getErrors() {
		return this.errors;
	}

	/**
	 * 错误集合
	 */
	private Collection errors = null;
}

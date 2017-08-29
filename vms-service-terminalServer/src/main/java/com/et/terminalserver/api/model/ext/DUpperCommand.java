package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 809 下级平台发送到上级平台的指令实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:00:29
 * @mail terrorbladeyang@gmail.com
 */

public class DUpperCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5037725981682785809L;

	/**
	 * 上级平台 服务信息 格式为 "192.168.1.1:8080"
	 */

	private String upPlateform;

	/**
	 * 指令代码
	 */

	private int command;

	/**
	 * 指令流水号（对应数据库中的指令发送ID），
	 */

	private long commandSeq;

	/**
	 * 指令参数 格式为"参数名:参数值;参数名:参数值;...(user:admin;password:admin)"
	 */

	private String params;

	public DUpperCommand() {
		super();
	}

	/**
	 * 上级平台 服务信息 格式为 "192.168.1.1:8080"
	 */
	public String getUpPlateform() {
		return upPlateform;
	}

	/**
	 * 上级平台 服务信息 格式为 "192.168.1.1:8080"
	 */
	public void setUpPlateform(String upPlateform) {
		this.upPlateform = upPlateform;
	}

	/**
	 * 指令代码
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * 指令代码
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	/**
	 * 指令流水号（对应数据库中的指令发送ID），
	 */
	public long getCommandSeq() {
		return commandSeq;
	}

	/**
	 * 指令流水号（对应数据库中的指令发送ID），
	 */
	public void setCommandSeq(long commandSeq) {
		this.commandSeq = commandSeq;
	}

	/**
	 * 指令参数 格式为"参数名:参数值;参数名:参数值;...(user:admin;password:admin)"
	 */
	public String getParams() {
		return params;
	}

	/**
	 * 指令参数 格式为"参数名:参数值;参数名:参数值;...(user:admin;password:admin)"
	 */
	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DUpperCommand [upPlateform=" + upPlateform + ", command=" + command + ", commandSeq=" + commandSeq
				+ ", params=" + params + "]";
	}

}

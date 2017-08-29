package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 809 下级平台发送到上级平台的指令执行结果实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:00:47
 * @mail terrorbladeyang@gmail.com
 */

public class DUpperCommandResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6709247576593657243L;
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
	/**
	 * 指令执行结果
	 */

	private String result;

	public DUpperCommandResult() {
		super();
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

	/**
	 * 指令执行结果，汉字描述
	 * 
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 指令执行结果，汉字描述
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DUpperCommandResult [command=" + command + ", commandSeq=" + commandSeq + ", params=" + params
				+ ", result=" + result + "]";
	}

}

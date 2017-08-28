package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 实时指令反馈信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:59:37
 * @mail terrorbladeyang@gmail.com
 */

public class DTerminalCommandResponse implements Serializable {
	
	private static final long serialVersionUID = 6591242681588050245L;
	/**
	 * 车辆ID
	 */

	private String vid;
	/**
	 * 流水号
	 */

	private int seqID;
	/**
	 * 结果
	 */

	private int result;
	/**
	 * 内容
	 */

	private String content;
	/**
	 * 命令字ID
	 */

	private int cmdID;

	public String getVid() {
		return this.vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public int getSeqID() {
		return seqID;
	}

	public void setSeqID(int seqID) {
		this.seqID = seqID;
	}

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCmdID() {
		return cmdID;
	}

	public void setCmdID(int cmdID) {
		this.cmdID = cmdID;
	}

	@Override
	public String toString() {
		return "DTerminalCommandResponse [vid=" + vid + ", seqID=" + seqID
				+ ", result=" + result + ", content=" + content + ", cmdID="
				+ cmdID + "]";
	}

}

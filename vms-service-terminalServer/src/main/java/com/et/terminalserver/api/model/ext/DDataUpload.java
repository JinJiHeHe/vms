package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 数据上行透传
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:45:39
 * @mail terrorbladeyang@gmail.com
 */
public class DDataUpload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private String terminalId;
	private Byte infoType;
	private String infoContent;
	private long timestamp;

	/**
	 * 终端id
	 * 
	 * @return
	 */
	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * 信息类型
	 * 
	 * @return
	 */
	public Byte getInfoType() {
		return infoType;
	}

	public void setInfoType(Byte infoType) {
		this.infoType = infoType;
	}

	/**
	 * 信息内容
	 * 
	 * @return
	 */
	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	/**
	 * 时间戳
	 * 
	 * @return
	 */
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "DDataUpload [terminalId=" + terminalId + ", infoType=" + infoType + ", infoContent=" + infoContent
				+ ", timeStamp=" + timestamp + "]";
	}
}

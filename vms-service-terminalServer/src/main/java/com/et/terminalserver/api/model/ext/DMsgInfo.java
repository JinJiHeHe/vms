package com.et.terminalserver.api.model.ext;
import java.io.Serializable;


/**
 * @Description 809 平台报文
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:51:46
 * @mail terrorbladeyang@gmail.com
 */
public class DMsgInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private long infoId;

	private String infoContent;

	/**
	 * 信息ID
	 * 
	 * @return
	 */
	public long getInfoId() {
		return infoId;
	}

	public void setInfoId(long infoId) {
		this.infoId = infoId;
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

	@Override
	public String toString() {
		return "DPostQuery [infoId=" + infoId + ", infoContent=" + infoContent + "]";
	}
}

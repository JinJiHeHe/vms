package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 
 * 809 平台查岗
 */

public class DPostQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private long infoId;

	private String infoContent;

	private long timestamp;

	private String platformId;

	private byte objectType;

	private String objectId;

	private int status;

	private int serialNo;

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

	/**
	 * 平台ID
	 * 
	 * @return
	 */
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	/**
	 * 对象类型
	 * 
	 * @return
	 */
	public byte getObjectType() {
		return objectType;
	}

	public void setObjectType(byte objectType) {
		this.objectType = objectType;
	}

	/**
	 * 对象ID
	 * 
	 * @return
	 */
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	/**
	 * 状态
	 * 
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 上级平台消息序号
	 * 
	 * @return
	 */
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "DPostQuery [infoId=" + infoId + ", infoContent=" + infoContent + ", timestamp=" + timestamp
				+ ", platformId=" + platformId + ", objectType=" + objectType + ", objectId=" + objectId + ", status="
				+ status + ", serialNo=" + serialNo + "]";
	}
}

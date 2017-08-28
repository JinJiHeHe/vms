package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description DMultiMediaEvent
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:52:06
 * @mail terrorbladeyang@gmail.com
 */
public class DMultiMediaEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8809615488775045300L;

	private int multimediaID;// 多媒体数据ID

	private byte multimediaType;// 多媒体类型

	private byte multimediaMode;// 多媒体格式编码

	private byte multimediaEvent;// 事件项编码

	private byte cameraNO;// 通道ID

	private DGpsInfomation gpsinfo;// GPS定位信息

	private String vehicleId;

	private long timestamp;

	public DGpsInfomation getGpsinfo() {
		return gpsinfo;
	}

	public void setGpsinfo(DGpsInfomation gpsinfo) {
		this.gpsinfo = gpsinfo;
	}

	public int getMultimediaID() {
		return multimediaID;
	}

	public void setMultimediaID(int multimediaID) {
		this.multimediaID = multimediaID;
	}

	public byte getMultimediaType() {
		return multimediaType;
	}

	public void setMultimediaType(byte multimediaType) {
		this.multimediaType = multimediaType;
	}

	public byte getMultimediaMode() {
		return multimediaMode;
	}

	public void setMultimediaMode(byte multimediaMode) {
		this.multimediaMode = multimediaMode;
	}

	public byte getMultimediaEvent() {
		return multimediaEvent;
	}

	public void setMultimediaEvent(byte multimediaEvent) {
		this.multimediaEvent = multimediaEvent;
	}

	public byte getCameraNO() {
		return cameraNO;
	}

	public void setCameraNO(byte cameraNO) {
		this.cameraNO = cameraNO;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "DMultiMediaEvent [multimediaID=" + multimediaID + ", multimediaType=" + multimediaType
				+ ", multimediaMode=" + multimediaMode + ", multimediaEvent=" + multimediaEvent + ", cameraNO="
				+ cameraNO + ", gpsinfo=" + gpsinfo + ", vehicleId=" + vehicleId + ", timestamp=" + timestamp + "]";
	}

}

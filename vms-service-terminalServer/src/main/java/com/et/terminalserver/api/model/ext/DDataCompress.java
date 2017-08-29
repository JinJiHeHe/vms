package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Description 808 数据压缩上报
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:45:19
 * @mail terrorbladeyang@gmail.com
 */
public class DDataCompress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;
	/**
	 * 压缩后的数据内容
	 */
	private byte[] content;

	/**
	 * 时间戳
	 */
	private Long timestamp;
	/**
	 * 车牌号
	 */
	private String vehicleNo;
	/**
	 * 车牌颜色
	 */
	private int vehicleColor;

	/**
	 * 压缩后的数据内容
	 * 
	 * @return
	 */
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	/**
	 * 时间戳
	 * 
	 * @return
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 车牌号
	 * 
	 * @return
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * 车牌颜色
	 * 
	 * @return
	 */
	public int getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(int vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	@Override
	public String toString() {
		return "DDataCompress [content=" + Arrays.toString(content) + ", timestamp=" + timestamp + ", vehicleNo="
				+ vehicleNo + ", vehicleColor=" + vehicleColor + "]";
	}
}

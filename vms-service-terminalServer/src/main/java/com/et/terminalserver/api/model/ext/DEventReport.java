package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 808 事件报告
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:47:39
 * @mail terrorbladeyang@gmail.com
 */
public class DEventReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private String vehicleId;
	private int eventId;
	private long timestamp;

	/**
	 * 车辆ID
	 * 
	 * @return
	 */
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 事件ID
	 * 
	 * @return
	 */
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
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
		return "DEventReport [vehicleId=" + vehicleId + ", eventId=" + eventId + ", timestamp=" + timestamp + "]";
	}
}

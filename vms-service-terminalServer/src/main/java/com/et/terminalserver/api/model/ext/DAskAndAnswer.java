package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 808提问应答
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:43:41
 * @mail terrorbladeyang@gmail.com
 */
public class DAskAndAnswer implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4966806858454415961L;
	/**
	 * 提问下发消息流水号
	 */
	private Long msgId;
	/**
	 * 下发中附带答案ID
	 */
	private Integer answerId;
	/**
	 * 时间戳
	 */
	private Long timestamp;
	/**
	 * 车牌号
	 */
	private String vehicleNo;
	/**
	 * 车牌号
	 */
	private int vehicleColor;

	/**
	 * 提问下发消息流水号
	 * 
	 * @return
	 */
	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	/**
	 * 下发中附带答案ID
	 * 
	 * @return
	 */
	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
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
		return "DAskAndAnswer [msgId=" + msgId + ", answerId=" + answerId + ", timestamp=" + timestamp + ", vehicleNo="
				+ vehicleNo + ", vehicleColor=" + vehicleColor + "]";
	}
}

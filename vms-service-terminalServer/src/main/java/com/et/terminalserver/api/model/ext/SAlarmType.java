package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 报警类型
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:03:39
 * @mail terrorbladeyang@gmail.com
 */

public class SAlarmType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6109497940305530426L;
	/**
	 * 报警类型ID
	 */

	private Integer alarmTypeId;
	/**
	 * 报警类型
	 */

	private String alarmTypeName;
	/**
	 * 报警类型描述
	 */

	private String alarmTypeDesc;
	/**
	 * 排序号
	 */

	private Integer orderNumber;

	public Integer getAlarmTypeId() {
		return alarmTypeId;
	}

	public void setAlarmTypeId(Integer alarmTypeId) {
		this.alarmTypeId = alarmTypeId;
	}

	public String getAlarmTypeName() {
		return alarmTypeName;
	}

	public void setAlarmTypeName(String alarmTypeName) {
		this.alarmTypeName = alarmTypeName;
	}

	public String getAlarmTypeDesc() {
		return alarmTypeDesc;
	}

	public void setAlarmTypeDesc(String alarmTypeDesc) {
		this.alarmTypeDesc = alarmTypeDesc;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		return "SAlarmType [alarmTypeId=" + alarmTypeId + ", alarmTypeName=" + alarmTypeName + ", alarmTypeDesc="
				+ alarmTypeDesc + ", orderNumber=" + orderNumber + "]";
	}

}

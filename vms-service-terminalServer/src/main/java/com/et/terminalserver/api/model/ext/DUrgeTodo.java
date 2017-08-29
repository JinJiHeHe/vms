package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 
 * 809 报警督办
 */

public class DUrgeTodo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private String vehicleNo;

	private Byte vehicleColor;

	private Byte warnSrc;

	private int warType;

	private String warnTime;

	private int supervisionId;

	private String supervisionEndTime;

	private Byte supervisionLevel;

	private String supervisor;

	private String supervisorTel;

	private String supervisorEmail;

	private String platformId;

	private int status;

	private int serialNo;

	private long timestamp;

	/**
	 * 车牌号码
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
	public Byte getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(Byte vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * 报警信息来源
	 * 
	 * @return
	 */
	public Byte getWarnSrc() {
		return warnSrc;
	}

	public void setWarnSrc(Byte warnSrc) {
		this.warnSrc = warnSrc;
	}

	/**
	 * 报警类型
	 * 
	 * @return
	 */
	public int getWarType() {
		return warType;
	}

	public void setWarType(int warType) {
		this.warType = warType;
	}

	/**
	 * 报警时间
	 * 
	 * @return
	 */
	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	/**
	 * 报警督办ID
	 * 
	 * @return
	 */
	public int getSupervisionId() {
		return supervisionId;
	}

	public void setSupervisionId(int supervisionId) {
		this.supervisionId = supervisionId;
	}

	/**
	 * 督办截止时间
	 * 
	 * @return
	 */
	public String getSupervisionEndTime() {
		return supervisionEndTime;
	}

	public void setSupervisionEndTime(String supervisionEndTime) {
		this.supervisionEndTime = supervisionEndTime;
	}

	/**
	 * 督办级别
	 * 
	 * @return
	 */
	public Byte getSupervisionLevel() {
		return supervisionLevel;
	}

	public void setSupervisionLevel(Byte supervisionLevel) {
		this.supervisionLevel = supervisionLevel;
	}

	/**
	 * 督办人
	 * 
	 * @return
	 */
	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * 督办联系电话
	 * 
	 * @return
	 */
	public String getSupervisorTel() {
		return supervisorTel;
	}

	public void setSupervisorTel(String supervisorTel) {
		this.supervisorTel = supervisorTel;
	}

	/**
	 * 督办联系电子邮件
	 * 
	 * @return
	 */
	public String getSupervisorEmail() {
		return supervisorEmail;
	}

	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
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
	 * 督办状态
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
		return "DUrgeTodo [vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + ", warnSrc=" + warnSrc
				+ ", warType=" + warType + ", warnTime=" + warnTime + ", supervisionId=" + supervisionId
				+ ", supervisionEndTime=" + supervisionEndTime + ", supervisionLevel=" + supervisionLevel
				+ ", supervisor=" + supervisor + ", supervisorTel=" + supervisorTel + ", supervisorEmail="
				+ supervisorEmail + ", platformId=" + platformId + ", status=" + status + ", serialNo=" + serialNo
				+ ", timestamp=" + timestamp + "]";
	}
}

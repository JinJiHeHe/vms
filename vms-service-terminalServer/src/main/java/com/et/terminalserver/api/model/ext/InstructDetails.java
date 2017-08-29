package com.et.terminalserver.api.model.ext;
import java.sql.Timestamp;

/**
 * @Description 指令详细信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:03:02
 * @mail terrorbladeyang@gmail.com
 */
public class InstructDetails implements java.io.Serializable {
	private static final long serialVersionUID = 8798086448403872390L;
	/**
	 * 用户名
	 */

	private String userName;
	/**
	 * 单位名称
	 */

	private String orgName;
	/**
	 * 反馈ID
	 */

	private Integer backId;
	/**
	 * 点名ＩＤ
	 */

	private Integer vehicleRollCallId;
	/**
	 * 车辆ID
	 */

	private Integer vehicleId;
	/**
	 * 车牌号
	 */

	private String plate;
	/**
	 * 发送时间
	 */

	private Timestamp sendTime;
	/**
	 * 发送内容
	 */

	private String content;
	/**
	 * 命令类型
	 */

	private String commandType;
	/**
	 * SIM卡ID
	 */

	private String simId;
	/**
	 * 用户编号
	 */

	private String userCode;
	/**
	 * 发送状态
	 */

	private String sendStatus;
	/**
	 * 反馈状态
	 */

	private String backStatus;
	/**
	 * 单位编号
	 */

	private String orgCode;

	/**
	 * 终端指令ID
	 */

	private String cmdID;

	/**
	 * IfTerParFlag:是否终端参数(0:否,1:是)
	 */

	private String cmdProperty;

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "InstructDetails [backId=" + backId + ", vehicleRollCallId=" + vehicleRollCallId + ", vehicleId="
				+ vehicleId + ", sendTime=" + sendTime + ", content=" + content + ", simId=" + simId + ", userCode="
				+ userCode + ", sendStatus=" + sendStatus + ", backStatus=" + backStatus + ", orgCode=" + orgCode
				+ ", userName=" + userName + ", orgName=" + orgName + "]";
	}

	public Integer getBackId() {
		return backId;
	}

	public void setBackId(Integer backId) {
		this.backId = backId;
	}

	public Integer getVehicleRollCallId() {
		return vehicleRollCallId;
	}

	public void setVehicleRollCallId(Integer vehicleRollCallId) {
		this.vehicleRollCallId = vehicleRollCallId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSimId() {
		return simId;
	}

	public void setSimId(String simId) {
		this.simId = simId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getBackStatus() {
		return backStatus;
	}

	public void setBackStatus(String backStatus) {
		this.backStatus = backStatus;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCmdID() {
		return cmdID;
	}

	public void setCmdID(String cmdID) {
		this.cmdID = cmdID;
	}

	public String getCmdProperty() {
		return cmdProperty;
	}

	public void setCmdProperty(String cmdProperty) {
		this.cmdProperty = cmdProperty;
	}

}

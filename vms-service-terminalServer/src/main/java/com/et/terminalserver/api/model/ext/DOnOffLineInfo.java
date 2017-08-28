package com.et.terminalserver.api.model.ext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 上下线信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:52:38
 * @mail terrorbladeyang@gmail.com
 */
public class DOnOffLineInfo implements java.io.Serializable {
	
	public final static int ON_LINE=1;
	
	public final static int OFF_LINE=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3149495855244581732L;
	/**
	 * 车辆ID
	 */

	private int vehicleId;
	/**
	 * 车牌号
	 */

	private String plate;
	/**
	 * 终端号
	 */

	private String terminalId;
	/**
	 * sim
	 */

	private String sim;
	/**
	 * 经度
	 */

	private double longitude;
	/**
	 * 高度
	 */

	private float altitude;
	/**
	 * 纬度
	 */

	private double latitude;
	/**
	 * 驾驶员姓名
	 */

	private String driver;
	/**
	 * 中文地理位置
	 */

	private String address;
	/**
	 * 上下线标识
	 * // 上下线标记（0 下线，1 上线）
	 */

	private int flag;
	/**
	 * GPS时间
	 */

	private java.sql.Timestamp time;
	
	/**
	 * 推送用户列表 add by Wang 2015-07-12
	 */
	private Set<String> userList=new HashSet<String>();

	/**
	 * 车辆ID
	 * 
	 * @return
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * 车辆ID
	 * 
	 * @param vehicleId
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 车牌号
	 * 
	 * @return
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * 车牌号
	 * 
	 * @param plate
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * 终端号
	 * 
	 * @return
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * 终端号
	 * 
	 * @param terminalId
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * sim
	 * 
	 * @return
	 */
	public String getSim() {
		return sim;
	}

	/**
	 * sim
	 * 
	 * @param sim
	 */
	public void setSim(String sim) {
		this.sim = sim;
	}

	/**
	 * 经度
	 * 
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * 经度
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 海拔
	 * 
	 * @return
	 */
	public float getAltitude() {
		return altitude;
	}

	/**
	 * 海拔
	 * 
	 * @param altitude
	 */
	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	/**
	 * 纬度
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * 纬度
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 驾驶员
	 * 
	 * @return
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * 驾驶员
	 * 
	 * @param driver
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * 车辆位置
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 车辆位置
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 上下线标记（0 下线，1 上线）
	 * 
	 * @return
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * 上下线标记（0 下线，1 上线）
	 * 
	 * @param flag
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}

	/**
	 * 时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getTime() {
		return time;
	}

	/**
	 * 时间
	 * 
	 * @param time
	 */
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}
	
	public Set<String> getUserList() {
		return userList;
	}

	public void setUserList(Set<String> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "DOnOffLineInfo [vehicleId=" + vehicleId + ", plate=" + plate + ", terminalId=" + terminalId + ", sim="
				+ sim + ", longitude=" + longitude + ", altitude=" + altitude + ", latitude=" + latitude + ", driver="
				+ driver + ", address=" + address + ", flag=" + flag + ", time=" + time + "]";
	}

}

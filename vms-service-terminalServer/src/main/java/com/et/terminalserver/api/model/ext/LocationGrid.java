package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 位置网格数据实体类
 *
 */

public class LocationGrid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7969698568800185003L;

	/**
	 * 经度
	 */

	private int longitude;
	/**
	 * 纬度
	 */

	private int latitude;
	/**
	 * admin Code
	 */

	private String[] code;

	/**
	 * 
	 * @param longitude
	 *            经度
	 * @param latitude
	 *            纬度
	 * @param code
	 *            admin code
	 */
	public LocationGrid(int longitude, int latitude, String[] code) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.code = code;
	}

	/**
	 * 获得经度
	 * 
	 * @return
	 */
	public int getLongitude() {
		return longitude;
	}

	/**
	 * 
	 * @param longitude
	 *            返回经度
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return 返回纬度
	 */
	public int getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 *            纬度
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	/**
	 * 
	 * @return 返回admin code
	 */
	public String[] getCode() {
		return code;
	}

	/**
	 * 设置admin code
	 * 
	 * @param code
	 */
	public void setCode(String[] code) {
		this.code = code;
	}

	@Override
	public String toString() {

		return "LocationGrid [longitude=" + longitude + ", latitude=" + latitude + ", code="
				+ (code == null ? "null" : (code.length > 0 ? code[0] + " ..." : "length is 0")) + "]";
	}

}

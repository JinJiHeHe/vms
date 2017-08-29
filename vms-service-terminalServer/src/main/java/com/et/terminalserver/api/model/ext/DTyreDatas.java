package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 轮胎数据内容
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:59:54
 * @mail terrorbladeyang@gmail.com
 */

public class DTyreDatas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3791293887442926223L;
	/**
	 * 轮胎ID dword
	 */

	private int tyreID;
	/**
	 * 轮胎压力 dword
	 */

	private int tyrePressure;
	/**
	 * 轮胎温度 dword
	 */

	private int tyreTemperature;

	/**
	 * @return the tyreID
	 */
	public int getTyreID() {
		return tyreID;
	}

	/**
	 * @param tyreID
	 *            the tyreID to set
	 */
	public void setTyreID(int tyreID) {
		this.tyreID = tyreID;
	}

	/**
	 * @return the tyrePressure
	 */
	public int getTyrePressure() {
		return tyrePressure;
	}

	/**
	 * @param tyrePressure
	 *            the tyrePressure to set
	 */
	public void setTyrePressure(int tyrePressure) {
		this.tyrePressure = tyrePressure;
	}

	/**
	 * @return the tyreTemperature
	 */
	public int getTyreTemperature() {
		return tyreTemperature;
	}

	/**
	 * @param tyreTemperature
	 *            the tyreTemperature to set
	 */
	public void setTyreTemperature(int tyreTemperature) {
		this.tyreTemperature = tyreTemperature;
	}

	@Override
	public String toString() {
		return "DTyreDatas [tyreID=" + tyreID + ", tyrePressure=" + tyrePressure + ", tyreTemperature="
				+ tyreTemperature + "]";
	}

}

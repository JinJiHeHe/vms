package com.et.terminalserver.api.model.ext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 轮胎上报记录数据格式表
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:00:07
 * @mail terrorbladeyang@gmail.com
 */

public class DTyreStatusRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611646164970427279L;
	/**
	 * 轮胎个数 byte
	 */

	private int tyreNumbers;
	/**
	 * 轮胎数据内容
	 */

	private DTyreDatas[] tyreData;

	/**
	 * @return the tyreNumbers
	 */
	public int getTyreNumbers() {
		return tyreNumbers;
	}

	/**
	 * @param tyreNumbers
	 *            the tyreNumbers to set
	 */
	public void setTyreNumbers(int tyreNumbers) {
		this.tyreNumbers = tyreNumbers;
	}

	/**
	 * @return the tyreData
	 */
	public DTyreDatas[] getTyreData() {
		return tyreData;
	}

	/**
	 * @param tyreData
	 *            the tyreData to set
	 */
	public void setTyreData(DTyreDatas[] tyreData) {
		this.tyreData = tyreData;
	}

	@Override
	public String toString() {
		return "DTyreStatusRecord [tyreNumbers=" + tyreNumbers + ", tyreData=" + Arrays.toString(tyreData) + "]";
	}
}

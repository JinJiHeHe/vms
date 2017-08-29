package com.et.terminalserver.api.model.ext;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Description GPS信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:48:27
 * @mail terrorbladeyang@gmail.com
 */

public class DGpsInfoHis implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7084102389222193887L;
	/**
	 * 循环列表长度 默认为5
	 */

	private Integer length = 5;
	/**
	 * 循环列表数组
	 */

	private GpsInfoFromTerminal[] list;
	/**
	 * 当前列表游标
	 */

	private Integer index = 0;
	/**
	 * iterator游标
	 */

	private Integer cur = 0;
	/**
	 * 大小
	 */

	private Integer size = 0;
	/**
	 * 车辆ID
	 */

	private Integer vehicleId;
	/**
	 * 单位编号
	 */

	private String orgCode;
	/**
	 * 单位名称
	 */

	private String orgName;
	/**
	 * 车牌号
	 */

	private String idNumber;
	/**
	 * 车辆类型
	 */

	private Integer typeId;
	/**
	 * 主驾驶员ID
	 */

	private Integer mainDriverId;
	/**
	 * SIM卡号
	 */

	private String sim;
	/**
	 * 终端编号
	 */

	private String terminalCode;
	/**
	 * json结构
	 */

	private String jsonResult;
	/**
	 * 车牌号颜色
	 */

	private String plateColor;
	/**
	 * 是否是黑名单
	 */

	private Integer blackListFlag;
	/**
	 * 数据库默认驾驶员
	 */

	private String driver;
	/**
	 * 车辆登录的驾驶员
	 */

	private String realDriver;

	/**
	 * 功能编码
	 */

	private String functionCode;
	// 驾驶员手机号

	private String driverPhone;
	// 终端类型名

	private String terminalName;

	// 终端报警限速

	private Double terAlarmSpeed;

	// 平台报警限速

	private Double plateAlarmSpeed;

	// 平台预警限速

	private Double plateWarnSpeed;

	// 终端回传间隔

	private Integer rInterval;

	// 静态数据来源

	private String dataFrom;

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public DGpsInfoHis() {
		this(5);

	}

	public DGpsInfoHis(int length) {
		if (length < 1) {
			throw new IllegalStateException("length长度不能小于0");
		}
		this.length = length;
		list = new GpsInfoFromTerminal[length];
		/*
		 * for (int i = 0; i < length; i++) { list.add(null); }
		 */
	}

	public DGpsInfoHis(SVehicleInfo info) {
		this(5, info);
	}

	/**
	 * 静态数据加载到历史数据
	 * 
	 * @param length
	 * @param info
	 */
	public DGpsInfoHis(int length, SVehicleInfo info) {
		this(length);

		this.vehicleId = info.getVehicleId();
		this.orgCode = info.getOrgCode();
		this.orgName = info.getOrgName();
		this.idNumber = info.getIdNumber();
		this.typeId = info.getTypeId();
		this.mainDriverId = info.getPDriverId();
		this.sim = info.getSimNum();
		this.terminalCode = info.getTerminalCode();
		this.plateColor = info.getColorIdNumberId();
		this.driver = info.getDriverName();
		this.functionCode = info.getFunctionCode();
		this.driverPhone = info.getDriverPhone();
		this.terminalName = info.getTerminalName();
		this.plateAlarmSpeed = info.getSpeed();
		this.plateWarnSpeed = info.getWarningSpeed();
		this.terAlarmSpeed = info.getTerAlarmSpeed();
		this.rInterval = info.getRinterval();
		this.dataFrom = info.getDataFrom();
	}

	/**
	 * 更新GPS点数据
	 * 
	 * @param entity
	 */
	public void put(GpsInfoFromTerminal entity) {
		index = ((index + 1) % length);
		if (size < length) {
			size++;
		}
		list[index] = entity;
	}

	/**
	 * @Description:获得当前最新的数据
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public GpsInfoFromTerminal get() {
		return list[index];
	}

	/**
	 * 获得详细的GPS 车辆信息
	 * 
	 * @return
	 */
	public VehicleGpsInfo getExt() {
		return getExt(get());
	}

	/**
	 * 获得JSON结果
	 * 
	 * @return
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * 设置JSON结果
	 * 
	 * @param jsonResult
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * @Description:获得指定位置的数据，0 表示当前数据，1表示前一条数据，2表示前2条数据。。。
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public GpsInfoFromTerminal get(int i) {
		if (0 > i || i >= length) {
			throw new IllegalStateException("游标超范围");
		}
		int tmp = ((index - i) % length);
		tmp = tmp >= 0 ? tmp : tmp + length;
		return list[tmp];
	}

	/**
	 * 获得第N个GPS数据
	 * 
	 * @param i
	 * @return
	 */
	public VehicleGpsInfo getExt(int i) {
		return getExt(this.get(i));
	}

	/**
	 * 获得长度
	 * 
	 * @return
	 */
	public int length() {
		return length;
	}

	/**
	 * 获得Iterator
	 * 
	 * @return
	 */
	public Iterator<GpsInfoFromTerminal> iterator() {
		return new HisIterator();
	}

	public DGpsInfoHis(int length, String orgCode, String orgName, String idNumber, Integer typeId,
			Integer mainDriverId, Integer vid, String sim, String terminalID, String plateColor) {
		super();
		this.length = length;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.idNumber = idNumber;
		this.typeId = typeId;
		this.mainDriverId = mainDriverId;
		this.vehicleId = vid;
		this.sim = sim;
		this.terminalCode = terminalID;
		this.plateColor = plateColor;
	}


	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getMainDriverId() {
		return mainDriverId;
	}

	public void setMainDriverId(Integer mainDriverId) {
		this.mainDriverId = mainDriverId;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	public Integer getBlackListFlag() {
		return blackListFlag;
	}

	public void setBlackListFlag(Integer blackListFlag) {
		this.blackListFlag = blackListFlag;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getRealDriver() {
		return realDriver;
	}

	public void setRealDriver(String realDriver) {
		this.realDriver = realDriver;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	/**
	 * @return the functionCode
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * @param functionCode
	 *            the functionCode to set
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * @return the terAlarmSpeed
	 */
	public Double getTerAlarmSpeed() {
		return terAlarmSpeed;
	}

	/**
	 * @param terAlarmSpeed
	 *            the terAlarmSpeed to set
	 */
	public void setTerAlarmSpeed(Double terAlarmSpeed) {
		this.terAlarmSpeed = terAlarmSpeed;
	}

	/**
	 * @return the plateAlarmSpeed
	 */
	public Double getPlateAlarmSpeed() {
		return plateAlarmSpeed;
	}

	/**
	 * @param plateAlarmSpeed
	 *            the plateAlarmSpeed to set
	 */
	public void setPlateAlarmSpeed(Double plateAlarmSpeed) {
		this.plateAlarmSpeed = plateAlarmSpeed;
	}

	/**
	 * @return the plateWarnSpeed
	 */
	public Double getPlateWarnSpeed() {
		return plateWarnSpeed;
	}

	/**
	 * @param plateWarnSpeed
	 *            the plateWarnSpeed to set
	 */
	public void setPlateWarnSpeed(Double plateWarnSpeed) {
		this.plateWarnSpeed = plateWarnSpeed;
	}

	/**
	 * @return the rInterval
	 */
	public Integer getrInterval() {
		return rInterval;
	}

	/**
	 * @param rInterval
	 *            the rInterval to set
	 */
	public void setrInterval(Integer rInterval) {
		this.rInterval = rInterval;
	}

	/**
	 * 获得带有gps信息的车辆数据
	 * 
	 * @param ent
	 * @return
	 */
	public VehicleGpsInfo getExt(GpsInfoFromTerminal ent) {
		return new VehicleGpsInfo(this.orgCode, this.orgName, this.idNumber, this.typeId,
				this.mainDriverId, this.vehicleId, this.sim, this.terminalCode, ent, plateColor, blackListFlag,
				// 如果有驾驶员登录就用登录的驾驶员
				null == this.realDriver ? this.driver : this.realDriver, this.functionCode, this.driverPhone,
				this.terminalName, this.terAlarmSpeed, this.plateAlarmSpeed, this.plateWarnSpeed, this.rInterval,
				this.dataFrom);
	}

	@Override
	public String toString() {
		return "DGpsInfoHis [length=" + length + ", list=" + Arrays.toString(list) + ", index=" + index + ", cur=" + cur
				+ ", size=" + size + ", vehicleId=" + vehicleId + ", orgCode=" + orgCode + ", orgName=" + orgName
				+ ", idNumber=" + idNumber + ", typeId=" + typeId + ", mainDriverId=" + mainDriverId + ", sim=" + sim
				+ ", terminalCode=" + terminalCode + ", jsonResult=" + jsonResult + ", plateColor=" + plateColor
				+ ", blackListFlag=" + blackListFlag + ", driver=" + driver + ", realDriver=" + realDriver
				+ ", functionCode=" + functionCode + ", driverPhone=" + driverPhone + ", terminalName=" + terminalName
				+ ", terAlarmSpeed=" + terAlarmSpeed + ", plateAlarmSpeed=" + plateAlarmSpeed + ", plateWarnSpeed="
				+ plateWarnSpeed + ", rInterval=" + rInterval + ", dataFrom=" + dataFrom + "]";
	}

	private class HisIterator implements Iterator<GpsInfoFromTerminal> {

		HisIterator() {
			cur = 0;
		}

		@Override
		public boolean hasNext() {
			return cur < length;
		}

		@Override
		public GpsInfoFromTerminal next() {

			return get(cur++);
		}

		@Override
		public void remove() {
			throw new IllegalStateException("不支持删除");
		}

	}

}

package com.et.terminalserver.api;

/**
 * @Description gis相关接口
 * @author maple
 * @version V1.0
 * @Date 2015年7月8日 上午12:46:00
 * @mail rw222222@126.com
 */
public interface GisCompute {
	/**
	 * 计算一个点，是否在图层中某一个区域内
	 * 
	 * @param lat
	 *            经度
	 * @param lon
	 *            纬度
	 * @param layerName
	 *            图层名
	 */
	public boolean isPointInAreas(double lat, double lon, String layerName);

	/**
	 * 计算一个点，是否在指定区域内
	 * 
	 * @param lat
	 *            经度
	 * @param lon
	 *            纬度
	 * @param layerName
	 *            图层名
	 * @param geoId
	 *            区域id
	 */
	public boolean isPointInOneArea(double lat, double lon, String layerName,
                                    String geoId);

	/**
	 * 计算一个点，是否在指定线路内
	 *
	 * @param lat
	 *            经度
	 * @param lon
	 *            纬度
	 * @param layerName
	 *            图层名
	 * @param geoId
	 *            线路id
	 *
	 */
	public boolean isPointInOneLine(double lat, double lon, String layerName,
                                    String geoId);

	/**
	 * 获取一个点的中文地址
	 * 
	 * @param lat
	 *            精度
	 * @param lon
	 *            纬度
	 */
	public String getLocaltionName(double lat, double lon);
}

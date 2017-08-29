package com.et.terminalserver.common.util;


import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @Project: CNPC_VMS
 * @Title: 图形类计算工具
 * @Description: 几何计算工具
 * @author: zhouyu
 * @date: 2014年4月17日 下午4:40:14
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class GeometryUtil {
	/**
	 * @Description:获取地址网格编号
	 * @return 经度 6位 + 纬度 5位,一共11位表示
	 */
	public static String getAddressGridID(double longtidue, double latitude) {
		String addressGridID = "";
		// 经度 6位 + 纬度 5位
		addressGridID = StringUtil.padding((int) (longtidue * 1000) + "", "0", 6) + StringUtil.padding((int) (latitude * 1000) + "", "0", 6);

		return addressGridID;
	}

	/**
	 * @Description:WGS-84 转 GCJ-02 参考百度纠偏 误差小于10米
	 */

	// 圆周率
	static double pi = 3.14159265358979324;
	// 椭球体参数
	static double a = 6378245.0;
	// 不大了解
	static double ee = 0.00669342162296594323;

	public static LonLat transform(double wgLat, double wgLon, LonLat coord) {
		// 判断中国范围
		if (outOfChina(wgLat, wgLon)) {
			coord.setLatitude(wgLat);
			coord.setLongitude(wgLon);
			return coord;
		}
		double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
		double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
		double radLat = wgLat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		coord.setLatitude(wgLat + dLat);
		coord.setLongitude(wgLon + dLon);

		return coord;
	}

	/**
	 * @Description 是否在中国范围
	 */
	static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	/**
	 * @Description 计算纬度
	 */
	static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	/**
	 * @Description 计算精度
	 */
	static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}

	/**
	 * @description 计算两点之间的距离
	 * @param lon1 第一个位置点的经度
	 * @param lat1 第一个位置点的纬度
	 * @param lon2 第二个位置点的经度
	 * @param lat2 第二个位置点的纬度
	 * @return 距离
	 */
	public static double distanceByLnglat(double lon1, double lat1, double lon2, double lat2) {

		double radLat1 = lat1 * Math.PI / 180;
		double radLat2 = lat2 * Math.PI / 180;
		double a = radLat1 - radLat2; // 纬度角度*PI的差
		double b = lon1 * Math.PI / 180 - lon2 * Math.PI / 180; // 经度角度*PI的差
		// 地球是一个近乎标准的椭球体，它的赤道半径为6378.140千米，极半径为6356.755千米，平均半径6371.004千米。
		// 如果我们假设地球是一个完美的球体，那么它的半径就是地球的平均半径，记为R。
		// 如果以0度经线为基准，那么根据地球表面任意两点的经纬度就可以计算出这两点间的地表距离
		// （这里忽略地球表面地形对计算带来的误差，仅仅是理论上的估算值）。设第一点A的经纬度为(LonA, LatA)，
		// 第二点B的经纬度为(LonB, LatB)，按照0度经线的基准，东经取经度的正值(Longitude)，
		// 西经取经度负值(-Longitude)，北纬取90-纬度值(90-Latitude)，
		// 南纬取90+纬度值(90+Latitude)，则经过上述处理过后的两点被计为(MLonA, MLatA)和(MLonB, MLatB)。
		// 那么根据三角推导，可以得到计算两点距离的如下公式：
		// C = sin(MLatA)*sin(MLatB)*cos(MLonA-MLonB) + cos(MLatA)*cos(MLatB)
		// Distance = R*Arccos(C)*Pi/180
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		s = Math.round(s * 10000) / (double) 10000;

		DecimalFormat df = new DecimalFormat("###.00");
		s = Double.valueOf(df.format(s));
		return s;
	}
	
	/**
	 * @description 得到网格ID(用于网格计算)： 首先判断所传经纬度是否在中国范围内， 然后再根据纬度大于原点（7300，1800）的Y轴多远，即(latitude - 1800) * 6300， X轴只需要(longitude - 7300)取整即可。
	 * @param lon 此刻车辆所在的经度
	 * @param lat 此刻车辆所在的纬度
	 * @return 此刻车辆的网格ID
	 */
	public static String getNetGridID(double lon, double lat) {
		DecimalFormat df = new DecimalFormat("###.00");
		// 如果不加这个Format的话是有0.125 --0.12 0.135-0.14 向偶数靠拢
		df.setRoundingMode(RoundingMode.HALF_UP);
		lon = Double.valueOf(df.format(lon));
		lat = Double.valueOf(df.format(lat));
		int id = 0;
		if (lon < 73.00 || lon > 138.00 || lat < 18.00 || lat > 55.00)
			return id + "";
		else {
			int longitude = (int) (lon * 100);
			int latitude = (int) (lat * 100);
			id = (latitude - 1800) * 6300 + ((longitude - 7300));
			return id + "";
		}
	}
}

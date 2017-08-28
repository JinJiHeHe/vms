package com.et.terminalserver.common.util;


/**
 * @Project: CNPC_VMS
 * @Title: 经纬度纠偏工具
 * @Description: 经纬度纠偏工具
 * @author: guanhl
 * @date: 2014年4月23日 上午9:43:09
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class LngLatUtil {

	static double pi = 3.14159265358979324;  //定义静态变量 pi
	static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;  //定义另一个规格的pi

	/**
	 * @Description:GCJ-02 坐标转换成 BD-09
	 * @param : 纬度 ，精度 ，精度纬度转换后对象
	 * @return  转换后的精度纬度对象
	 */
	static LonLat bd_encrypt(double gg_lat, double gg_lon, LonLat coord) {
		double x = gg_lon, y = gg_lat;   //绑定坐标点
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);  
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);  
		coord.setLongitude(z * Math.cos(theta) + 0.0065);
		coord.setLatitude(z * Math.sin(theta) + 0.006);
		return coord;  //返回转换后值
	}

	/**
	 * @Description:BD-09 坐标转换成 GCJ-02
	 * @param : 纬度，精度，转换后经度纬度
	 * @return  转换后经度纬度
	 */
	static LonLat bd_decrypt(double bd_lat, double bd_lon, LonLat coord) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;  //绑定经度纬度
		//按规则计算。
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi); 
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		coord.setLongitude(z * Math.cos(theta));
		coord.setLatitude(z * Math.sin(theta));
		return coord;  //返回转换后经度纬度
	}

	//
	// Krasovsky 1940
	//
	// a = 6378245.0, 1/f = 298.3
	// b = a * (1 - f)
	// ee = (a^2 - b^2) / a^2;
	static double a = 6378245.0;   
	static double ee = 0.00669342162296594323;

	// GPS转火星坐标
	// World Geodetic System ==> Mars Geodetic System
	/**
	 * @Description:WGS-84 转 GCJ-02
	 * @param : 纬度 ，经度 ，转换后经度纬度
	 * @return   转换后经度纬度
	 */
	public static LonLat transform(double wgLat, double wgLon, LonLat coord) {
		if (outOfChina(wgLat, wgLon)) {  //判断经度纬度是否在中国范围内
			coord.setLatitude(wgLat);  //设置纬度
			coord.setLongitude(wgLon); //设置经度
			return coord; //返回坐标位置
		}
		double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);  //按规则计算
		double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);  //按规则计算
		double radLat = wgLat / 180.0 * pi;  //计算弧度
		double magic = Math.sin(radLat); //计算弧度的正弦
		magic = 1 - ee * magic * magic; //按规则计算
		double sqrtMagic = Math.sqrt(magic);  //对其开平方
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);  //转换纬度
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi); //转换经度
		coord.setLatitude(wgLat + dLat);  //设置转换后纬度
		coord.setLongitude(wgLon + dLon); //设置转换后经度

		return coord; //返回经度纬度
	}

	/**
	 * @Description 判断是否在中国
	 * @param lat lon
	 * @return boolean
	 * @throws Exception
	 */
	static boolean outOfChina(double lat, double lon) {  //判断是否在中国
		if (lon < 72.004 || lon > 137.8347)  //和指定经纬度比较
			return true;
		if (lat < 0.8293 || lat > 55.8271)//和指定经纬度比较
			return true;
		return false;
	}

	/**
	 * @Description 转换纬度
	 */
	static double transformLat(double x, double y) {  
		//按转换规则计算
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	/**
	 * @Description 转换经度
	 */
	static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}

	/**
	 * @Description 地址转换
	 */
	public static void Wgs84ToBd09(double wgLat, double wgLon, LonLat coord) {
		transform(wgLat, wgLon, coord);
		bd_encrypt(coord.getLatitude(), coord.getLongitude(), coord);
	}


}

package com.et.web.baiduMap;

public class GpsGoBaiDuUtil {
	// WGS-84 坐标系 转 GCJ-02
	private final static double pi = 3.14159265358979324;
	private final static double a = 6378245.0;
	private final static double ee = 0.00669342162296594323;
	// GCJ-02坐标系 转 BD-09
	private static final double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	/**
	 * @param lat:纬度
	 *            lon:经度 gps纬度转百度地图
	 * @return 0:纬度 1:经度
	 */
	public static double[] getBaiDu(double lat, double lon) {
		double latlng[] = new double[2];
		double [] result = new double[2];
		if (lat > 0 && lon> 0) {// 有经纬度上报
			double longitude_m = lon;//
			double latitudeM = lat;//
			double[] transform = transform(latitudeM, longitude_m, latlng);
			if (transform != null) {
				result[0] = bd_encrypt(transform[0], transform[1])[0];
				result[1] = bd_encrypt(transform[0], transform[1])[1];
				return result;
			}
		}
		result[0] =0;
		result[1] =0;
		return result;
	}

	private static double[] transform(double wgLat, double wgLon, double[] latlng) {
		if (outOfChina(wgLat, wgLon)) {
			latlng[0] = wgLat;
			latlng[1] = wgLon;
			return null;
		}
		double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
		double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
		double radLat = wgLat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		latlng[0] = wgLat + dLat;
		latlng[1] = wgLon + dLon;
		return latlng;
	}

	private static boolean outOfChina(double lat, double lon) {
		if (lon < 72.004 || lon > 137.8347)
			return true;
		if (lat < 0.8293 || lat > 55.8271)
			return true;
		return false;
	}

	private static double transformLat(double x, double y) {
		double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
		return ret;
	}

	private static double transformLon(double x, double y) {
		double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
		ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
		return ret;
	}

	private static double[] bd_encrypt(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		double[] tmp = new double[2];
		tmp[0] = bd_lat;
		tmp[1] = bd_lon;
		return tmp;
	}
}

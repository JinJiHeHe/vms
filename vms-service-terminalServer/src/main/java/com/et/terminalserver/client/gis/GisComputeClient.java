package com.et.terminalserver.client.gis;


import com.et.terminalserver.api.GisCompute;

public class GisComputeClient implements GisCompute {

	@Override
	public boolean isPointInAreas(double lat, double lon, String layerName) {
		return false;
	}

	@Override
	public boolean isPointInOneArea(double lat, double lon, String layerName,
			String geoId) {
		return false;
	}

	@Override
	public boolean isPointInOneLine(double lat, double lon, String layerName,
			String geoId) {
		return false;
	}

	@Override
	public String getLocaltionName(double lat, double lon) {
		return "中国";
	}

}

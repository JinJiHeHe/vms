package com.et.terminalserver.protocols.business.bo;

import java.util.List;

public class TDPolygonArea extends BusinessObject{

	private int id;
	private int pointsNumber;
	private int type;
	List<double[]> points;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPointsNumber() {
		return pointsNumber;
	}

	public void setPointsNumber(int pointsNumber) {
		this.pointsNumber = pointsNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<double[]> getPoints() {
		return points;
	}

	public void setPoints(List<double[]> points) {
		this.points = points;
	}

	@Override
	public int getBusinessCode() {
		return PD_POLYGON_AREA;
	}

}

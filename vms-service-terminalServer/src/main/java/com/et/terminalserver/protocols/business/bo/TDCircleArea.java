package com.et.terminalserver.protocols.business.bo;

public class TDCircleArea extends BusinessObject {

	private double centerX;
	
	private double centerY;
	
	private double radius;
	
	private int id;
	
	private int type;

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int getBusinessCode() {
		return PD_CIRCLE_AREA;
	}
	
	
}

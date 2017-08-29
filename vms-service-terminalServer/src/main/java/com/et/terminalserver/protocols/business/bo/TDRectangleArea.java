package com.et.terminalserver.protocols.business.bo;

public class TDRectangleArea extends BusinessObject {

	
	private int id;
	private double topLeftX;
	private double topLeftY;
	private double buttomRightX;
	private double buttomRightY;
	private int type;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(double topLeftX) {
		this.topLeftX = topLeftX;
	}

	public double getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
	}

	public double getButtomRightX() {
		return buttomRightX;
	}

	public void setButtomRightX(double buttomRightX) {
		this.buttomRightX = buttomRightX;
	}

	public double getButtomRightY() {
		return buttomRightY;
	}

	public void setButtomRightY(double buttomRightY) {
		this.buttomRightY = buttomRightY;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int getBusinessCode() {
		return PD_RECTANGLE_AREA;
	}

}

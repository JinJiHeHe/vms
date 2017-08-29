package com.et.terminalserver.api.model.ext;

/**
 * @Description 用于数据转发服务809向终端发送指令 有一些自己的属性需要拓展 例如没有车辆ID 在此对象里添加车牌号 颜色。
 * @author jakiro
 * @version V1.0
 * @Date 2016年8月4日 上午11:27:13
 * @mail terrorbladeyang@gmail.com
 */
public class DCommandInfo809 extends DCommandInfo{

	private static final long serialVersionUID = 8022495917266001213L;

	public DCommandInfo809() {
		
	}
	
	//车牌号
	private String vehicleNo;
	
	//车辆颜色
	private String vehicleColor;
	
	//要转发的平台ID列表 
    private String[] plateCodes;

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}


	public String[] getPlateCodes() {
		return plateCodes;
	}

	public void setPlateCodes(String[] plateCodes) {
		this.plateCodes = plateCodes;
	}
	
	
	
}

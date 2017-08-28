package com.et.terminalserver.api.model.ext;

/**
 * @Description 反馈给809转发服务的指令响应对象
 * @author jakiro
 * @version V1.0
 * @Date 2016年8月5日 下午6:07:44
 * @mail terrorbladeyang@gmail.com
 */
public class DTerminalCommandResponse809 extends DTerminalCommandResponse{

	
	private static final long serialVersionUID = 3221901892949745353L;

	//车牌号
	String vehicleNo;
	
	//颜色
	String vehicleColor;
	
	//转发平台列表
	String[] plateForms;

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

	public String[] getPlateForms() {
		return plateForms;
	}

	public void setPlateForms(String[] plateForms) {
		this.plateForms = plateForms;
	}
	
	
	
}

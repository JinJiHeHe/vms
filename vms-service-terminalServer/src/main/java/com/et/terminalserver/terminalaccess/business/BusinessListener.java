package com.et.terminalserver.terminalaccess.business;

import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.protocols.business.bo.*;
import com.et.terminalserver.terminalaccess.netty.Packet;

/**
 * 业务通道的监听类 来此进行业务处理
 * */
public class BusinessListener implements BusListener {

	// 业务处理接口
	Business business;
//	// 数据转发业务接口
//	DataforwardBusiness business_forward;

	/**
	 * 通道监听接口
	 * */
	@Override
	public void commandReceived(Command command, String connectName) {
		// 业务标识
		int code = ((Packet) command.getParam()).getBusinessObj().getBusinessCode();

		switch (code) {
		// 获取gps
		case BusinessObject.TU_RECEIVE_GPS:
			Packet packet_gps = (Packet) command.getParam();
			TUGpsInfo info = (TUGpsInfo) packet_gps.getBusinessObj();
			business.receiveGpsInfo(info, packet_gps);
//			if (info.getAcceptState() == BusinessObject.S_ACCEPT) {
//				// 这个位置判断一下 如果这个车被平台勾选为转发车辆 就处理 否则不处理
//				business_forward.processGPSInfo(info, packet_gps.getTerminalKey());
//				// 判断一下是否向809传输报警
//			//	business_forward.processGPSALARM(info, packet_gps.getTerminalKey());
//			} else {
//				// 809GPS补发
//				business_forward.processReissuedGPSInfo(info, packet_gps.getTerminalKey());
//			}
			break;
		// 下线
		case BusinessObject.OP_OFFLINE:
			Packet packet_offLine = (Packet) command.getParam();
			business.terminalOffLine(((OPOffLine) packet_offLine.getBusinessObj()));
			break;
		// 注册
		case BusinessObject.TU_REGISTER:
			Packet packet_register = (Packet) command.getParam();
			TURegister register = (TURegister) packet_register.getBusinessObj();
			// 终端接入的处理
			business.registerTerminal(register, packet_register);
			// 经过上一个终端注册之后 packet里边的静态信息 得到了补充 809 车辆注册--0x1201
//			business_forward.processUpMsgRegister(register, packet_register.getTerminalKey());
			break;
		// 鉴权2
		case BusinessObject.TU_CHECK:
			Packet packet_check = (Packet) command.getParam();
			TUCheck check = (TUCheck) packet_check.getBusinessObj();
			business.checkTerminal(check, packet_check);
			break;
		// 心跳
		case BusinessObject.TU_HEART:
			Packet packet_heart = (Packet) command.getParam();
			TUHeart heart = (TUHeart) packet_heart.getBusinessObj();
			business.receiveHeart(heart, packet_heart);
			break;
		// 透传
		case BusinessObject.TU_PASSTHROUGH:
			Packet packet_passthrough = (Packet) command.getParam();
			TUPassThrough passThrough = (TUPassThrough) packet_passthrough.getBusinessObj();
			business.passThrough(passThrough, packet_passthrough);
			break;
		// 电子运单
		case BusinessObject.TD_ORDER:
			Packet packet_order = (Packet) command.getParam();
			TUOrder order = (TUOrder) packet_order.getBusinessObj();
			order.setVehicleID(packet_order.getChannelWapper().getRelationInfo().getVehicleInfo().getVechileId());
//			business_forward.processOrder(order, packet_order.getTerminalKey());
			break;
		// 驾驶员
		case BusinessObject.TD_DRIVERINFO:
			Packet packet_driver = (Packet) command.getParam();
			TUDriverInfo driver = (TUDriverInfo) packet_driver.getBusinessObj();
			driver.setVechile(packet_driver.getChannelWapper().getRelationInfo().getVehicleInfo().getVechileId());
//			business_forward.processDriver(driver, packet_driver.getTerminalKey());
			break;
		default:
			break;
		}
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

//	public DataforwardBusiness getBusiness_forward() {
//		return business_forward;
//	}
//
//	public void setBusiness_forward(DataforwardBusiness business_forward) {
//		this.business_forward = business_forward;
//	}

}

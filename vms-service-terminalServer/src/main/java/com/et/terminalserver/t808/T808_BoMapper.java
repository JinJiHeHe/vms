package com.et.terminalserver.t808;

import com.et.terminalserver.protocols.business.bo.*;
import com.et.terminalserver.protocols.protocols.BoMapper;
import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.util.SequenceUtil;
import com.et.terminalserver.t808.messagebody.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Description 808映射类 能通过请求映射Message对象
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:11:21
 * @mail terrorbladeyang@gmail.com
 */
public class T808_BoMapper implements BoMapper {

	private static final String T808_RESPONSE_SEQ = "T808_RESPONSE_SEQ";

	private static final Log log = LogFactory.getLog(T808_BoMapper.class);

	/**
	 * 初始化时创建初始流水号
	 * */
	public T808_BoMapper() {
		SequenceUtil.createSequence(T808_RESPONSE_SEQ);
	}

	/**
	 * 映射方法 返回一个BusinessObject业务对象 在拆包解码的时候被调用
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public BusinessObject mapper(
			Message<? extends MessageHeader, ? extends MessageBody> message) {
		int id = (Integer) message.getMessageHeader().getMessageID();
		switch (id) {
		case 0x0001://通用应答
			TUResponse response = new TUResponse();
			Message<T808_MessageHeader, T808_0x0001> m0001 = (Message<T808_MessageHeader, T808_0x0001>) message;
			response.setCmdID(m0001.getMessageBody().getResponseID());
			response.setContent("");
			response.setResult(m0001.getMessageBody().getResult());
			response.setSeqID(m0001.getMessageBody().getResponseSeq());
			response.setResponseCode(BusinessObject.PR_NO_RESPONSE);
			response.setTerminalKey(m0001.getMessageHeader().getSimNum());
			return response;
		case 0x0200:// 上传的定位信息
			TUGpsInfo info = new TUGpsInfo();
			Message<T808_MessageHeader, T808_0x0200> m0200 = (Message<T808_MessageHeader, T808_0x0200>) message;
			info.setAlarmTag(m0200.getMessageBody().getAlarmSign());
			info.setAlt(m0200.getMessageBody().getAltitude());
			info.setDirection(m0200.getMessageBody().getDirection());
			info.setDriveSpeed(m0200.getMessageBody().getSpeed());
			info.setElevation(0);
			info.setFuel(m0200.getMessageBody().getOil());
			info.setLat(m0200.getMessageBody().getLatitude());
			info.setLon(m0200.getMessageBody().getLongitude());
			info.setMileage(m0200.getMessageBody().getMileage());
			info.setGTime(m0200.getMessageBody().getTime());
			info.setSim(m0200.getMessageHeader().getSimNum());
			info.setTerminalKey(m0200.getMessageHeader().getSimNum());
			info.setSpeed(m0200.getMessageBody().getSpeed());
			info.setState(m0200.getMessageBody().getStatus());
			// 8001 通用应答
			info.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			return info;
		case 0x0704:// 补发的gps数据
			TUGpsInfo oldinfo = new TUGpsInfo();
			Message<T808_MessageHeader, T808_0x0704> m0704 = (Message<T808_MessageHeader, T808_0x0704>) message;
			oldinfo.setAlarmTag(m0704.getMessageBody().getAlarmSign());
			oldinfo.setAlt(m0704.getMessageBody().getAltitude());
			oldinfo.setDirection(m0704.getMessageBody().getDirection());
			oldinfo.setDriveSpeed(m0704.getMessageBody().getSpeed());
			oldinfo.setElevation(0);
			oldinfo.setFuel(m0704.getMessageBody().getOil());
			oldinfo.setLat(m0704.getMessageBody().getLatitude());
			oldinfo.setLon(m0704.getMessageBody().getLongitude());
			oldinfo.setMileage(m0704.getMessageBody().getMileage());
			oldinfo.setGTime(m0704.getMessageBody().getTime());
			oldinfo.setSim(m0704.getMessageHeader().getSimNum());
			oldinfo.setTerminalKey(m0704.getMessageHeader().getSimNum());
			oldinfo.setSpeed(m0704.getMessageBody().getSpeed());
			oldinfo.setState(m0704.getMessageBody().getStatus());
			// 8001 通用应答
			oldinfo.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			return oldinfo;
		case 0x0201:// 位置定位回馈
			TUPositionResponse info_position = new TUPositionResponse();
			Message<T808_MessageHeader, T808_0x0201> m0201 = (Message<T808_MessageHeader, T808_0x0201>) message;
			info_position.setAlarmSign(m0201.getMessageBody().getAlarmSign());
			info_position.setAltitude(m0201.getMessageBody().getAltitude());
			info_position.setDirection(m0201.getMessageBody().getDirection());
			info_position.setLatitude(m0201.getMessageBody().getLatitude());
			info_position.setLongitude(m0201.getMessageBody().getLongitude());
			info_position.setPlatformSerialNumber(m0201.getMessageBody()
					.getPlatformSerialNumber());
			info_position.setSpeed(m0201.getMessageBody().getSpeed());
			info_position.setStatus(m0201.getMessageBody().getStatus());
			info_position.setTerminalKey(m0201.getMessageHeader().getSimNum());
			info_position.setTime(m0201.getMessageBody().getTime());
			// 位置请求(点名)的反馈
			info_position.setResponseCode(BusinessObject.PR_NO_RESPONSE);
			return info_position;
		case 0x0100:// 注册
			TURegister register = new TURegister();
			Message<T808_MessageHeader, T808_0x0100> m0100 = (Message<T808_MessageHeader, T808_0x0100>) message;
			register.setTerminalKey(m0100.getMessageHeader().getSimNum());
			register.setCityID(m0100.getMessageBody().getCityID());
			register.setColor(m0100.getMessageBody().getColor());
			register.setProviderID(m0100.getMessageBody().getProviderID());
			register.setProvinceID(m0100.getMessageBody().getProvinceID());
			register.setTerminalVersion(m0100.getMessageBody().getTerminalVersion());
			register.setTerminalID(m0100.getMessageBody().getTerminalID());
			// 8100 注册应答
			register.setResponseCode(BusinessObject.PR_REGISTER_RESPONSE);
			return register;
		case 0x0102: // 鉴权
			TUCheck check = new TUCheck();
			Message<T808_MessageHeader, T808_0x0102> m0102 = (Message<T808_MessageHeader, T808_0x0102>) message;
			// 8001 通用应答
			check.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			check.setTerminalKey(m0102.getMessageHeader().getSimNum());
			check.setAuthCode(m0102.getMessageBody().getCode());
			return check;
		case 0x0104: //查询终端参数响应
			TUQueryTerminalParamResponse paramResonse=new TUQueryTerminalParamResponse();
			//转换成对象
			Message<T808_MessageHeader, T808_0x0104> m0104=(Message<T808_MessageHeader, T808_0x0104>)message;
			//得到消息体
			T808_0x0104 body0104=m0104.getMessageBody();
			//内部参数对象
			TerminalParameterInfo terminalParameter=body0104.getParaList();
			//应答流水号
			paramResonse.setReplaySerialNumber(body0104.getReplaySerialNumber());
			//包参数个数
			paramResonse.setPackageParamsNumber(body0104.getPackageParamsNumber());
			//终端心跳发送间隔
			paramResonse.setHeartBeatTime(terminalParameter.getHeartBeatTime());
			//TCP消息应答超时时间
			paramResonse.setTcpResponseTime(terminalParameter.getTcpResponseTime());
			// TCP重连次数
			paramResonse.setTcpReCon(terminalParameter.getTcpReCon());
			// UDP消息应答超时时间
			paramResonse.setUdpResponseTime(terminalParameter.getUdpResponseTime());
			// UDP重连次数
			paramResonse.setUdpReCon(terminalParameter.getUdpReCon());
			// SMS消息应答超时时间
			paramResonse.setSmsResponseTime(terminalParameter.getSmsResponseTime());
			// SMS重传次数
			paramResonse.setSmsReCon(terminalParameter.getSmsReCon());
			// 主服务器APN,无线通信拨号访问点
			paramResonse.setMainApn(terminalParameter.getMainApn());
			// 主服务器无线通信拨号用户名
			paramResonse.setMainwirelessUser(terminalParameter.getMainwirelessUser());
			// 主服务器无线通信拨号密码
			paramResonse.setMainwirelesspassword(terminalParameter.getMainwirelesspassword());
			// 主服务器地址，IP或域名
			paramResonse.setMainIP(terminalParameter.getMainIP());
			// 备用服务器APN,无线通信拨号访问点
			paramResonse.setBackupApn(terminalParameter.getBackupApn());
			// 备用服务器无线通信拨号用户名
			paramResonse.setBackupwirelessUser(terminalParameter.getBackupwirelessUser());
			// 备用服务器无线通信拨号密码
			paramResonse.setBackupwirelesspassword(terminalParameter.getBackupwirelesspassword());
			// 备用服务器地址，IP或域名
			paramResonse.setBackupIP(terminalParameter.getBackupIP());
			// TCP端口
			paramResonse.setTcpport(terminalParameter.getTcpport());
			// UDP端口
			paramResonse.setUdpport(terminalParameter.getUdpport());
			// 位置汇报策略，0定时汇报，1定距汇报，2定时定距汇报
			paramResonse.setPositionReturnPolicy(paramResonse.getPositionReturnPolicy());
			// 位置汇报方案，0根据ACC状态，1根据登录和ACC状态
			paramResonse.setPositionReMethod(terminalParameter.getPositionReMethod());
			// 驾驶员未登录回报时间间隔
			paramResonse.setDriverNotLogtime(terminalParameter.getDriverNotLogtime());
			// 休眠时汇报时间间隔
			paramResonse.setSleepTime(terminalParameter.getSleepTime());
			// 紧急报警时汇报时间间隔
			paramResonse.setEmergencytime(terminalParameter.getEmergencytime());
			// 缺省时间汇报间隔
			paramResonse.setDefaulttime(terminalParameter.getDefaulttime());
		    // 缺省距离汇报间隔
			paramResonse.setDefaultdistance(terminalParameter.getDefaultdistance());
			// 驾驶员未登录汇报距离间隔
			paramResonse.setDriverNotLogdistance(terminalParameter.getDriverNotLogdistance());
			// 休眠时汇报距离间隔
			paramResonse.setSleepDistance(terminalParameter.getSleepDistance());
			// 紧急报警时汇报距离间隔
			paramResonse.setEmergencyDistance(terminalParameter.getEmergencyDistance());
			// 拐点补传角度
			paramResonse.setInflectionPoint(terminalParameter.getInflectionPoint());
			// 监控平台电话号码
			paramResonse.setPlatphoneNum(terminalParameter.getPlatphoneNum());
			// 复位电话号码
			paramResonse.setResetPhoneNum(terminalParameter.getResetPhoneNum());
			// 恢复出厂设置电话号码
			paramResonse.setRestorefactoryPhoneNum(terminalParameter.getRestorefactoryPhoneNum());
			// 监控平台SMS号码
			paramResonse.setPlatSMSnum(terminalParameter.getPlatSMSnum());
			// 接收终端SMS文本报警号码
			paramResonse.setRecieveTerminalSMSnum(terminalParameter.getRecieveTerminalSMSnum());
			// 终端电话接听策略 0自动接听，1ACC ON自动接听，OFF手动接听
			paramResonse.setTerminalphonePolicy(terminalParameter.getTerminalphonePolicy());
			// 每次最长通话时间
			paramResonse.setPerMaxphonetime(terminalParameter.getPerMaxphonetime());
			// 当月最长通话时间
			paramResonse.setPerMonthMaxphonetime(terminalParameter.getPerMonthMaxphonetime());
			// 监听电话号码
			paramResonse.setMonitorPhoneNum(terminalParameter.getMonitorPhoneNum());
			// 监管平台特权短信号码
			paramResonse.setMonitorplatMessageNum(terminalParameter.getMonitorplatMessageNum());
			// 报警屏蔽子
			paramResonse.setAlarmshield(terminalParameter.getAlarmshield());
		    // 报警发送文本SMS开关
			paramResonse.setAlarmSMS(terminalParameter.getAlarmSMS());
			// 报警拍摄开关
			paramResonse.setAlarmPhoto(terminalParameter.getAlarmPhoto());
			// 报警拍摄存储标志
			paramResonse.setAlarmphotoSave(terminalParameter.getAlarmphotoSave());
			// 关键标志
			paramResonse.setImportantFlag(terminalParameter.getImportantFlag());
			// 最高速度
			paramResonse.setMaxSpeed(terminalParameter.getMaxSpeed());
			// 超速持续时间
			paramResonse.setOverspeedTime(terminalParameter.getOverspeedTime());
			// 连续驾驶时间门限
			paramResonse.setMaxoverDriveTime(terminalParameter.getMaxoverDriveTime());
			// 当天累计驾驶时间门限
			paramResonse.setMaxoverDrivePerday(terminalParameter.getMaxoverDrivePerday());
			// 最小休息时间
			paramResonse.setMinResttime(terminalParameter.getMinResttime());
			// 最长停车时间
			paramResonse.setMaxParktime(terminalParameter.getMaxParktime());
			// 图像视频质量
			paramResonse.setImageQuality(terminalParameter.getImageQuality());
			// 亮度0-255
			paramResonse.setBrightness(terminalParameter.getBrightness());
			// 对比度0-127
			paramResonse.setContrast(terminalParameter.getContrast());
			// 饱和度0-127
			paramResonse.setSaturation(terminalParameter.getSaturation());
			// 色度0-255
			paramResonse.setColor(terminalParameter.getColor());
			// 车辆里程表读数
			paramResonse.setOdometerReading(terminalParameter.getOdometerReading());
			// 省域ID
			paramResonse.setProvinceId(terminalParameter.getProvinceId());
			// 市域ID
			paramResonse.setCityId(terminalParameter.getCityId());
			// 车牌号
			paramResonse.setCarNum(terminalParameter.getCarNum());
			// 车牌颜色
			paramResonse.setCarColor(terminalParameter.getCarColor());
			// 电子围栏半径
			paramResonse.setElectricFenceRadius(terminalParameter.getElectricFenceRadius());
			//这个消息是不需要响应的
			paramResonse.setResponseCode(BusinessObject.PR_NO_RESPONSE);
			return paramResonse;
			
		case 0x0002:// 心跳
			TUHeart heart = new TUHeart();
			Message<T808_MessageHeader, T808_0x0002> m0002 = (Message<T808_MessageHeader, T808_0x0002>) message;
			// 8001通用应答
			heart.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			heart.setTerminalKey(m0002.getMessageHeader().getSimNum());
			return heart;
		case 0x0700: // 行驶记录上传
			TUTravelDataUp travelData = new TUTravelDataUp();
			Message<T808_MessageHeader, T808_0x0700> m0700 = (Message<T808_MessageHeader, T808_0x0700>) message;
			travelData.setResponseCode(BusinessObject.PR_NO_RESPONSE);
			travelData.setTerminalKey(m0700.getMessageHeader().getSimNum());
			T808_MessageHeader header0700 = (T808_MessageHeader) m0700
					.getMessageHeader();
			T808_0x0700 body0700 = m0700.getMessageBody();
			// 是否要分包
			travelData.setSplit_flag(header0700.getSubpackage());
			travelData.setSerialNumber(body0700.getSerialNumber());
			travelData.setCmdID(body0700.getCmdID());
			travelData.setOrginalData(body0700.getOrginalData());
			travelData.setdBlockLength(body0700.getdBlockLength());
			travelData.setpDataLength(body0700.getpDataLength());
			travelData.setPackageCounts(header0700.getPackageCounts());
			travelData.setPackageNum(header0700.getPackageNum());
			travelData.setContent(body0700.getContent());
			return travelData;
		
		case 0x0702: //驾驶员信息上报
			
			TUDriverInfo driverInfo=new TUDriverInfo();
			Message<T808_MessageHeader, T808_0x0702> m0702 = (Message<T808_MessageHeader, T808_0x0702>) message;
			driverInfo.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			driverInfo.setTerminalKey(m0702.getMessageHeader().getSimNum());
//			T808_MessageHeader header0702 = (T808_MessageHeader) m0702
//					.getMessageHeader();
			T808_0x0702 body0702 = m0702.getMessageBody();
			driverInfo.setICardTime(body0702.getICardTime());
			driverInfo.setDriverNameLength(body0702.getDriverNameLength());
			driverInfo.setDriverName(body0702.getDriverName());
			driverInfo.setDriverIdCode(body0702.getDriverIdCode());
			driverInfo.setQualificationCode(body0702.getQualificationCode());
			driverInfo.setCertificationOrgLength(body0702.getCertificationOrgLength());
			driverInfo.setCertificationOrg(body0702.getCertificationOrg());
			driverInfo.setTime(body0702.getTime());
			driverInfo.setValidDate(body0702.getValidDate());
			return driverInfo;
			
		case 0x0800:// 多媒体事件上传
			TUMediaEvent mediaEvent = new TUMediaEvent();
			Message<T808_MessageHeader, T808_0x0800> m0800 = (Message<T808_MessageHeader, T808_0x0800>) message;
			mediaEvent.setMediaId(m0800.getMessageBody().getMutiMideoID());
			mediaEvent.setTerminalKey(m0800.getMessageHeader().getSimNum());
			mediaEvent.setEventCode(m0800.getMessageBody().getEvent());
			mediaEvent.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			int type0800 = m0800.getMessageBody().getFormat();
			String name0800 = "jpeg";

			switch (type0800) {
			case 0:
				name0800 = "jpeg";
				break;
			case 1:
				name0800 = "tif";
				break;
			case 2:
				name0800 = "mp3";
				break;
			case 3:
				name0800 = "wav";
				break;
			case 4:
				name0800 = "wmv";
				break;
			default:
				name0800 = "dat";
				break;
			}
			mediaEvent.setType(name0800);
			return mediaEvent;
		case 0x0801:// 多媒体上传
			TUMedia media = new TUMedia();
			Message<T808_MessageHeader, T808_0x0801> m0801 = (Message<T808_MessageHeader, T808_0x0801>) message;
			media.setMediaId(m0801.getMessageBody().getMultiMediaID());
			media.setSum(m0801.getMessageHeader().getPackageCounts());
			media.setNum(m0801.getMessageHeader().getPackageNum());
			media.setTerminalKey(m0801.getMessageHeader().getSimNum());
			int type0801 = m0801.getMessageBody().getFormat();
			String name0801 = "jpeg";

			switch (type0801) {
			case 0:
				name0801 = "jpeg";
				break;
			case 1:
				name0801 = "tif";
				break;
			case 2:
				name0801 = "mp3";
				break;
			case 3:
				name0801 = "wav";
				break;
			case 4:
				name0801 = "wmv";
				break;
			default:
				name0801 = "dat";
				break;
			}
			media.setType(name0801);
			media.setResponseCode(BusinessObject.PR_MUTI_MEDIA_RESPONSE);
			media.setData(m0801.getMessageBody().getMultimediaData());
			return media;
		case 0x0900://透传数据
			TUPassThrough passThrough = new TUPassThrough();
			Message<T808_MessageHeader, T808_0x0900> m0900 = (Message<T808_MessageHeader, T808_0x0900>) message;
			passThrough.setType(m0900.getMessageBody().getType());
			passThrough.setData(m0900.getMessageBody().getContent());
			passThrough.setTerminalKey(m0900.getMessageHeader().getSimNum());
			passThrough.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			return passThrough;
		case 0x0701://电子运单
			TUOrder order = new TUOrder();
			Message<T808_MessageHeader, T808_0x0701> m0701 = (Message<T808_MessageHeader, T808_0x0701>) message;
			order.setContent(m0701.getMessageBody().getContent());
			order.setTerminalKey(m0701.getMessageHeader().getSimNum());
			order.setResponseCode(BusinessObject.PR_PLANT_RESPONSE);
			return order ;
		default:
			break;
		}
		return null;
	}

	/**
	 * 通过业务对象 打包成消息Message<MessageHeader, MessageBody>
	 * */
	@SuppressWarnings("unchecked")
	@Override
	public Message<MessageHeader, MessageBody> mapper(BusinessObject bo,
			int opts) {
		Message<?, ?> message = null;
		switch (bo.getResponseCode()) {
		case BusinessObject.PR_PLANT_RESPONSE:// 平台通用应答
			T808_MessageHeader header8001 = new T808_MessageHeader();
			// header8001.setRunningNum((short) SequenceUtil
			// .getSequenceValue(T808_RESPONSE_SEQ));
			header8001.setTerminalKey(bo.getTerminalKey());
			header8001.setMessageID(0x8001);
			T808_0x8001 body8001 = new T808_0x8001();
			body8001.setResponseID(bo.getBusinessCode());
			body8001.setRunningNum(opts);
			if (bo.getAcceptState() == BusinessObject.S_ACCEPT)
				body8001.setResult(0);
			else
				body8001.setResponseID(1);
			message = new T808_Message<T808_MessageHeader, T808_0x8001>(
					header8001, body8001);
			break;
		case BusinessObject.PR_REGISTER_RESPONSE:// 注册应答
			T808_MessageHeader header8100 = new T808_MessageHeader();
			header8100.setRunningNum((short) SequenceUtil
					.getSequenceValue(T808_RESPONSE_SEQ));
			header8100.setTerminalKey(bo.getTerminalKey());
			header8100.setMessageID(0x8100);
			TURegister register = (TURegister) bo;
			T808_0x8100 body8100 = new T808_0x8100();
			body8100.setAuthCode(register.getAuthCode());
			body8100.setRunningNum(opts);
			if (bo.getAcceptState() == BusinessObject.S_ACCEPT)
				body8100.setResult(0);
			else
				body8100.setResult(4);
			message = new T808_Message<T808_MessageHeader, T808_0x8100>(
					header8100, body8100);
			break;
		case BusinessObject.PR_MUTI_MEDIA_RESPONSE:
			TDMediaResponse mediaResponse = (TDMediaResponse) bo;
			T808_MessageHeader header8800 = new T808_MessageHeader();
			header8800.setRunningNum((short) SequenceUtil
					.getSequenceValue(T808_RESPONSE_SEQ));
			header8800.setTerminalKey(bo.getTerminalKey());
			header8800.setMessageID(0x8800);
			T808_0x8800 body8800 = new T808_0x8800();
			body8800.setMultimediaID(mediaResponse.getMediaId());
			body8800.setRepackageCount(mediaResponse.getNeedPackets().size());
			Set<Integer> set = new TreeSet<Integer>();
			for (String value : mediaResponse.getNeedPackets()) {
				set.add(Integer.parseInt(value));
			}
			body8800.setRepackageIDItem(set);
			message = new T808_Message<T808_MessageHeader, T808_0x8800>(
					header8800, body8800);
			break;
		case BusinessObject.PD_TEXT:// 文本下发
			T808_MessageHeader header8300 = new T808_MessageHeader();
			header8300.setRunningNum(opts);
			header8300.setMessageID(0x8300);
			header8300.setTerminalKey(bo.getTerminalKey());
			TDText tdText = (TDText) bo;
			T808_0x8300 body8300 = new T808_0x8300();
			body8300.setMark(tdText.getMark());
			body8300.setTextMessage(tdText.getTextMessage());
			message = new T808_Message<T808_MessageHeader, T808_0x8300>(
					header8300, body8300);
			break;
		case BusinessObject.PD_CALLBACK:// 电话回拨
			T808_MessageHeader header8400 = new T808_MessageHeader();
			header8400.setRunningNum(opts);
			header8400.setMessageID(0x8400);
			header8400.setTerminalKey(bo.getTerminalKey());
			TDCall tdCall = (TDCall) bo;
			T808_0x8400 body8400 = new T808_0x8400();
			body8400.setSign(tdCall.getSign());
			body8400.setPhoneNumber(tdCall.getPhoneNumber());
			message = new T808_Message<T808_MessageHeader, T808_0x8400>(
					header8400, body8400);
			break;
		case BusinessObject.PD_LOCATIONSTATE:// 点名 | 状态检测 | 车门状态检测开关
			T808_MessageHeader header8201 = new T808_MessageHeader();
			header8201.setRunningNum(opts);
			header8201.setMessageID(0x8201);
			header8201.setTerminalKey(bo.getTerminalKey());
			T808_0x8201 body8201 = new T808_0x8201();
			message = new T808_Message<T808_MessageHeader, T808_0x8201>(
					header8201, body8201);
			break;

		case BusinessObject.PD_TAKEPHOTO:// 拍照
			T808_MessageHeader header8801 = new T808_MessageHeader();
			header8801.setRunningNum(opts);
			header8801.setMessageID(0x8801);
			header8801.setTerminalKey(bo.getTerminalKey());
			T808_0x8801 body8801 = new T808_0x8801();
			TDTakePhoto takePhoto = (TDTakePhoto) bo;
			body8801.setChannelID(takePhoto.getChannelID());
			body8801.setBrightness(takePhoto.getBrightness());
			body8801.setChrmaticity(takePhoto.getChrmaticity());
			body8801.setContrast(takePhoto.getContrast());
			body8801.setImageQuality(takePhoto.getImageQuality());
			body8801.setKeepSign(takePhoto.getKeepSign());
			body8801.setRecordTime(takePhoto.getRecordTime());
			body8801.setResolution(takePhoto.getResolution());
			body8801.setSaturability(takePhoto.getSaturability());
			body8801.setShootCommand(takePhoto.getShootCommand());
			message = new T808_Message<T808_MessageHeader, T808_0x8801>(
					header8801, body8801);
			break;

		case BusinessObject.PD_RETURNBYTIME: // 定时回报
			T808_MessageHeader header0020 = new T808_MessageHeader();
			header0020.setRunningNum(opts);
			header0020.setMessageID(0x8103);
			header0020.setTerminalKey(bo.getTerminalKey());
			T808_0x8103 body0x8103_ReturnByTime = new T808_0x8103();
			TDTerminalParamSet returnByTime = (TDTerminalParamSet) bo;
			body0x8103_ReturnByTime.setPackageCount(2);
			body0x8103_ReturnByTime.setParamCount(2);
			body0x8103_ReturnByTime.setSettings(returnByTime.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0020, body0x8103_ReturnByTime);
			break;
		case BusinessObject.PD_RECORD:
			T808_MessageHeader header8804 = new T808_MessageHeader();
			header8804.setRunningNum(opts);
			header8804.setMessageID(0x8804);
			header8804.setTerminalKey(bo.getTerminalKey());
			TDRecord record = (TDRecord) bo;
			T808_0x8804 body0x8804 = new T808_0x8804();
			body0x8804.setRecordCommand(record.getRecordCommand());
			body0x8804.setRecordTime(record.getRecordTime());
			body0x8804.setSaveSign(record.getSaveFlag());
			body0x8804.setFrequencySamplingRate(record.getCamcorderType());
			message = new T808_Message<T808_MessageHeader, T808_0x8804>(
					header8804, body0x8804);
			break;
		case BusinessObject.PD_SETIPANDPORT: // 设置IP和端口
			T808_MessageHeader header0013 = new T808_MessageHeader();
			header0013.setRunningNum(opts);
			header0013.setMessageID(0x8103);
			header0013.setTerminalKey(bo.getTerminalKey());
			T808_0x8103 body0x8103_setIPAndPort = new T808_0x8103();
			TDSetIPPort setIPAndPort = (TDSetIPPort) bo;
			body0x8103_setIPAndPort.setPackageCount(2);
			body0x8103_setIPAndPort.setParamCount(2);
			Map<String, String[]> setIpAndPortSettings = new TreeMap<String, String[]>();
			int p1 = 0x0013;
			int p2 = 0x0018;
			setIpAndPortSettings.put(String.valueOf(p1),
					new String[] { setIPAndPort.getIp() });
			setIpAndPortSettings.put(String.valueOf(p2),
					new String[] { String.valueOf(setIPAndPort.getPort()) });
			body0x8103_setIPAndPort.setSettings(setIpAndPortSettings);
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0013, body0x8103_setIPAndPort);
			break;
		case BusinessObject.PD_SETIPANDPORT2: // 设置备用IP和端口
			T808_MessageHeader header0014 = new T808_MessageHeader();
			header0014.setRunningNum(opts);
			header0014.setMessageID(0x8103);
			header0014.setTerminalKey(bo.getTerminalKey());
			T808_0x8103 body0x8103_setIPAndPort2 = new T808_0x8103();
			TDSetIPPort2 setIPAndPort2 = (TDSetIPPort2) bo;
			body0x8103_setIPAndPort2.setPackageCount(2);
			body0x8103_setIPAndPort2.setParamCount(2);
			Map<String, String[]> setIpAndPort2Settings = new TreeMap<String, String[]>();
			int p1_2 = 0x0017;
			int p2_2 = 0x0018;
			setIpAndPort2Settings.put(String.valueOf(p1_2),
					new String[] { setIPAndPort2.getIp() });
			setIpAndPort2Settings.put(String.valueOf(p2_2),
					new String[] { String.valueOf(setIPAndPort2.getPort()) });
			body0x8103_setIPAndPort2.setSettings(setIpAndPort2Settings);
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0014, body0x8103_setIPAndPort2);
			break;
		case BusinessObject.PD_TERMINALCONTROL: // 终端复位|恢复出厂设置
			T808_MessageHeader header8105 = new T808_MessageHeader();
			header8105.setRunningNum(opts);
			header8105.setMessageID(0x8105);
			header8105.setTerminalKey(bo.getTerminalKey());
			T808_0x8105 body0x8105_terminalInit = new T808_0x8105();
			TDTerminalControl terminalInit = (TDTerminalControl) bo;
			body0x8105_terminalInit.setCommand(terminalInit.getCommand());
			body0x8105_terminalInit.setList(terminalInit.getList());
			message = new T808_Message<T808_MessageHeader, T808_0x8105>(
					header8105, body0x8105_terminalInit);
			break;

		case BusinessObject.PD_TELEPHONEBOOK: // 电话本
			T808_MessageHeader header8401 = new T808_MessageHeader();
			header8401.setRunningNum(opts);
			header8401.setMessageID(0x8401);
			header8401.setTerminalKey(bo.getTerminalKey());
			TDTelephoneBook telephoneBook = (TDTelephoneBook) bo;
			T808_0x8401 body0x8401_telephoneBook = new T808_0x8401();
			body0x8401_telephoneBook.setSetType(telephoneBook.getSetType());
			body0x8401_telephoneBook.setContactsTotality(telephoneBook
					.getContactsTotality());
			body0x8401_telephoneBook.setContactsList(telephoneBook
					.getContactsList());
			message = new T808_Message<T808_MessageHeader, T808_0x8401>(
					header8401, body0x8401_telephoneBook);
			break;

		case BusinessObject.PD_MAINNUMBERSET: // 设置中心号码
			T808_MessageHeader header0040 = new T808_MessageHeader();
			header0040.setRunningNum(opts);
			header0040.setMessageID(0x8103);
			header0040.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet mainNumberSet = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_mainNumberSet = new T808_0x8103();
			body0x8103_mainNumberSet.setPackageCount(mainNumberSet
					.getPackageCount());
			body0x8103_mainNumberSet.setParamCount(mainNumberSet
					.getParamCount());
			body0x8103_mainNumberSet.setSettings(mainNumberSet.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0040, body0x8103_mainNumberSet);
			break;

		case BusinessObject.PD_HEARTBEATINTERVAL:// 终端心跳间隔
			T808_MessageHeader header0001 = new T808_MessageHeader();
			header0001.setRunningNum(opts);
			header0001.setMessageID(0x8103);
			header0001.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet heartBeatInterval = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_heartBeatInterval = new T808_0x8103();
			body0x8103_heartBeatInterval.setPackageCount(heartBeatInterval
					.getPackageCount());
			body0x8103_heartBeatInterval.setParamCount(heartBeatInterval
					.getParamCount());
			body0x8103_heartBeatInterval.setSettings(heartBeatInterval
					.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0001, body0x8103_heartBeatInterval);
			break;

		case BusinessObject.PD_SETUPBYDISTANCE:// 定距回报
			T808_MessageHeader header0029 = new T808_MessageHeader();
			header0029.setRunningNum(opts);
			header0029.setMessageID(0x8103);
			header0029.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setUpByDistance = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setUpByDistance = new T808_0x8103();
			body0x8103_setUpByDistance.setPackageCount(setUpByDistance
					.getPackageCount());
			body0x8103_setUpByDistance.setParamCount(setUpByDistance
					.getParamCount());
			body0x8103_setUpByDistance.setSettings(setUpByDistance
					.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0029, body0x8103_setUpByDistance);
			break;

		case BusinessObject.PD_SETUPBYDISTANCEANDTIME:// 定时定距回报
			T808_MessageHeader header0030 = new T808_MessageHeader();
			header0030.setRunningNum(opts);
			header0030.setMessageID(0x8103);
			header0030.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setUpByDistanceAndTime = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setUpByDistanceAndTime = new T808_0x8103();
			body0x8103_setUpByDistanceAndTime
					.setPackageCount(setUpByDistanceAndTime.getPackageCount());
			body0x8103_setUpByDistanceAndTime
					.setParamCount(setUpByDistanceAndTime.getParamCount());
			body0x8103_setUpByDistanceAndTime
					.setSettings(setUpByDistanceAndTime.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0030, body0x8103_setUpByDistanceAndTime);
			break;

		case BusinessObject.PD_DOORCONTROL:// 车门控制 (车门上锁|解锁)
			T808_MessageHeader header8500 = new T808_MessageHeader();
			header8500.setRunningNum(opts);
			header8500.setMessageID(0x8500);
			header8500.setTerminalKey(bo.getTerminalKey());
			TDDoorControl doorLock = (TDDoorControl) bo;
			T808_0x8500 body0x8500_doorLock = new T808_0x8500();
			body0x8500_doorLock.setControlSign(doorLock.getControlSign());
			message = new T808_Message<T808_MessageHeader, T808_0x8500>(
					header8500, body0x8500_doorLock);
			break;

		case BusinessObject.PD_SETTCPTIMEOUT:// TCP消息应答超时时间
			T808_MessageHeader header0002 = new T808_MessageHeader();
			header0002.setRunningNum(opts);
			header0002.setMessageID(0x8103);
			header0002.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setTcpTimeOut = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setTcpTimeOut = new T808_0x8103();
			body0x8103_setTcpTimeOut.setPackageCount(setTcpTimeOut
					.getPackageCount());
			body0x8103_setTcpTimeOut.setParamCount(setTcpTimeOut
					.getParamCount());
			body0x8103_setTcpTimeOut.setSettings(setTcpTimeOut.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0002, body0x8103_setTcpTimeOut);
			break;

		case BusinessObject.PD_SETTCPRECONNECT:// TCP重连次数

			T808_MessageHeader header0003 = new T808_MessageHeader();
			header0003.setRunningNum(opts);
			header0003.setMessageID(0x8103);
			header0003.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setTcpReconnet = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setTcpReconnet = new T808_0x8103();
			body0x8103_setTcpReconnet.setPackageCount(setTcpReconnet
					.getPackageCount());
			body0x8103_setTcpReconnet.setParamCount(setTcpReconnet
					.getParamCount());
			body0x8103_setTcpReconnet.setSettings(setTcpReconnet.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0003, body0x8103_setTcpReconnet);
			break;

		case BusinessObject.PD_SMSTIMEOUT:// SMS超时时间

			T808_MessageHeader header0006 = new T808_MessageHeader();
			header0006.setRunningNum(opts);
			header0006.setMessageID(0x8103);
			header0006.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setSMSTimeOut = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setSMSTimeOut = new T808_0x8103();
			body0x8103_setSMSTimeOut.setPackageCount(setSMSTimeOut
					.getPackageCount());
			body0x8103_setSMSTimeOut.setParamCount(setSMSTimeOut
					.getParamCount());
			body0x8103_setSMSTimeOut.setSettings(setSMSTimeOut.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0006, body0x8103_setSMSTimeOut);
			break;
		case BusinessObject.PD_SMSRECONNECT:// SMS重连次数

			T808_MessageHeader header0007 = new T808_MessageHeader();
			header0007.setRunningNum(opts);
			header0007.setMessageID(0x8103);
			header0007.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setSMSReconnect = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setSMSReconnect = new T808_0x8103();
			body0x8103_setSMSReconnect.setPackageCount(setSMSReconnect
					.getPackageCount());
			body0x8103_setSMSReconnect.setParamCount(setSMSReconnect
					.getParamCount());
			body0x8103_setSMSReconnect.setSettings(setSMSReconnect
					.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0007, body0x8103_setSMSReconnect);
			break;

		case BusinessObject.PD_SETALARMSPEED:// 最高速度设置 报警速度

			T808_MessageHeader header0055 = new T808_MessageHeader();
			header0055.setRunningNum(opts);
			header0055.setMessageID(0x8103);
			header0055.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setAlarmSpeed = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setAlarmSpeed = new T808_0x8103();
			body0x8103_setAlarmSpeed.setPackageCount(setAlarmSpeed
					.getPackageCount());
			body0x8103_setAlarmSpeed.setParamCount(setAlarmSpeed
					.getParamCount());
			body0x8103_setAlarmSpeed.setSettings(setAlarmSpeed.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0055, body0x8103_setAlarmSpeed);
			break;

		case BusinessObject.PD_SETALARMSPEEDTIME:// 报警持续时间

			T808_MessageHeader header0056 = new T808_MessageHeader();
			header0056.setRunningNum(opts);
			header0056.setMessageID(0x8103);
			header0056.setTerminalKey(bo.getTerminalKey());
			TDTerminalParamSet setAlarmSpeedTime = (TDTerminalParamSet) bo;
			T808_0x8103 body0x8103_setAlarmSpeedTime = new T808_0x8103();
			body0x8103_setAlarmSpeedTime.setPackageCount(setAlarmSpeedTime
					.getPackageCount());
			body0x8103_setAlarmSpeedTime.setParamCount(setAlarmSpeedTime
					.getParamCount());
			body0x8103_setAlarmSpeedTime.setSettings(setAlarmSpeedTime
					.getSettings());
			message = new T808_Message<T808_MessageHeader, T808_0x8103>(
					header0056, body0x8103_setAlarmSpeedTime);
			break;

		case BusinessObject.PD_TRAVELDATARECORDER:// 行驶记录仪数据请求

			T808_MessageHeader header8700 = new T808_MessageHeader();
			header8700.setRunningNum(opts);
			header8700.setMessageID(0x8700);
			header8700.setTerminalKey(bo.getTerminalKey());
			TDTravelDataRecorder travelDataRecorder = (TDTravelDataRecorder) bo;
			T808_0x8700 body0x8700_travelDataRecorder = new T808_0x8700();
			body0x8700_travelDataRecorder.setCommand(travelDataRecorder
					.getCommand());

			message = new T808_Message<T808_MessageHeader, T808_0x8700>(
					header8700, body0x8700_travelDataRecorder);
			break;
		
		case BusinessObject.PD_QUERYTERMINALPARAM: //查询终端参数
			
			T808_MessageHeader header8104=new T808_MessageHeader();
			header8104.setRunningNum(opts);
			header8104.setTerminalKey(bo.getTerminalKey());
			header8104.setMessageID(0x8104);
//			TDQueryTerminalParam queryTerminalParam=(TDQueryTerminalParam)bo;
			T808_0x8104 body0x8104_queryTerminalParam=new T808_0x8104();
			body0x8104_queryTerminalParam.setMessageID(0x8104);
			message=new T808_Message<T808_MessageHeader,T808_0x8104>(header8104, body0x8104_queryTerminalParam);
			break;
		

		case BusinessObject.PD_TEMPORARYPOSITIONTRACKING://临时位置跟踪
			
			T808_MessageHeader header8202=new T808_MessageHeader();
			header8202.setRunningNum(opts);
			header8202.setTerminalKey(bo.getTerminalKey());
			header8202.setMessageID(0x8202);
			TDTemporaryPositionTracking temporaryPositionTracking=(TDTemporaryPositionTracking)bo;
			T808_0x8202 body0x8202_temporaryPosition=new T808_0x8202();
			body0x8202_temporaryPosition.setInterval(temporaryPositionTracking.getInterval());
			body0x8202_temporaryPosition.setValidity(temporaryPositionTracking.getValidity());
			message=new T808_Message<T808_MessageHeader, T808_0x8202>(header8202, body0x8202_temporaryPosition);
			
			break;
			
		case BusinessObject.PD_MANUALCONFIRMATIONALARM://人工确认报警消息
			
			T808_MessageHeader header8203=new T808_MessageHeader();
			header8203.setRunningNum(opts);
			header8203.setTerminalKey(bo.getTerminalKey());
			header8203.setMessageID(0x8203);
			TDManualConfirmationAlarm manualConfirmationAlarm=(TDManualConfirmationAlarm)bo;
			T808_0x8203 body0x8203_manualConfirmationAlarm=new T808_0x8203();
			body0x8203_manualConfirmationAlarm.setAlarmMessageSeq(manualConfirmationAlarm.getAlarmMessageSeq());
			body0x8203_manualConfirmationAlarm.setAlarmType(manualConfirmationAlarm.getAlarmType());
			message=new T808_Message<T808_MessageHeader, T808_MessageBody>(header8203, body0x8203_manualConfirmationAlarm);
			break;
			
		case BusinessObject.PD_TERMINALPARAMSET://批量终端设置
			
			T808_MessageHeader header8103=new T808_MessageHeader();
			header8103.setRunningNum(opts);
			header8103.setTerminalKey(bo.getTerminalKey());
			header8103.setMessageID(0x8103);
			TDTerminalParamSet terminalParamSet=(TDTerminalParamSet)bo;
			T808_0x8103 body0x8103_terminalParams=new T808_0x8103();
			body0x8103_terminalParams.setPackageCount(terminalParamSet.getPackageCount());
			body0x8103_terminalParams.setParamCount(terminalParamSet.getParamCount());
			body0x8103_terminalParams.setSettings(terminalParamSet.getSettings());
			message=new T808_Message<T808_MessageHeader, T808_MessageBody>(header8103, body0x8103_terminalParams);
			break;		
		case BusinessObject.PD_LIMITPHONE://电话限制
			T808_MessageHeader header_4647=new T808_MessageHeader();
			header_4647.setRunningNum(opts);
			header_4647.setTerminalKey(bo.getTerminalKey());
			header_4647.setMessageID(0x8103);
			TDTerminalParamSet terminalParamSet_4647=(TDTerminalParamSet)bo;
			T808_0x8103 body0x8103_body_4647 = new T808_0x8103();
			body0x8103_body_4647.setPackageCount(terminalParamSet_4647.getPackageCount());
			body0x8103_body_4647.setParamCount(terminalParamSet_4647.getParamCount());
			body0x8103_body_4647.setSettings(terminalParamSet_4647.getSettings());
			message=new T808_Message<T808_MessageHeader, T808_MessageBody>(header_4647, body0x8103_body_4647);
			break;
		case BusinessObject.PD_CLOSEALARM://取消报警
			T808_MessageHeader header_50=new T808_MessageHeader();
			header_50.setRunningNum(opts);
			header_50.setTerminalKey(bo.getTerminalKey());
			header_50.setMessageID(0x8103);
			TDTerminalParamSet terminalParamSet_50=(TDTerminalParamSet)bo;
			T808_0x8103 body0x8103_body_50 = new T808_0x8103();
			body0x8103_body_50.setPackageCount(terminalParamSet_50.getPackageCount());
			body0x8103_body_50.setParamCount(terminalParamSet_50.getParamCount());
			body0x8103_body_50.setSettings(terminalParamSet_50.getSettings());
			message=new T808_Message<T808_MessageHeader, T808_MessageBody>(header_50, body0x8103_body_50);
			break;
		case BusinessObject.PD_CIRCLE_AREA:
			T808_MessageHeader header_8600 = new T808_MessageHeader();
			header_8600.setRunningNum(opts);
			header_8600.setTerminalKey(bo.getTerminalKey());
			header_8600.setMessageID(0x8600);
			TDCircleArea circleArea = (TDCircleArea) bo;
			T808_0x8600 body_8600 = new T808_0x8600();
			body_8600.setAreaID(circleArea.getId());
			body_8600.setSetAttribute(0);
			body_8600.setCenterLon(Double.valueOf(circleArea.getCenterX()*1000000).intValue());
			body_8600.setCenterLat(Double.valueOf(circleArea.getCenterY()*1000000).intValue());
			body_8600.setPackageAreaNumber(1);
			body_8600.setRadius(Double.valueOf(circleArea.getRadius()).intValue());
			body_8600.setAreaAttribute(circleArea.getType());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8600, body_8600);
			break;
		case BusinessObject.PD_CIRCLE_AREA_DELETE:
			T808_MessageHeader header_8601 = new T808_MessageHeader();
			header_8601.setRunningNum(opts);
			header_8601.setTerminalKey(bo.getTerminalKey());
			header_8601.setMessageID(0x8601);
			TDCircleAreaDelete circleAreaDelete =(TDCircleAreaDelete) bo;
			T808_0x8601 body_8601 = new T808_0x8601();
			body_8601.getList().add(circleAreaDelete.getId());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8601, body_8601);
			break;
		case BusinessObject.PD_RECTANGLE_AREA:
			T808_MessageHeader header_8602 = new T808_MessageHeader();
			header_8602.setRunningNum(opts);
			header_8602.setTerminalKey(bo.getTerminalKey());
			header_8602.setMessageID(0x8602);
			TDRectangleArea rectangleArea = (TDRectangleArea) bo;
			T808_0x8602 body_8602 = new T808_0x8602();
			body_8602.setAreaID(rectangleArea.getId());
			body_8602.setSetAttribute(0);
			body_8602.setUpperLeftLon(Double.valueOf(rectangleArea.getTopLeftX()*1000000).intValue());
			body_8602.setUpperLeftLat(Double.valueOf(rectangleArea.getTopLeftY()*1000000).intValue());
			body_8602.setLowerRightLon(Double.valueOf(rectangleArea.getButtomRightX()*1000000).intValue());
			body_8602.setLowerRightLat(Double.valueOf(rectangleArea.getButtomRightY()*1000000).intValue());
			body_8602.setPackageAreaNumber(1);
			body_8602.setAreaAttribute(rectangleArea.getType());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8602, body_8602);
			break;
		case BusinessObject.PD_RECTANGLE_AREA_DELETE:
			T808_MessageHeader header_8603 = new T808_MessageHeader();
			header_8603.setRunningNum(opts);
			header_8603.setTerminalKey(bo.getTerminalKey());
			header_8603.setMessageID(0x8603);
			TDRectangleAreaDelete rectangleAreaDelete = (TDRectangleAreaDelete)bo;
			T808_0x8603 body_8603 = new T808_0x8603();
			body_8603.getList().add(rectangleAreaDelete.getId());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8603, body_8603);
			break;
		case BusinessObject.PD_POLYGON_AREA:
			T808_MessageHeader header_8604 = new T808_MessageHeader();
			header_8604.setRunningNum(opts);
			header_8604.setTerminalKey(bo.getTerminalKey());
			header_8604.setMessageID(0x8604);
			TDPolygonArea polygonArea = (TDPolygonArea) bo;
			T808_0x8604 body_8604 = new T808_0x8604();
			body_8604.setAreaID(polygonArea.getId());
			body_8604.setAreaPointsCount(polygonArea.getPointsNumber());
			for (double[] p : polygonArea.getPoints()) {
				body_8604.getVertexMap().put(Double.valueOf(p[0]*1000000).intValue(), Double.valueOf(p[1]*1000000).intValue());
			}
			body_8604.setAreaAttribute(polygonArea.getType());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8604, body_8604);
			break;
		case BusinessObject.PD_POLYGON_AREA_DELETE:
			T808_MessageHeader header_8605 = new T808_MessageHeader();
			header_8605.setRunningNum(opts);
			header_8605.setTerminalKey(bo.getTerminalKey());
			header_8605.setMessageID(0x8605);
			TDPolygonAreaDelete polygonAreaDelete = (TDPolygonAreaDelete)bo;
			T808_0x8605 body_8605 = new T808_0x8605();
			body_8605.getList().add(polygonAreaDelete.getId());
			message = new T808_Message<T808_MessageHeader, T808_MessageBody>(header_8605, body_8605);
			break;
		default:
			break;
		}
		return (Message<MessageHeader, MessageBody>) message;
	}
}

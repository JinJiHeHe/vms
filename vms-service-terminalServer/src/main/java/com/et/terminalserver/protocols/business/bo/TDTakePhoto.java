package com.et.terminalserver.protocols.business.bo;

public class TDTakePhoto extends BusinessObject {

	private int channelID = 1;// 0 通道ID BYTE >0
	private int shootCommand = 1;// 拍摄张数
	private int recordTime = 3;// 3 拍照间隔，录像时间 WORD 秒，0表示按最小间隔拍照或一直录像
	private int keepSign = 0;// 5 保持标志 BYTE 1：保存；0：实时上传
	private int resolution = 2;// 分辨率
	private int imageQuality = 1;// 7 图像/视频质量 BYTE 1-10, 1代表质量损失最小，10表示压缩比最大
	private int brightness = 0;// 8 亮度 BYTE 0-255
	private int contrast = 0;// 对比度
	private int saturability = 0;// 饱和度
	private int chrmaticity = 0;// 色度

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public int getShootCommand() {
		return shootCommand;
	}

	public void setShootCommand(int shootCommand) {
		this.shootCommand = shootCommand;
	}

	public int getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	public int getKeepSign() {
		return keepSign;
	}

	public void setKeepSign(int keepSign) {
		this.keepSign = keepSign;
	}

	public int getResolution() {
		return resolution;
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	public int getImageQuality() {
		return imageQuality;
	}

	public void setImageQuality(int imageQuality) {
		this.imageQuality = imageQuality;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public int getContrast() {
		return contrast;
	}

	public void setContrast(int contrast) {
		this.contrast = contrast;
	}

	public int getSaturability() {
		return saturability;
	}

	public void setSaturability(int saturability) {
		this.saturability = saturability;
	}

	public int getChrmaticity() {
		return chrmaticity;
	}

	public void setChrmaticity(int chrmaticity) {
		this.chrmaticity = chrmaticity;
	}

	@Override
	public int getBusinessCode() {
		return PD_TAKEPHOTO;
	}
}

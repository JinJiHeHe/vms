package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8801
 * @Description: 摄像头立即拍摄命令
 * @author: lijz
 * @date: 2014年4月28日 下午4:08:57
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class T808_0x8801 extends T808_MessageBody {

	private int channelID;// 0 通道ID BYTE >0
	private int shootCommand;// 拍摄张数
	private int recordTime;// 3 拍照间隔，录像时间 WORD 秒，0表示按最小间隔拍照或一直录像
	private int keepSign;// 5 保持标志 BYTE 1：保存；0：实时上传
	private int resolution;// 分辨率
	private int imageQuality;// 7 图像/视频质量 BYTE 1-10, 1代表质量损失最小，10表示压缩比最大
	private int brightness;// 8 亮度 BYTE 0-255
	private int contrast;// 对比度
	private int saturability;// 饱和度
	private int chrmaticity;// 色度

	/**
	 * @Description 获得 channelID
	 */
	public int getChannelID() {
		return channelID;
	}

	/**
	 * @Description:设置 channelID
	 */
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	/**
	 * @Description 获得 shootCommand
	 */
	public int getShootCommand() {
		return shootCommand;
	}

	/**
	 * @Description:设置 shootCommand
	 */
	public void setShootCommand(int shootCommand) {
		this.shootCommand = shootCommand;
	}

	/**
	 * @Description 获得 recordTime
	 */
	public int getRecordTime() {
		return recordTime;
	}

	/**
	 * @Description:设置 recordTime
	 */
	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * @Description 获得 keepSign
	 */
	public int getKeepSign() {
		return keepSign;
	}

	/**
	 * @Description:设置 keepSign
	 */
	public void setKeepSign(int keepSign) {
		this.keepSign = keepSign;
	}

	/**
	 * @Description 获得 resolution
	 */
	public int getResolution() {
		return resolution;
	}

	/**
	 * @Description:设置 resolution
	 */
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	/**
	 * @Description 获得 imageQuality
	 */
	public int getImageQuality() {
		return imageQuality;
	}

	/**
	 * @Description:设置 imageQuality
	 */
	public void setImageQuality(int imageQuality) {
		this.imageQuality = imageQuality;
	}

	/**
	 * @Description 获得 brightness
	 */
	public int getBrightness() {
		return brightness;
	}

	/**
	 * @Description:设置 brightness
	 */
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	/**
	 * @Description 获得 contrast
	 */
	public int getContrast() {
		return contrast;
	}

	/**
	 * @Description:设置 contrast
	 */
	public void setContrast(int contrast) {
		this.contrast = contrast;
	}

	/**
	 * @Description 获得 saturability
	 */
	public int getSaturability() {
		return saturability;
	}

	/**
	 * @Description:设置 saturability
	 */
	public void setSaturability(int saturability) {
		this.saturability = saturability;
	}

	/**
	 * @Description 获得 chrmaticity
	 */
	public int getChrmaticity() {
		return chrmaticity;
	}

	/**
	 * @Description:设置 chrmaticity
	 */
	public void setChrmaticity(int chrmaticity) {
		this.chrmaticity = chrmaticity;
	}

	public T808_0x8801() {
	}

}

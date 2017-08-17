package com.et.terminalserver.protocols.business.bo;

import java.util.Set;

/**
 * @Description 多媒体请求响应
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:10:44
 * @mail terrorbladeyang@gmail.com
 */
public class TDMediaResponse extends BusinessObject {

	private int mediaId;
	private Set<String> needPackets;

	@Override
	public int getBusinessCode() {
		return PR_MUTI_MEDIA_RESPONSE;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public Set<String> getNeedPackets() {
		return needPackets;
	}

	public void setNeedPackets(Set<String> needPackets) {
		this.needPackets = needPackets;
	}

	@Override
	public int getResponseCode() {
		return PR_MUTI_MEDIA_RESPONSE;
	}
	

}

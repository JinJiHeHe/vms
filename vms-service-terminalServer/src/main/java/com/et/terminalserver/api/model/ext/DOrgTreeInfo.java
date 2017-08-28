package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 组织数的统计信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:52:54
 * @mail terrorbladeyang@gmail.com
 */
public class DOrgTreeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8712424507232520382L;

	private String orgCode;

	private String orgName;

	private Integer total;

	private Integer online;

	private Integer offline;

	private Integer running;

	private Integer stopped;

	private Integer unUsed;

	/**
	 * orgCode
	 * 
	 * @return
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * orgCode
	 * 
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * orgName
	 * 
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * orgName
	 * 
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * 车辆总数
	 * 
	 * @return
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 车辆总数
	 * 
	 * @param total
	 */
	public void setTotal(Integer total) {
		if(total==null || total<0){
			total=0;
		}
		this.total = total;
	}

	/**
	 * 在线数目
	 * 
	 * @return
	 */
	public Integer getOnline() {
		return online;
	}

	/**
	 * 在线数目
	 * 
	 * @param online
	 */
	public void setOnline(Integer online) {
		if(online==null || online<0){
			online=0;
		}
		this.online = online;
	}

	/**
	 * 离线数目
	 * 
	 * @return
	 */
	public Integer getOffline() {
		return offline;
	}

	/**
	 * 离线数目
	 * 
	 * @param offline
	 */
	public void setOffline(Integer offline) {
		if(offline==null || offline<0){
			offline=0;
		}
		this.offline = offline;
	}

	/**
	 * 行驶中数目
	 * 
	 * @return
	 */
	public Integer getRunning() {
		return running;
	}

	/**
	 * 行驶中数目
	 * 
	 * @param running
	 */
	public void setRunning(Integer running) {
		if(running==null || running<0){
			running=0;
		}
		this.running = running;
	}

	/**
	 * 停车数目
	 * 
	 * @return
	 */
	public Integer getStopped() {
		return stopped;
	}

	/**
	 * 停车数目
	 * 
	 * @param stopped
	 */
	public void setStopped(Integer stopped) {
		if(stopped==null || stopped<0){
			stopped=0;
		}
		this.stopped = stopped;
	}

	/**
	 * 未曾上线数目
	 * 
	 * @return
	 */
	public Integer getUnUsed() {
		return unUsed;
	}

	/**
	 * 未曾上线数目
	 * 
	 * @param unUsed
	 */
	public void setUnUsed(Integer unUsed) {
		if(unUsed==null || unUsed<0){
			unUsed=0;
		}
		this.unUsed = unUsed;
	}
	

	@Override
	public String toString() {
		return "DOrgTreeInfo [orgCode=" + orgCode + ", orgName=" + orgName + ", total=" + total + ", online=" + online
				+ ", offline=" + offline + ", running=" + running + ", stopped=" + stopped + ", unUsed=" + unUsed + "]";
	}

}

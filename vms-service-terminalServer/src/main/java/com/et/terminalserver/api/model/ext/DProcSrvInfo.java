package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 从服务器获取的动态进程服务信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:57:58
 * @mail terrorbladeyang@gmail.com
 */

public class DProcSrvInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5712626515017614074L;
	// 进程编号

	private Integer couresId;
	// 进程服务名

	private String couresName;
	// 内存利用率

	private String memory;
	// CPU利用率

	private String cpu;
	// 进程状态(状态：”0”表示运行，”1”表示终止)

	private Integer status;
	// 进程启用时间(进程启动后获取的时间)

	private String startTime;
	// 进程终止时间(进程结束时间)

	private String terminationTime;

	private String serviceIp;

	/**
	 * 进程服务名
	 * 
	 * @return
	 */
	public String getCouresName() {
		return couresName;
	}

	/**
	 * 进程服务名
	 * 
	 * @param couresName
	 */
	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}

	/**
	 * 内存利用率
	 * 
	 * @return
	 */
	public String getMemory() {
		return memory;
	}

	/**
	 * 内存利用率
	 * 
	 * @param memory
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	/**
	 * CPU利用率
	 * 
	 * @return
	 */
	public String getCpu() {
		return cpu;
	}

	/**
	 * CPU利用率
	 * 
	 * @param cpu
	 */
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * 进程编号
	 * 
	 * @return
	 */
	public Integer getCouresId() {
		return couresId;
	}

	/**
	 * 进程编号
	 * 
	 * @param couresId
	 */
	public void setCouresId(Integer couresId) {
		this.couresId = couresId;
	}

	/**
	 * 进程状态(状态：”0”表示运行，”1”表示终止)
	 * 
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 进程状态(状态：”0”表示运行，”1”表示终止)
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 进程启用时间(进程启动后获取的时间)
	 * 
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 进程启用时间(进程启动后获取的时间)
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 进程终止时间(进程结束时间)
	 * 
	 * @return
	 */
	public String getTerminationTime() {
		return terminationTime;
	}

	/**
	 * 进程终止时间(进程结束时间)
	 * 
	 * @param terminationTime
	 */
	public void setTerminationTime(String terminationTime) {
		this.terminationTime = terminationTime;
	}

	/**
	 * 进程服务所在服务器IP
	 * 
	 * @return
	 */
	public String getServiceIp() {
		return serviceIp;
	}

	/**
	 * 进程服务所在服务器IP
	 * 
	 * @param serviceIp
	 */
	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	@Override
	public String toString() {
		return "DProcSrvInfo [couresId=" + couresId + ", couresName=" + couresName + ", memory=" + memory + ", cpu="
				+ cpu + ", status=" + status + ", startTime=" + startTime + ", terminationTime=" + terminationTime
				+ ", serviceIp=" + serviceIp + "]";
	}

}

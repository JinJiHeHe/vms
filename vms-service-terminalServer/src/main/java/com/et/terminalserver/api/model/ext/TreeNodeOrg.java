package com.et.terminalserver.api.model.ext;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 树形结构
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:06:21
 * @mail terrorbladeyang@gmail.com
 */
public class TreeNodeOrg {
	/**
	 * 单位编号
	 */
	private String orgCode;
	/**
	 * 用户编号集合
	 */
	private List<String> userCodes = new ArrayList<String>();
	/**
	 * 车辆编号集合
	 */
	private List<Integer> vehicleIds = new ArrayList<Integer>();

	public List<String> getUserCodes() {
		return userCodes;
	}

	public void setUserCodes(List<String> userCodes) {
		this.userCodes = userCodes;
	}

	public List<Integer> getVehicleIds() {
		return vehicleIds;
	}

	public void setVehicleIds(List<Integer> vehicleIds) {
		this.vehicleIds = vehicleIds;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Override
	public String toString() {
		return "TreeNodeOrg [orgCode=" + orgCode + ", userCodes=" + userCodes + ", vehicleIds=" + vehicleIds + "]";
	}

}

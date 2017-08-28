package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.List;

public class UpperList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5056672661942853260L;

	private Integer vid;
	private List<String> plates;

	public List<String> getPlates() {
		return plates;
	}

	public void setPlates(List<String> plates) {
		this.plates = plates;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}
}

package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 字典类型
 * @author ronglj
 * @version V1.0
 * @Date 2015年8月3日 下午4:03:39
 */

public class SDictionaryInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1696132051059826066L;

	/**
	 * 字典类型
	 */
	private String dictionaryType;

	/**
	 * 字典值列表
	 */
	private List<DictionaryValue> list;

	public String getDictionaryType() {
		return dictionaryType;
	}

	public void setDictionaryType(String dictionaryType) {
		this.dictionaryType = dictionaryType;
	}

	public List<DictionaryValue> getList() {
		return list;
	}

	public void setList(List<DictionaryValue> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SDictionaryInfo [dictionaryType=" + dictionaryType + ", list=" + list + "]";
	}

	public void add(DictionaryValue dictionaryValue) {
		// TODO Auto-generated method stub
		if (list == null)
			list = new ArrayList<DictionaryValue>();
		this.list.add(dictionaryValue);
	}
}

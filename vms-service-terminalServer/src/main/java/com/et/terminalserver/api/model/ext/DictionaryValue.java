package com.et.terminalserver.api.model.ext;

public class DictionaryValue {

	/**
	 * 字典代码
	 */
	private String code;

	/**
	 * 字典值
	 */
	private String value;

	public DictionaryValue(String dataCode, String dataVal) {
		this.code = dataCode;
		this.value = dataVal;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DictionaryValue [code=" + code + ", value=" + value + "]";
	}

}

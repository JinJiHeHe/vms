package com.et.terminalserver.common.cache;

public interface RemoveLimited {

	/**
	 * 
	 * @param data
	 *            被删除的数据
	 * @param reason
	 */
	void onRemove(Object key, Object data, String reason);
}

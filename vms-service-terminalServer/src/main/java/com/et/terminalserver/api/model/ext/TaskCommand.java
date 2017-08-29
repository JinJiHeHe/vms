package com.et.terminalserver.api.model.ext;
/**
 * 定时任务结构类
 * 
 */

public class TaskCommand implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7869881992267273827L;
	/**
	 * 任务ID
	 */

	private String taskId;
	/**
	 * 任务名称
	 */

	private String taskName;
	/**
	 * 操作类型 0 为新增， 1 为修改， 2 为删除， 3为禁用
	 */

	private int operator;

	/**
	 * @return 任务id
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId
	 *            任务id
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return 任务名称
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName
	 *            任务名称
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return 操作类型 0 为新增， 1 为修改， 2 为删除， 3为禁用
	 */
	public int getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            操作类型 0 为启用， 1 为修改， 2 为删除， 3为禁用
	 */
	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "TaskCommand [taskId=" + taskId + ", taskName=" + taskName + ", operator=" + operator + "]";
	}

}

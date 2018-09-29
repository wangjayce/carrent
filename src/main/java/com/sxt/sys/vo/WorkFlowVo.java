package com.sxt.sys.vo;

public class WorkFlowVo {

	/**
	 * 部署名称
	 */
	private String deploymentName;
	
	private String deploymentId;
	
	/**
	 * 请假单id
	 */
	private Integer leavebillId;
	/**
	 * 任务id
	 */
	private String taskId;
	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;
	/**
	 * 批注内容
	 * @return
	 */
	private String content;
	/**
	 * 办理人
	 * @return
	 */
	private String assignee;
	
	/**
	 * 连线名称
	 * @return
	 */
	private String outcome;
	
	
	
	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Integer getLeavebillId() {
		return leavebillId;
	}

	public void setLeavebillId(Integer leavebillId) {
		this.leavebillId = leavebillId;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}

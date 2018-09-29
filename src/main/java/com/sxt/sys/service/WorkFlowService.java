package com.sxt.sys.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.WorkFlowVo;

public interface WorkFlowService {

	/**
	 * 加载部署信息表
	 * @param workFlowVo
	 * @return
	 */
	DataGrid uploadAllProcessDeployment(WorkFlowVo workFlowVo);

	/**
	 * 加载流程定义信息表
	 * @param workFlowVo
	 * @return
	 */
	DataGrid uploadAllProcessDef(WorkFlowVo workFlowVo);

	/**
	 * 部署流程
	 * @param inputStream
	 * @param deploymentName
	 */
	void addDeployment(InputStream inputStream, String deploymentName);

	/**
	 * 删除流程
	 * @param deploymentId
	 */
	void deleteDeployment(String deploymentId);

	/**
	 * 加载流程图
	 * @param deploymentId
	 * @return
	 */
	
	InputStream viewProcessImage(String deploymentId);

	/**
	 * 提交请假单
	 * @param leavebillId
	 */
	void addsubmitLeavebill(Integer leavebillId);

	/**
	 * 加载待办任务
	 * @param workFlowVo
	 * @return
	 */
	DataGrid uploadAlltask(WorkFlowVo workFlowVo);

	/**
	 * 根据任务id查询请假单
	 * @param taskId
	 * @return
	 */
	Leavebill queryLeavebillByTaskId(String taskId);

	List<String> queryConditionByTaskId(String taskId);

	DataGrid uploadAllComment(WorkFlowVo workFlowVo);

	void addcompleteTask(WorkFlowVo workFlowVo);

	Map<String, Object> checkProcessImage(WorkFlowVo workFlowVo);

	String getDeployIdByTaskId(String taskId);

	DataGrid uploadAllMyTask(WorkFlowVo workFlowVo);

	DataGrid uploadAllComments(Integer leavebillId);

	/*DataGrid uploadAllHistoryProcessDef();*/

	

}

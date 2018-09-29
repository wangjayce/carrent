package com.sxt.sys.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.mapper.LeavebillMapper;
import com.sxt.sys.service.WorkFlowService;
import com.sxt.sys.utils.ActTaskEntity;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.SessionUtils;
import com.sxt.sys.vo.ActCommentEntity;
import com.sxt.sys.vo.ActDeploymentEntity;
import com.sxt.sys.vo.ActProcessDefinitionEntity;
import com.sxt.sys.vo.WorkFlowVo;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {

	@Autowired
	private LeavebillMapper leavebillMapper;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private FormService formService;

	@Override
	public DataGrid uploadAllProcessDeployment(WorkFlowVo workFlowVo) {
		String deployName = workFlowVo.getDeploymentName();
		if (null == deployName) {
			deployName = "";
		}
		long count = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deployName + "%").count();
		List<Deployment> list = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deployName + "%")
				.list();
		List<ActDeploymentEntity> entitys = new ArrayList<>();
		if (null != list && list.size() > 0) {
			for (Deployment deployment : list) {
				ActDeploymentEntity entity = new ActDeploymentEntity();
				BeanUtils.copyProperties(deployment, entity);
				entitys.add(entity);
			}

		}
		return new DataGrid(count, entitys);
	}

	@Override
	public DataGrid uploadAllProcessDef(WorkFlowVo workFlowVo) {
		String deployName = workFlowVo.getDeploymentName();
		if (null == deployName) {
			deployName = "";
		}
		List<Deployment> list = repositoryService.createDeploymentQuery().deploymentNameLike("%" + deployName + "%")
				.list();

		if (list == null || list.size() == 0) {
			return new DataGrid(0L, null);
		}
		Set<String> deploymentIds = new HashSet<>();
		for (Deployment deployment : list) {
			deploymentIds.add(deployment.getId());
		}
		List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery()
				.deploymentIds(deploymentIds).list();
		long count = repositoryService.createProcessDefinitionQuery().deploymentIds(deploymentIds).count();
		List<ActProcessDefinitionEntity> processDefs = new ArrayList<>();
		for (ProcessDefinition pd : definitions) {
			ActProcessDefinitionEntity entity = new ActProcessDefinitionEntity();
			BeanUtils.copyProperties(pd, entity);
			processDefs.add(entity);
		}
		return new DataGrid(count, processDefs);
	}

	@Override
	public void addDeployment(InputStream inputStream, String deploymentName) {
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		repositoryService.createDeployment().name(deploymentName).addZipInputStream(zipInputStream).deploy();
	}

	@Override
	public void deleteDeployment(String deploymentId) {
		repositoryService.deleteDeployment(deploymentId);
	}

	@Override
	public InputStream viewProcessImage(String deploymentId) {
		ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deploymentId)
				.singleResult();
		String resourceName = definition.getDiagramResourceName();
		InputStream stream = repositoryService.getResourceAsStream(deploymentId, resourceName);
		return stream;
	}

	@Override
	public void addsubmitLeavebill(Integer leavebillId) {

		String processDefinitionKey = Leavebill.class.getSimpleName();
		String businessKey = processDefinitionKey + "_" + leavebillId;
		Map<String, Object> variables = new HashMap<>();
		String username = SessionUtils.getUserNameInSession("user");
		variables.put("username", username);
		runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
		Leavebill leavebill = new Leavebill();
		leavebill.setId(leavebillId);
		leavebill.setState(String.valueOf(SYS_Constast.TYPE_PUBLIC_ONE));
		leavebillMapper.updateByPrimaryKeySelective(leavebill);
	}

	@Override
	public DataGrid uploadAlltask(WorkFlowVo workFlowVo) {
		String assignee = SessionUtils.getUserNameInSession("user");
		List<Task> list = taskService.createTaskQuery().taskAssignee(assignee)
				.listPage((workFlowVo.getPage() - 1) * workFlowVo.getLimit(), workFlowVo.getLimit());
		if (null == list || list.size() == 0) {
			return new DataGrid(Long.valueOf(SYS_Constast.TYPE_PUBLIC_ZERO), null);
		}
		List<ActTaskEntity> tasks = new ArrayList<>();
		for (Task task : list) {
			ActTaskEntity entity = new ActTaskEntity();
			BeanUtils.copyProperties(task, entity);
			tasks.add(entity);
		}
		return new DataGrid(Long.valueOf(tasks.size()), tasks);
	}

	@Override
	public Leavebill queryLeavebillByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String instanceId = task.getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(instanceId)
				.singleResult();
		String businessKey = processInstance.getBusinessKey();
		Integer leavebillId = Integer.valueOf(businessKey.split("_")[1]);
		Leavebill leavebill = leavebillMapper.selectByPrimaryKey(leavebillId);
		return leavebill;
	}

	/**
	 * 查询连线条件
	 */
	@Override
	public List<String> queryConditionByTaskId(String taskId) {
		List<String> outcomes = new ArrayList<>();
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processDefinitionId = task.getProcessDefinitionId();
		String activityId = task.getTaskDefinitionKey();// 获取节点id
		// 4,使用流程定义ID查询流程定义对象 里面的xml的数据
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) this.repositoryService
				.getProcessDefinition(processDefinitionId);
		ActivityImpl activity = processDefinitionEntity.findActivity(activityId);
		List<PvmTransition> outgoingTransitions = activity.getOutgoingTransitions();
		if (null != outgoingTransitions && outgoingTransitions.size() > 0) {
			for (PvmTransition pt : outgoingTransitions) {
				outcomes.add(pt.getProperty("name").toString());
			}
		}
		return outcomes;
	}

	@Override
	public DataGrid uploadAllComment(WorkFlowVo workFlowVo) {
		List<ActCommentEntity> list = new ArrayList<>();
		Task task = taskService.createTaskQuery().taskId(workFlowVo.getTaskId()).singleResult();
		String processInstanceId = task.getProcessInstanceId();
		List<Comment> comments = taskService.getProcessInstanceComments(processInstanceId);
		if (null != comments && comments.size() > 0) {
			for (Comment comment : comments) {
				ActCommentEntity entity = new ActCommentEntity();
				BeanUtils.copyProperties(comment, entity);
				list.add(entity);
			}
		}

		return new DataGrid(Long.valueOf(list.size()), list);
	}

	@Override
	public void addcompleteTask(WorkFlowVo workFlowVo) {
		String content = workFlowVo.getContent();
		String taskId = workFlowVo.getTaskId();
		String outcome = workFlowVo.getOutcome();
		Integer leavebillId = workFlowVo.getLeavebillId();
		// 1.设置连线流程变量
		Map<String, Object> variables = new HashMap<>();
		variables.put("outcome", outcome);
		// 2.根据taskId得到流程实例id
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();
		// 3.设置批注人信息，通过线程局部变量设置
		// 6,设置当前线程用户的局部变量
		String username = SessionUtils.getUserNameInSession("user");
		Authentication.setAuthenticatedUserId(username);
		// 7,添加批注信息
		/**
		 * 因为批注 是属性某个办理人 所以一空设置办理人的ID。可以查看addComment-->AddcomentAdd--> String userId =
		 * Authentication.getAuthenticatedUserId(); CommentEntity comment = new
		 * CommentEntity(); comment.setUserId(userId);
		 */
		taskService.addComment(taskId, processInstanceId, "[" + outcome + "]" + content);
		// 8.完成任务
		taskService.complete(taskId, variables);
		// .完成任务后任务的状态
		ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId)
				.singleResult();
		if (null == instance) {
			Leavebill leavebill = new Leavebill();
			leavebill.setId(leavebillId);
			if (outcome.equals("放弃")) {
				leavebill.setState(String.valueOf(SYS_Constast.TYPE_PUBLIC_Three));
			} else {
				leavebill.setState(String.valueOf(SYS_Constast.TYPE_PUBLIC_TOW));
			}
			leavebillMapper.updateByPrimaryKeySelective(leavebill);
		}

	}

	/**
	 * 获取坐标
	 */
	@Override
	public Map<String, Object> checkProcessImage(WorkFlowVo workFlowVo) {
		Task task = taskService.createTaskQuery().taskId(workFlowVo.getTaskId()).singleResult();
		String processDefinitionId = task.getProcessDefinitionId();
		String activityId = task.getTaskDefinitionKey();// 获取节点id
		// 2,使用流程定义ID查询流程定义对象 里面的xml的数据
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) this.repositoryService
				.getProcessDefinition(processDefinitionId);
		ActivityImpl activity = processDefinitionEntity.findActivity(activityId);
		int x = activity.getX();
		int y = activity.getY();
		int width = activity.getWidth();
		int height = activity.getHeight();
		Map<String, Object> map = new HashMap<>();
		map.put("x", x);
		map.put("y", y);
		map.put("width", width);
		map.put("height", height);
		return map;
	}

	@Override
	public String getDeployIdByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String processDefinitionId = task.getProcessDefinitionId();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String deploymentId = processDefinition.getDeploymentId();
		return deploymentId;
	}

	@Override
	public DataGrid uploadAllMyTask(WorkFlowVo workFlowVo) {
		String username = SessionUtils.getUserNameInSession("user");
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().taskAssignee(username).list();
		List<ActTaskEntity> list1 = new ArrayList<>();
		if(null!=list&&list.size()>0) {
			for (HistoricTaskInstance ht : list) {
				ActTaskEntity entity = new ActTaskEntity();
				BeanUtils.copyProperties(ht, entity);
				list1.add(entity);
			}
		}
		return new DataGrid(Long.valueOf(list1.size()),list1);
	}

	@Override
	public DataGrid uploadAllComments(Integer leavebillId) {
		String processInstanceBusinessKey = Leavebill.class.getSimpleName()+"_"+leavebillId;
		HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(processInstanceBusinessKey).singleResult();
		String processInstanceId = historicProcessInstance.getId();
		List<Comment> comments = taskService.getProcessInstanceComments(processInstanceId);
		List<ActCommentEntity> list = new ArrayList<>();
		if (null != comments && comments.size() > 0) {
			for (Comment comment : comments) {
				ActCommentEntity entity = new ActCommentEntity();
				BeanUtils.copyProperties(comment, entity);
				list.add(entity);
			}
		}
		return new DataGrid(Long.valueOf(list.size()), list);
	}

	/*@Override
	public DataGrid uploadAllHistoryProcessDef() {
		//historyService.c
		return null;
	}*/
}

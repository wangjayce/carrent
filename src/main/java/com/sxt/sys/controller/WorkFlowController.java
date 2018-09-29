package com.sxt.sys.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.sys.domain.Leavebill;
import com.sxt.sys.service.LeavebillService;
import com.sxt.sys.service.WorkFlowService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.WorkFlowVo;

@Controller
@RequestMapping("workFlow")
public class WorkFlowController {

	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private LeavebillService leavebillService;
	/**
	 * 跳转到流程管理页面
	 */
	@RequestMapping("toWorkFlowManager")
	public String toWorkFlowManager() {
		return "system/workFlow/workFlowManager";
	}
	
	/**
	 * 加载部署信息表
	 * @return
	 */
	@RequestMapping("uploadAllProcessDeployment")
	@ResponseBody
	public DataGrid uploadAllProcessDeployment(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAllProcessDeployment(workFlowVo);
	}
	/**
	 * 加载流程定义表数据
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("uploadAllProcessDef")
	@ResponseBody
	public DataGrid uploadAllProcessDef(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAllProcessDef(workFlowVo);
	}
	
	/**
	 * 跳转到部署流程页面
	 */
	@RequestMapping("toaddDeployment")
	public String toaddDeployment() {
		return "system/workFlow/addDeployment";
	}
	/**
	 * 部署流程
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("addDeployment")
	@ResponseBody
	public Map<String, Object> addDeployment(MultipartFile mf, WorkFlowVo workFlowVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "部署成功";
		try {
			this.workFlowService.addDeployment(mf.getInputStream(), workFlowVo.getDeploymentName());
		} catch (Exception e) {
			e.printStackTrace();
			msg="部署失败";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 删除部署流程
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("deleteDeployment")
	@ResponseBody
	public Map<String, Object> deleteDeployment(WorkFlowVo workFlowVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除成功";
		try {
			this.workFlowService.deleteDeployment(workFlowVo.getDeploymentId());
		} catch (Exception e) {
			e.printStackTrace();
			msg="删除失败";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 跳转到查看流程图页面
	 */
	@RequestMapping("toviewProcessImage")
	public String toviewProcessImage(WorkFlowVo workFlowVo) {
		return "system/workFlow/viewProcessImage";
	}
	@RequestMapping("viewProcessImage")
	public void viewProcessImage(WorkFlowVo workFlowVo,HttpServletResponse response) {
		InputStream is = this.workFlowService.viewProcessImage(workFlowVo.getDeploymentId());
		try {
			BufferedImage io = ImageIO.read(is);
			ImageIO.write(io, "png", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * 提交申请
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("submitLeavebill")
	@ResponseBody
	public Map<String, Object> submitLeavebill(WorkFlowVo workFlowVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "完成提交";
		try {
			this.workFlowService.addsubmitLeavebill(workFlowVo.getLeavebillId());
		} catch (Exception e) {
			e.printStackTrace();
			msg="提交失败";
		}
		map.put("msg", msg);
		return map;
	}
	/**
	 * 跳转到查看待办任务页面
	 */
	@RequestMapping("toWaitDoTask")
	public String toWaitDoTask(WorkFlowVo workFlowVo) {
		return "system/workFlow/waitTaskManager";
	}
	/**
	 * 加载代办任务
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("uploadAlltask")
	@ResponseBody
	public DataGrid uploadAlltask(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAlltask(workFlowVo);
	}
	
	/**
	 * 跳转到办理任务页面
	 */
	@RequestMapping("todoTask")
	public String todoTask(WorkFlowVo workFlowVo,Model model) {
		//查询请假单
		Leavebill leavebill = workFlowService.queryLeavebillByTaskId(workFlowVo.getTaskId());
		model.addAttribute("leavebill", leavebill);
		//查询连线条件
		List<String> outcomes = workFlowService.queryConditionByTaskId(workFlowVo.getTaskId());
		model.addAttribute("outcome", outcomes);
		return "system/workFlow/doTaskManager";
	}
	/**
	 * 加载所有的批注表
	 */
	@RequestMapping("uploadAllComment")
	@ResponseBody
	public DataGrid uploadAllComment(WorkFlowVo workFlowVo) {
		
		return workFlowService.uploadAllComment(workFlowVo);
	}
	
	/**
	 * 完成任务
	 * @param workFlowVo
	 * @return
	 */
	@RequestMapping("completeTask")
	@ResponseBody
	public Map<String, Object> completeTask(WorkFlowVo workFlowVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "完成提交";
		try {
			this.workFlowService.addcompleteTask(workFlowVo);
		} catch (Exception e) {
			e.printStackTrace();
			msg="提交失败";
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 跳转到查看流程图页面
	 */
	@RequestMapping("tocheckProcessImage")
	public String tocheckProcessImage(WorkFlowVo workFlowVo,Model model) {
		Map<String, Object> map = workFlowService.checkProcessImage(workFlowVo);
		model.addAttribute("area", map);
		String deploymentId = workFlowService.getDeployIdByTaskId(workFlowVo.getTaskId());
		workFlowVo.setDeploymentId(deploymentId);
		return "system/workFlow/viewProcessImage";
	}
	/**
	 * 跳转到任务进度页面
	 */
	@RequestMapping("checkLeavebillProcess")
	public String checkLeavebillProcess(WorkFlowVo workFlowVo,Model model) {
		Leavebill leavebill = leavebillService.queryLeavebillById(workFlowVo.getLeavebillId());
		model.addAttribute("leavebill", leavebill);
		return "system/workFlow/checkLeavibillProcess";
	}
	
	/**
	 * 加载请假单的所有批注
	 */
	@RequestMapping("uploadAllComments")
	@ResponseBody
	public DataGrid uploadAllComments(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAllComments(workFlowVo.getLeavebillId());
	}
	/**
	 * 加载自己所有已办任务
	 */
	@RequestMapping("uploadAllMyTask")
	@ResponseBody
	public DataGrid uploadAllMyTask(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAllMyTask(workFlowVo);
	}
	/**
	 * 跳转到已办任务页面
	 */
	@RequestMapping("toAproveTask")
	public String toAproveTask(WorkFlowVo workFlowVo,Model model) {
		return "system/workFlow/approvalTask";
	}
	/**
	 * 跳转到历史流程表
	 */
	/*@RequestMapping("toHistoryProcess")
	public String toHistoryProcess(WorkFlowVo workFlowVo,Model model) {
		return "system/workFlow/historyProcess";
	}*/
	/**
	 * 加载所有流程
	 */
	/*@RequestMapping("uploadAllProcessDef")
	@ResponseBody
	public DataGrid uploadAllHistoryProcessDef(WorkFlowVo workFlowVo) {
		return workFlowService.uploadAllHistoryProcessDef();
	}*/
}

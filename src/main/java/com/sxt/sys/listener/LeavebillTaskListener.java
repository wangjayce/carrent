package com.sxt.sys.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sxt.sys.domain.User;
import com.sxt.sys.service.UserService;

public class LeavebillTaskListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// 1,得到request
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		// 2.的带session
		HttpSession session = request.getSession();
		// 3.得到用户
		User user = (User) session.getAttribute("user");
		// 4.得到用户领导的id，并查询
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		UserService userService = context.getBean(UserService.class);
		User leaderUser = userService.queryUserById(user.getMgr());
		//设置办理人
		delegateTask.setAssignee(leaderUser.getName()); 

	}

}

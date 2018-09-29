package com.sxt.sys.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ApplicationContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//取出ServletContext
		ServletContext context = servletContextEvent.getServletContext();
		String contextPath = context.getContextPath();
		context.setAttribute("ctx", contextPath);
		System.out.println("ApplicationContextListener--加载成功");
		System.out.println(contextPath);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

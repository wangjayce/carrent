package com.sxt.sys.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sxt.sys.domain.User;

public class SessionUtils {

	public static HttpServletRequest getRequest() {
		// 1,得到request
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}
	
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	public static User getUserInSession(String key) {
		return (User) getSession().getAttribute("user");
	}
	
	public static String getUserNameInSession(String key) {
		return getUserInSession(key).getName();
	}
}

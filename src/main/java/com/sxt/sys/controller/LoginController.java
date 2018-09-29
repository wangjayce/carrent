package com.sxt.sys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.LogInfo;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.utils.ActiverUser;
import com.sxt.sys.utils.TreeNote;
import com.sxt.sys.vo.PermissionVo;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {

	
	@Autowired 
	private PermissionService permissionService;
	@Autowired
	private LogInfoService loginService;
	
	/**
	 * 转发致登陆页面
	 * 
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLogin() {
		return "system/main/login";
	}
	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public String logout() {
		return "system/main/login";
	}

	/**
	 * 登陆
	 * @param userVo
	 * @return
	 */
	@RequestMapping("login")
	public String Login(UserVo userVo,HttpServletRequest request,Model model) {
		String msg = "";
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(userVo.getLoginname(), userVo.getPwd());
		 try {  
		        subject.login(token);  
		        if (subject.isAuthenticated()) {  
		        	ActiverUser user = (ActiverUser) subject.getPrincipal();//subject.getPrincipal();类型就是new SimpleAuthenticationInfo(user
		        	User user1 = user.getCurUser();
		        	request.getSession().setAttribute("user", user.getCurUser());
		        	LogInfo logInfo = new LogInfo();
		        	logInfo.setLoginname(user1.getName()+"-"+user1.getLoginname());
		        	logInfo.setLogintime(new Date());
		        	logInfo.setLoginip(request.getRemoteAddr());
		        	loginService.insert(logInfo);
		            return "system/main/index";  
		        }
		    } catch (IncorrectCredentialsException e) {  
		        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
		        model.addAttribute("error", msg);  
		    } catch (UnknownAccountException e) {  
		        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
		        model.addAttribute("error", msg);  
		    }
	    	return "system/main/login";
	}

	/**
	 * 加载主页导航菜单
	 */
	@RequestMapping("loadIndexTree")
	@ResponseBody
	public List<TreeNote> loadIndexTree(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user.getType()==0){
			PermissionVo permissionVo = new PermissionVo();
			permissionVo.setType("menu");
			permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
			List<TreeNote> list = permissionService.queryPermissionByType(permissionVo);
			return list;
		}else{
			PermissionVo permissionVo = new PermissionVo();
			permissionVo.setType("menu");
			permissionVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
			List<TreeNote> list = permissionService.queryPermissionByType(permissionVo,user.getId());
			return list;
		}
	}
	
	
	
}

package com.sxt.sys.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.ActiverUser;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginname = (String) token.getPrincipal();
		User user  = userService.queryUserByLoginname(loginname);
		if(null!=user) {
			ActiverUser activerUser = new ActiverUser();
			activerUser.setCurUser(user);
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
			//获取用户菜单权限
			List<Permission> menus = permissionService.queryMenuByUserId(user.getId());
			List<String> roles = activerUser.getRoles();
			for (Permission p1 : menus) {
				roles.add(p1.getName());
			}
			//获取用户按钮
			List<Permission> permission =  permissionService.queryPermissionByUserId(user.getId());
			List<String> permissions = activerUser.getPermissions();
			for (Permission p2 : permission) {
				permissions.add(p2.getPercode());
			}
			AuthenticationInfo info = new SimpleAuthenticationInfo(activerUser, user.getPwd(), credentialsSalt, getName());	
			return info;
		}
		return null;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		ActiverUser activerUser = (ActiverUser) principals.getPrimaryPrincipal();
		User user = activerUser.getCurUser();
		if(user.getType()==SYS_Constast.USER_TYPE_SUPER) {
			info.addRole("*");
			info.addStringPermission("*:*");
		}else {
			if(activerUser.getRoles().size()>0) {
				info.addRoles(activerUser.getRoles());
			}
			if(activerUser.getPermissions().size()>0) {
				info.addStringPermissions(activerUser.getPermissions());
			}
		}
		return info;
	}

}

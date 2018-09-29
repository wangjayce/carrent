package com.sxt.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.sys.constast.SYS_Constast;
import com.sxt.sys.domain.Role;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.RoleService;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.utils.Md5Uitls;
import com.sxt.sys.utils.PinyinUtils;
import com.sxt.sys.utils.RandomString;
import com.sxt.sys.vo.RoleVo;
import com.sxt.sys.vo.UserVo;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("toUserManager")
	public String toUserManager() {		
		return "system/user/userManager";
	}
	
	
	@RequestMapping("toUserLeft")
	public String toUserLeft() {		
		return "system/user/userLeft";
	}
	
	
	@RequestMapping("toUserRight")
	public String toUserRight() {		
		return "system/user/userRight";
	}
	@RequestMapping("toaddUser")
	public String addUser() {		
		return "system/user/addUser";
	}
	
	
	
	@RequestMapping("toupdateUser")
	public String updateUser(UserVo userVo,Model model) {
		User user = userService.queryUserById(userVo.getId());
		model.addAttribute("user", user);
		return "system/user/updateUser";
	}
	/**
	 * 重置密码
	 * @param userVo
	 * @param model
	 * @return
	 */
	@RequestMapping("resetUserPwd")
	@ResponseBody
	public Map<String, Object> resetUserPwd(UserVo userVo) {
		Map<String, Object> map = new HashMap<>();
		String salt = RandomString.getNewFileNameUseUUID();
		userVo.setSalt(salt);
		userVo.setPwd(Md5Uitls.encodePwdUseMd5(SYS_Constast.USER_PWD_DEFAULT, salt, 2));
		String msg = "重置失败";
		try {
			int i = userService.updateUser(userVo);
			if(i>0) {
				msg="重置成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	/**
	 * 根据id查询用户
	 * @param userVo
	 * @param model
	 * @return
	 */
	@RequestMapping("queryUserById")
	@ResponseBody
	public User queryUserById(UserVo userVo) {
		return userService.queryUserById(userVo.getId());
	}
	
	/**
	 * 跳转给用户分配角色
	 * @param userVo
	 * @return
	 */
	@RequestMapping("giveUserRole")
	public String giveUserRole(UserVo userVo) {
		return "system/user/giveUserRole";
	}
	
	/**
	 * 给用户分配角色
	 * @param userVo
	 * @return
	 */
	@RequestMapping("saveUserRole")
	@ResponseBody
	public Map<String, Object> saveUserRole(UserVo userVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "分配失败";
		try {
			int i = userService.saveUserRole(userVo);
			if(i>0) {
				msg="分配成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	/**
	 * 加载用户表格数据
	 * @param userVo
	 * @return
	 */
	@RequestMapping("uploadAllUser")
	@ResponseBody
	public DataGrid uploadAllUser(UserVo userVo) {	
		userVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		return userService.queryAllUser(userVo);
	}
	
	/**
	 * 加载所有角色并选中
	 * @param userVo
	 * @return
	 */
	@RequestMapping("uploadAllRole")
	@ResponseBody
	public DataGrid uploadAllRole(UserVo userVo) {
		RoleVo roleVo = new RoleVo();
		roleVo.setAvailable(SYS_Constast.TYPE_AVAILABLE_YES);
		List<Role> allList = roleService.queryAllRoleForList(roleVo);
		List<Role> curList = roleService.queryUserRole(userVo.getId());
		List<RoleVo> roleList = new ArrayList<>();
		for (Role r1 : allList) {
			Boolean LAY_CHECKED = false;
			for (Role r2 : curList) {
				if(r1.getId()==r2.getId()) {
					LAY_CHECKED= true;
				}
			}
			RoleVo vo = new RoleVo();
			BeanUtils.copyProperties(r1, vo);
			vo.setLAY_CHECKED(LAY_CHECKED);
			roleList.add(vo);
		}
		return new DataGrid(Long.valueOf(roleList.size()), roleList);
	}
	
	/**
	 * 根据部门id查询部门的人
	 * @param userVo
	 * @return
	 */
	@RequestMapping("queryAllUserByDeptId")
	@ResponseBody
	public List<User> queryAllUserByDeptId(UserVo userVo) {	
		return userService.queryAllUserByDeptId(userVo);
	}
	
	/**
	 * 将文字解析成拼音
	 * @param userVo
	 * @return
	 */
	@RequestMapping("parseFontForPinyin")
	@ResponseBody
	public String parseFontForPinyin(String name) {	
		return PinyinUtils.getPinYin(name).toLowerCase();
	}
	
	@RequestMapping("addUser")
	@ResponseBody
	public Map<String , Object> addUser(UserVo userVo) {
		String salt = RandomString.getNewFileNameUseUUID();
		userVo.setSalt(salt);
		userVo.setPwd(Md5Uitls.encodePwdUseMd5(SYS_Constast.USER_PWD_DEFAULT, salt, SYS_Constast.TYPE_PUBLIC_TOW));
		userVo.setType(SYS_Constast.USER_TYPE_NORMAL);
		userVo.setImgpath("../resources/images/defaulttitle.jpg");
		Map<String, Object> map = new HashMap<>();
		String msg = "添加失败";
		try {
			int i = userService.insert(userVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	@RequestMapping("updateUser")
	@ResponseBody
	public Map<String , Object> updateUser(UserVo userVo) {
		
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			userVo.setSalt(RandomString.getNewFileNameUseUUID());
			int i = userService.updateUser(userVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public Map<String , Object> deleteUser(UserVo userVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=userVo.getIds()&&userVo.getIds().length>0){
			    i = userService.deleteByPrimaryKey(userVo.getIds());				
			}else {
				i = userService.deleteByPrimaryKey(userVo.getId());				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			msg="删除成功";
		}
		map.put("msg", msg);
		return map;
	}
}

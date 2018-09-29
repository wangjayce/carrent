package com.sxt.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.sys.domain.Notice;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.NoticeService;
import com.sxt.sys.utils.DataGrid;
import com.sxt.sys.vo.NoticeVo;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping("toNoticeManager")
	public String toNoticeManager() {		
		return "system/notice/noticeManager";
	}
	
	
	@RequestMapping("toaddNotice")
	public String addNotice() {		
		return "system/notice/addNotice";
	}
	
	
	@RequestMapping("toupdateNotice")
	public String updateNotice(NoticeVo noticeVo,Model model) {
		Notice notice = noticeService.queryNoticeById(noticeVo.getId());
		model.addAttribute("notice", notice);
		return "system/notice/updateNotice";
	}
	
	@RequestMapping("todetailNotice")
	public String todetailNotice(NoticeVo noticeVo,Model model) {
		Notice notice = noticeService.queryNoticeById(noticeVo.getId());
		model.addAttribute("notice", notice);
		return "system/notice/detailNotice";
	}
	
	
	/**
	 * 加载公告表格数据
	 * @param noticeVo
	 * @return
	 */
	@RequestMapping("uploadAllNotice")
	@ResponseBody
	public DataGrid uploadAllNotice(NoticeVo noticeVo) {	
		return noticeService.queryAllNotice(noticeVo);
	}
	
	@RequestMapping("queryAllNotice")
	@ResponseBody
	public List<Notice> queryAllNotice() {	
		return noticeService.queryAllNotice();
	}
	/**
	 * 图片上传
	 * @param noticeVo
	 * @return
	 */
	@RequestMapping("uploadimage")
	@ResponseBody
	public Map<String, Object> uploadimage(@Param("file")MultipartFile file,HttpServletRequest request) {	
		//String path = request.getServletContext().getRealPath("myimage");
		String path = "/usr/nginx/bjsxt/bjsxt/myimage/";
		String oldName = file.getOriginalFilename();
		File dir = new File(path);
		System.out.println(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file1 = new File(dir,oldName);
		try {
			file.transferTo(file1);
			Map<String, Object> data = new HashMap<>();
			data.put("src", "../myimage/"+oldName);
			data.put("title", oldName);
			Map<String, Object> map = new HashMap<>();
			 map.put("code",0);//0表示成功，1失败
	        map.put("msg","上传成功");//提示消息
	        map.put("data",data);
			return map;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("addNotice")
	@ResponseBody
	public Map<String , Object> addNotice(NoticeVo noticeVo,HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		User user = (User) session.getAttribute("user");
		String msg = "添加失败";
		noticeVo.setCreatetime(new Date());
		noticeVo.setOpername(user.getName());
		try {
			int i = noticeService.insert(noticeVo);
			if(i>0) {
				msg="添加成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("updateNotice")
	@ResponseBody
	public Map<String , Object> updateNotice(NoticeVo noticeVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "修改失败";
		try {
			int i = noticeService.updateNotice(noticeVo);
			if(i>0) {
				msg="修改成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("msg", msg);
		return map;
	}
	@RequestMapping("deleteNotice")
	@ResponseBody
	public Map<String , Object> deleteNotice(NoticeVo noticeVo) {
		Map<String, Object> map = new HashMap<>();
		String msg = "删除失败";
		int i = 0 ;
		try {
			if(null!=noticeVo.getIds()&&noticeVo.getIds().length>0){
			    i = noticeService.deleteByPrimaryKey(noticeVo.getIds());				
			}else {
				i = noticeService.deleteByPrimaryKey(noticeVo.getId());				
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

package com.sxt.bus.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.sys.utils.RandomString;

@Controller
@RequestMapping("upload")
public class UploadController {

	/**
	 * 图片上传
	 */
	@RequestMapping("uploadImage")
	@ResponseBody
	public Map<String, Object> uploadImage(MultipartFile mf,HttpServletRequest request,String imgname) {
		//String path = request.getServletContext().getRealPath("upload");
		String path = "/usr/nginx/bjsxt/bjsxt/upload/";
		String oldName = mf.getOriginalFilename();
		String newName = RandomString.getNewFileNameUseTime(oldName);
		if(!imgname.equals("")) {
		    newName = newName+"_"+imgname;
		}
		String dirName = RandomString.getDirName();
		File dir = new File(path, dirName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, newName);
		System.out.println(dir);
		try {
			mf.transferTo(file);
			Map<String, Object> data = new HashMap<>();
			data.put("src", "../upload/"+dirName+"/"+newName);
			data.put("title", imgname);
			Map<String, Object> map = new HashMap<>();
			 map.put("code",0);//0表示成功，1失败
	        map.put("msg","上传成功");//提示消息
	        map.put("data",data);
	        return map;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}

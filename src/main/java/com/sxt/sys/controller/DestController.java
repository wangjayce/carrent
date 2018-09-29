package com.sxt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("desk")
public class DestController {

	@RequestMapping("toDeskManager")
	public String toDeskManager() {
		
		return "system/main/main";
	}
}

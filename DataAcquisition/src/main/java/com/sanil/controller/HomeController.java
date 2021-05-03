package com.sanil.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("home")
	public String home()
	{
		
		return "home";
	}
	
	@RequestMapping("add/student")
	public String add_student()
	{
		
		return "add_student";
	}
	
	@RequestMapping("view/student")
	public String view_student()
	{
		
		return "view_student";
	}


}

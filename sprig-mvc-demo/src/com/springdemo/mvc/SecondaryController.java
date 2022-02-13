package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondaryController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "wave-user";
	}

}

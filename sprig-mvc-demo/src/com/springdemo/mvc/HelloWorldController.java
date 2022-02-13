package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// show form to get user details
	@RequestMapping("/showForm")
	public String showForm() {
		return "get-user";
	}

	// show form to welcome user
	@RequestMapping("/processForm")
	public String processForm() {
		return "welcome-user";
	}

	// add method to read form data and add model
	@RequestMapping("/shoutOut")
	public String shoutOut(HttpServletRequest request, Model model) {

		// reading form data
		String userName = request.getParameter("studentName");

		// convert case
		userName=userName.toUpperCase();

		// form message
		String result = "We are excited to have you " + userName + "!!!!";

		// add data to model
		model.addAttribute("message", result);

		return "welcome-user";

	}
	
	// add method to read form data and add model
		@RequestMapping("/greetuser")
		public String greetuser(@RequestParam("studentName") String userName, Model model) {

			// convert case
			userName=userName.toUpperCase();

			// form message
			String result = "We are happy to have you " + userName + "!!!!";

			// add data to model
			model.addAttribute("message", result);

			return "welcome-user";

		}
}

package com.springdemo.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{courseid}")
	private Map<String, String> courseList;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create student object
		Student theStudent = new Student();
		
		//add student obj to model attribute
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("theCourseList", courseList);
		
		System.out.println("Student object created in showForm: "+theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println("Student object created in processForm: "+theStudent);
		
		return "student-confirmation";
	}

}

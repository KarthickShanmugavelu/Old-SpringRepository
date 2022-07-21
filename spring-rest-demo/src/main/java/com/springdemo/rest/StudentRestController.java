package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//define endpoint /students
	@GetMapping("/students")
	public List<Student> sendStudentList(){
		
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Karthick","Shanmugavelu"));
		theStudents.add(new Student("Naveen","Kumar"));
		theStudents.add(new Student("Deepak","Anand"));
		theStudents.add(new Student("Keerthi","Perumal"));
		theStudents.add(new Student("Arun","Sezhian"));
		theStudents.add(new Student("Aswath","Subramani"));
		theStudents.add(new Student("Vishnu","Menon"));
		
		return theStudents;
	}
	
	
	
}

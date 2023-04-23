package com.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// inject DAO here as of now
	@Autowired
	EmployeeService employeeService;

	// expose "/employees"
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {

		return employeeService.findAll();

	}

	// get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {

		Employee theEmployee = employeeService.findEmployeeById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id '" + employeeId + "' not found.");
		}

		return theEmployee;
	}

	// insert employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// if user passes an id by mistake remove it so that saveOrUpdate method will
		// insert the record since there's no id
		theEmployee.setId(0);

		employeeService.save(theEmployee);

		return theEmployee;
	}

	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		employeeService.save(theEmployee);

		return theEmployee;

	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findEmployeeById(employeeId);
		if(theEmployee == null)
			throw new RuntimeException("Employee id '"+employeeId+"' unavailable in system");
		employeeService.deleteEmployeeById(employeeId);
		return "Employee id '"+employeeId+"' is deleted";
		
	}

}

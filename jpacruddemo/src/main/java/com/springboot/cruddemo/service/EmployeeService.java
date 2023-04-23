package com.springboot.cruddemo.service;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findEmployeeById(int theId);

	public void save(Employee theEmployee);

	public void deleteEmployeeById(int theId);

}

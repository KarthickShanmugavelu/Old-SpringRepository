package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDAOJpaImpl")
	EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int theId) {

		return employeeDAO.findEmployeeById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {

		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteEmployeeById(int theId) {

		employeeDAO.deleteEmployeeById(theId);

	}

}

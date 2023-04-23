package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent())
				theEmployee=result.get();
		else
			throw new RuntimeException("Employee id '"+theId+"' not found.");
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteEmployeeById(int theId) {

		employeeRepository.deleteById(theId);

	}

}

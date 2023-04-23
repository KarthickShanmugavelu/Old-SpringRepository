package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employeeList = theQuery.getResultList();
		
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee); //insert or update and return the updated or inserted record
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteEmployeeById(int theId) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}

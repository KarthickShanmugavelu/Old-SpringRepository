package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity Manager
	private EntityManager entityManager;

	// do constructor injection for EmployeeDAOHibernateImpl with EntityManager
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query
		List<Employee> employeeList = theQuery.getResultList();

		// return the result list
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int theId) {
		
		//create session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// create session
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteEmployeeById(int theId) {
		//create session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create Query
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);//set Param
		
		//execute query
		theQuery.executeUpdate();
		
	}

}

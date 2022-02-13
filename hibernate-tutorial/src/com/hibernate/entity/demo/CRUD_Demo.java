package com.hibernate.entity.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUD_Demo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		String dateOfJoining = "29/10/2021";

		try {
			// begin transaction
			session.beginTransaction();
			Date dojDate = DateUtils.parseDate(dateOfJoining);

			// creating objs
			Employee employee = new Employee("Ram", "Maran", "Google Inc.", dojDate);
			Employee employee1 = new Employee("Gil", "Phil", "Microsoft", dojDate);
			Employee employee2 = new Employee("Brad", "Pitt", "Apple", dojDate);
			Employee employee3 = new Employee("Trump", "Donald", "Accenture", dojDate);
			Employee employee4 = new Employee("Gimp", "Jason", "Tech Mhindra", dojDate);

			// insert
			System.out.println("*********Inserting**********");
			session.save(employee);
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		// read

	}

}

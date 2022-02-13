package com.hibernate.entity.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create sesion factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// begin transaction
			session.beginTransaction();
			
			//create a student list by querying student
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(studentList);
			
			//trying other kind of queries.
			studentList = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			
			//display students
			System.out.println("Query with Conditions output");
			displayStudents(studentList);
			
			//or condition
			studentList = session.createQuery("from Student s where s.firstName='nac' or "
					+ "s.lastName='dhamo'").getResultList();
			System.out.println("OR Condition");
			displayStudents(studentList);
			
			//end transaction
			session.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> studentList) {
		for(Student student:studentList) {
			
			System.out.println(student);
		}
	}

}

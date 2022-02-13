package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//get session.
		Session session = factory.getCurrentSession();
		
		try {
		//create a student obj
		System.out.println("Create a student obj");
		Student student = new Student("Paul", "Walker", "paul@gmail.com");
		
		//begin transaction
		session.beginTransaction();
		
		//save obj
		System.out.println("Saving object");
		session.save(student);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Inserted into DB!!!");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}

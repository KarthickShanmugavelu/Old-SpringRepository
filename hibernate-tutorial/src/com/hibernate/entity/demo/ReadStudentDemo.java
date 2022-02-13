package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student student = new Student("Kamal", "Hassan", "kamal@gmail.com");

			session.beginTransaction();

			session.save(student);

			System.out.println("Session: " + session);

			session.getTransaction().commit();

			session = factory.getCurrentSession();

			Student student1 = new Student("Tom", "Holland", "tom@gmail.com");

			session.beginTransaction();

			session.save(student1);

			System.out.println("Session: " + session);

			session.getTransaction().commit();

			System.out.println("Session after commit: " + session);

			// Reading saved object // find out the primary key
			System.out.println("Student id generated: " + student.getId());

			// get a new session 
			session = factory.getCurrentSession();

			// start a transaction 
			session.beginTransaction();

			// retrieve student based on primary key 
			Student tempStudent =session.get(Student.class, student.getId());
			System.out.println("Record retrieved: " + tempStudent);

			// commit transaction 
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}

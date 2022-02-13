package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//declare pkey
			int stid=2;
			
			//begintransaction
			session.beginTransaction();
			
			//get student
			Student student=session.get(Student.class, stid);
			
			//update value
			student.setFirstName("Chris");
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("*************Update Complete***************");
			
			//bulk update using query
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student s set email='chris@gmail.com' where s.firstName='Chris'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("*************Update using query is Complete***************");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		

		
	}

}

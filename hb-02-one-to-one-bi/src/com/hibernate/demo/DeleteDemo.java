package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//create obj
			Instructor instructor = session.get(Instructor.class, 2);
			
			//delete Instructor it deletes InstructorDetail coz of CASACDETYPE.ALL
			session.update(instructor);
			System.out.println("**************DELETED***********");
			
			//commit transaction
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		
	}

}

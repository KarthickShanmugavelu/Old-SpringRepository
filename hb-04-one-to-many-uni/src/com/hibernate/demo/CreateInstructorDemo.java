package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//create Instructor obj
			//Instructor instructor = new Instructor("Thomas", "Shelby", "tommy@shelbyLtd.com");
			
			//create Instructor detail obj
			InstructorDetail instructorDetail = new InstructorDetail("Shelby Company Limited", "Hunting");
			
			//inserting
			System.out.println("**********INSERTING************");
			session.save(instructorDetail);
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.setInstructorDetail(instructorDetail);
			session.update(instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		finally {
			//CLOSE CONN
			session.close();
			
			//close factory
			factory.close();
		}
		
		
	}

}

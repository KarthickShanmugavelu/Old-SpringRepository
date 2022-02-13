package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailOnlyDemo {
	
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
			
			//get the instructor detail obj
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			
			//print instructor detail
			System.out.println("Instructor detail: "+instructorDetail);
			
			//print corresponding instructor
			Instructor instructor = instructorDetail.getInstructor();
			System.out.println("Associated instructor: "+instructor);
			
			//break the relationship between instructor and intructor detail in instructor class
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			//deleting 
			session.delete(instructorDetail);
			System.out.println("***********DELETED***********");
			
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

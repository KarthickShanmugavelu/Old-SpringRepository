package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//create instructor obj
			Instructor instructor = session.get(Instructor.class, 1);
			
			//print objs
			System.out.println("My Application: Instructor details: "+instructor);
			
			//In Lazy loading data cannot be loaded after session is closed.
			//To overcome this, data can be loaded when session is open then can be used in future after session is closed.
			System.out.println("My Application: Loadig lazy load data before closing session: "+instructor.getCourse());
			
			//commit transaction
			session.getTransaction().commit();
			
			//closing session
			session.close();
			
			//accessing lazily loaded data after session is closed
			System.out.println("\n*********accessing lazily loaded data after session is closed*********\n");
			System.out.println("My Application: "+instructor.getCourse());
			
			
		}catch(Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		finally {
			//CLOSE CONN
			//session.close();
			
			//close factory
			sessionFactory.close();
		}
		
	}

}

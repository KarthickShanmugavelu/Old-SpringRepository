package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//create course obj
			Course course = session.get(Course.class, 10);
			
			//delete records
			session.delete(course);
			
			System.out.println("Deleted");
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}
		finally {
			//CLOSE CONN
			session.close();
			
			//close factory
			sessionFactory.close();
		}
		
	}

}

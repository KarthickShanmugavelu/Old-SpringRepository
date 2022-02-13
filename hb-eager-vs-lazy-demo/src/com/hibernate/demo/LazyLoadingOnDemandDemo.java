package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class LazyLoadingOnDemandDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//get instructor obj
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("Instructor: "+instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close session
			session.close();
			
			System.out.println("Dummy statement 1\n");
			System.out.println("Dummy statement 2\n");
			System.out.println("Dummy statement 3\n");
			System.out.println("Dummy statement 4\n");
			
			//
            // THIS HAPPENS SOMEWHERE ELSE / LATER IN THE PROGRAM
            // YOU NEED TO GET A NEW SESSION
            //
			
			System.out.println("\n\nluv2code: Opening a NEW session \n");
            session = sessionFactory.getCurrentSession();
            
            session.beginTransaction();
            
            //get courses for a given instructor
            Query<Course> query = session.createQuery("select c from Course c where c.instructor.id = 1");
            
            List<Course> courseList= query.getResultList();
            
            //now assign retrieved course to instructor object in memory
            instructor.setCourse(courseList);
            
            //print course
            System.out.println("Courses: "+instructor.getCourse());
            
            //commit
            session.getTransaction().commit();
            
            //close session
            session.close();
            
			
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		} finally {
			
			// close factory
			sessionFactory.close();
		}

	}

}

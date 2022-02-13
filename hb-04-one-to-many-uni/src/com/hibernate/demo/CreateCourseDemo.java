package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
			//create course objs
			Course course1 = new Course("Klingon - The Ultimate Guide");
			Course course2 = new Course("The Tabla MasterClass");
			
			System.out.println("Course 1 obj addr in main: "+course1.hashCode());
			System.out.println("Course 2 obj addr in main: : "+course2.hashCode());
			
			//add course to instructors
			Instructor instructor = session.get(Instructor.class, 1);
			instructor.addCourses(course1);//obj is passed to set instructor id
			instructor.addCourses(course2);
			
			//System.out.println("Course 1 Intructor id after addition: "+course1.getInstructor().getId());
			//System.out.println("Course 2 Intructor id after  addition: "+course2.getInstructor().getId());
			
			//insert course
			System.out.println("*****************INSERTING*************");
			System.out.println();
			session.save(course1);
			session.save(course2);
			
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

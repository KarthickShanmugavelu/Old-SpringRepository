package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure()
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//create course objs
			Course course1 = new Course("Spanish - The Ultimate Guide");
			
			//create students
			Student student1 = new Student("Gaudeep", "Arora", "gau@gmail.com");
			session.save(student1);
			
			//add students to course
			course1.addStudents(student1);
			
			//save course
			session.save(course1);
			
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
			sessionFactory.close();
		}
	}

}

package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class DeleteCourseOnlyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// begin transaction
			session.beginTransaction();

			//get a course
			Course course = session.get(Course.class, 15);
			System.out.println("Deleting course....");
			session.delete(course);

			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		} finally {
			// CLOSE CONN
			session.close();

			// close factory
			sessionFactory.close();
		}
	}

}

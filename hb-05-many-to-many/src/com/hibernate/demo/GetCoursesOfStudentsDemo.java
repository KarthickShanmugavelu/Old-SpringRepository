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

public class GetCoursesOfStudentsDemo {

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

			// get student
			Student student = session.get(Student.class, 3);
			System.out.println("\n\n\n\t\t\t\t\t!!!!!!!!STUDENT AND THEIR COURSES!!!!!!!");
			System.out.println(student + "--------->" + student.getCourses());

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

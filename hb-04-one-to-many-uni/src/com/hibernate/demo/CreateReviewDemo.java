package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateReviewDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// begin transaction
			session.beginTransaction();

			// create course obj
			Course course = new Course("The Badminton Course");

			// add review
			course.addReview(new Review("What a wonderful course!!!"));
			course.addReview(new Review("This is an extraordinary course!!!"));
			course.addReview(new Review("Such a fantastic course!!!"));
			course.addReview(new Review("This course sucks"));

			// inserting
			session.save(course);
			System.out.println("Inserted");

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

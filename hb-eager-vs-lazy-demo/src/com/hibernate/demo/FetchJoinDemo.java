package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// begin transaction
			session.beginTransaction();

			// Accessing LAZY data using HQL
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses where i.id=:theInstructorId",
					Instructor.class);
			query.setParameter("theInstructorId", 1);
			Instructor instructor = query.getSingleResult();

			// print objs
			System.out.println("My Application: Instructor details: " + instructor);

			// commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			//accessing data after session is closed
			System.out.println("My Application: "+instructor.getCourse());

		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!!EXCEPTION OCCURED :( !!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		} finally {
			// CLOSE CONN
			//session.close();

			// close factory
			sessionFactory.close();
		}

	}

}

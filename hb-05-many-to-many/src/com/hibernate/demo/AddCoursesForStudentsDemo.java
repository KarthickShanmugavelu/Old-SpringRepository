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

public class AddCoursesForStudentsDemo {

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
			Student student = session.get(Student.class, 2);
			System.out.println(student + "--------->" + student.getCourses());
			
			//create courses
			Course course1 = new Course("Hindi - Beginner to Pro");
			Course course2 = new Course("The Web Development MasterClass");
			
			//add courses to students
			course1.addStudents(student);
			course2.addStudents(student);
			
			//save courses.
			session.save(course1);
			session.save(course2);
			System.out.println("\n\n\n\t\t\t\t\t!!!!!!!!New Courses insterted and mapped to student!!!!!!!");

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

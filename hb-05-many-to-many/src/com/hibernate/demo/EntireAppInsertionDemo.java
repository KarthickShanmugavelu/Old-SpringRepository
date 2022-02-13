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

public class EntireAppInsertionDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {

			/*
			 * // begin transaction session.beginTransaction();
			 * 
			 * // create instructor Instructor instructor = new Instructor("Arthur",
			 * "Shelby", "arthur@gmail.com");
			 * 
			 * // create instructor detail InstructorDetail instructorDetail = new
			 * InstructorDetail("Shelby Company Limited", "Hunting");
			 * instructor.setInstructorDetail(instructorDetail);
			 * session.save(instructorDetail);
			 * System.out.println("\n\n********Instructor detail Inserted*******\n\n");
			 * 
			 * // create course Course course = new
			 * Course("Car & Weapons Merchandise - The Ultimate Guide");
			 * 
			 * // create reviews Review rev1 = new Review("Awesome course"); Review rev2 =
			 * new Review("Fantastic Course :) !!!");
			 * 
			 * // create students Student stu1 = new Student("Karnak", "Chahar",
			 * "kar@gmail.com"); Student stu2 = new Student("Naveen", "Chmbak",
			 * "nvn@gmail.com"); session.save(stu1); session.save(stu2);
			 * System.out.println("\n\n********Students Inserted*******\n\n");
			 * 
			 * // map course and reviews course.addReview(rev1); course.addReview(rev2);
			 * System.out.println("\n\n********Mapped Course and Review*******\n\n");
			 * 
			 * // map course and students course.addStudents(stu1);
			 * course.addStudents(stu2);
			 * System.out.println("\n\n********Mapped Course and Students*******\n\n");
			 * 
			 * // course.setInstructor(instructor); session.save(course);
			 * System.out.println("\n\n********Course Inserted*******\n\n");
			 * 
			 * // mapping course and instructor instructor.addCourses(course);
			 * System.out.println("\n\n********Mapped Course and instructor*******\n\n");
			 * 
			 * // insert instructor session.save(instructor);
			 * System.out.println("\n\n********Instructor Inserted*******\n\n");
			 * 
			 * // commit transaction session.getTransaction().commit();
			 * 
			 * session.close();
			 * 
			 */
			
			
			// printing all inserts session = sessionFactory.getCurrentSession();
			
			//begin transaction
			session.beginTransaction();
			
			System.out.println("\n\n\t\t\t\t************INSTRUCTOR AND INSTRUCTOR DETAIL**************\n\n");
			Instructor instructor2 = session.get(Instructor.class, 1);
			System.out.println("Instructor: \n"+instructor2+"Instructor Detail: \n"+instructor2.getInstructorDetail());

			System.out.println("\n\n\t\t\t\t************COURSE AND COURSE DETAILS**************\n\n");
			System.out.println("Courses: \n\n"); 
			List <Course> courseList = instructor2.getCourse();
			for(Course tempCourse: courseList) {
				System.out.println("\n\n\n\nCourse: "+tempCourse);
				System.out.println("\n\n\nReview of Course: "+tempCourse.getReviews());
				System.out.println("\n\n\nStudents of that Course: "+tempCourse.getStudents());
			}

			//commit transaction
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

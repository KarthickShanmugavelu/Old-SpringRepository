package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//get session.
		Session session = factory.getCurrentSession();
		
		try {
		
			//create objs
			Instructor instructor = new Instructor("Tommy","Shelby","tommy@ShelbyCompanyLtd.com");
			InstructorDetail instructorDetail = new InstructorDetail("Automobiles", "Guns");
			
			//asociate 2 objs
			instructor.setInstructorDetail(instructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save objs & when u save Instructor, instructor detail also gets saved coz of CASCADETYPE.ALL
			session.save(instructorDetail);
			session.save(instructor);
			System.out.println("********INSERTED*********");
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

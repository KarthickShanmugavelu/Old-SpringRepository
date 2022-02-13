package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating objs");
			Student student1 = new Student("naveen", "kumar", "nvn@gmail.com");
			Student student2 = new Student("karthick", "velu", "kar@gmail.com");
			Student student3 = new Student("vishnu", "menon", "vmn@gmail.com");
			Student student4 = new Student("kpd", "dhamo", "kpd@gmail.com");
			Student student5 = new Student("nac", "cel", "nac@outlook.com");

			System.out.println("begin transac ");
			session.beginTransaction();

			System.out.println("save");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.save(student5);
			
			System.out.println("commit");
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			
			factory.close();

		}

	}

}

package com.hibernate.entity.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			//delete record using delete method
			Student student = session.get(Student.class, 2);
			session.delete(student);
			System.out.println("***************Deleteing using method complete***************");
			
			//delete record using query
			session.createQuery("delete from Student where firstName='Paul'").executeUpdate();
			System.out.println("***************Deleteing using query complete***************");
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}

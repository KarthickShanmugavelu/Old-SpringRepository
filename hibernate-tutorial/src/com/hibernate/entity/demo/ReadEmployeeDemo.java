package com.hibernate.entity.demo;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			Employee employee=session.get(Employee.class, 2);
			
			System.out.println("Read using get method: "+employee);
			
			List<Employee> employeeList = session.createQuery("from Employee").getResultList();
			
			for( Employee empl: employeeList) {
				
				System.out.println("Read using query method: "+empl);
				
			}

			// commit transaction 
			session.getTransaction().commit();
			
			/*
			 * //update session=factory.getCurrentSession(); session.beginTransaction();
			 * Employee emp=session.get(Employee.class, 2);
			 * emp.setFirstName("Kamal");emp.setLastName("Hassan");
			 * session.getTransaction().commit();
			 * System.out.println("Update using method completed"); //update
			 * session=factory.getCurrentSession(); session.beginTransaction();
			 * session.createQuery("update Employee set company='Tech Mahindra'").
			 * executeUpdate(); //emp = session.get(Employee.class, 3);
			 * //emp.setCompany("Accenture");
			 * System.out.println("Update using query completed");
			 * session.getTransaction().commit();
			 */

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}

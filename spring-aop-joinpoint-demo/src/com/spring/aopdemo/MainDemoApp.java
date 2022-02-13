package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//app config context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get comp
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account temp = new Account();
		temp.setName("Kumar");
		temp.setLevel("Admin");
		
		//call method
		theAccountDAO.addAccount(temp,false);
		theAccountDAO.provideAccess();
		
		//close context
		context.close();
		
	}

}

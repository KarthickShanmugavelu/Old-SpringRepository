package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//app config context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get comp
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find account
		Boolean tripWire = true;
		List<Account> accountList = null;
		try{
			accountList=theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e) {
			System.out.println("Catching the simulated Exception '"+e+"' thrown in main  application");
		}
		System.out.println("Printing result of findAccounts() in Main Program:\n"+accountList);
		
		
		//close context
		context.close();
		
	}

}

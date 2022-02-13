package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		//get bean
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach=context.getBean("myCoach",Coach.class);
		
		//compare reference
		boolean flag= (theCoach==alphaCoach);
		
		System.out.println("Address of theCoach: "+ theCoach);
		System.out.println("Address of alphaCoach: "+ alphaCoach);
		System.out.println("Both are using same instance: "+flag);
		
		//close
		context.close();
		
	}

}

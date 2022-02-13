package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
		
		//get bean
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call method
		System.out.println(theCoach.getDailyFortune());
		
		//close
		context.close();
		
	}

}

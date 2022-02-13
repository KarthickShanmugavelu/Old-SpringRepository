package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		//call methods from the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call dependant method
		System.out.println(theCoach.getDailyFortune());
		
		//close bean
		context.close();

	}

}

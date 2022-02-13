package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		//load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get beans from config file
		CricketCoach theCoach1 = context.getBean("myCricketCoach",CricketCoach.class);
		
		//call methods in Bean
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach1.getDailyFortune());
		
		//calling methods with values injected in fields
		System.out.println(theCoach1.getTeam());
		System.out.println(theCoach1.getEmailAddress());
		
		//calling methods to print values obtained from properties file.
		System.out.println(theCoach1.getCaptain());
		System.out.println(theCoach1.getViceCaptain());
		
		//close context
		context.close();
	}

}

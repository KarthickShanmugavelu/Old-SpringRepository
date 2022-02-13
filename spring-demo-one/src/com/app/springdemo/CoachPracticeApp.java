package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoachPracticeApp {

	public static void main(String[] args) {

		//load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//getBean
		BatmintonCoach batmintonCoach = context.getBean("myBatmintonCoach",BatmintonCoach.class);
		
		//call method
		System.out.println(batmintonCoach.getDailyWorkout());
		System.out.println(batmintonCoach.getDailyFortune());
		
		//close context
		context.close();
		
	}

}

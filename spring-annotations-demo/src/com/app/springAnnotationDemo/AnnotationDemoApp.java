package com.app.springAnnotationDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// load config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean
		Coach theCoach = context.getBean("runningCoach",Coach.class);
		RunningCoach theCoach1 = context.getBean("runningCoach",RunningCoach.class);
		
		//call method
		/*
		 * System.out.println(theCoach.getDailyWarmUp());
		 * System.out.println(theCoach.getDailyFortune());
		 * System.out.println(theCoach1.getOtherFortune());
		 * System.out.println(theCoach1.getSpanishFortune());
		 * System.out.println("Team: "+theCoach1.team+"  Captain: "+theCoach1.captain);
		 */
		System.out.println("Calling file fortune started");
		System.out.println(theCoach1.getDatabaseFortuneService());
		System.out.println("Calling file fortune started");
		
		//close context
		context.close();

	}

}

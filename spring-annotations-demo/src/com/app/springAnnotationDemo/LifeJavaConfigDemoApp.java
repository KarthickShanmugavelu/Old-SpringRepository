package com.app.springAnnotationDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeJavaConfigDemoApp {

	public static void main(String[] args) {
		// reading java config close
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//retrieving beans from context
		Coach theCoach = context.getBean("lifeCoach",Coach.class);
		LifeCoach theCoach1 = context.getBean("lifeCoach",LifeCoach.class);
		  
		//calling methods using bean
		System.out.println(theCoach.getDailyWarmUp());
		System.out.println(theCoach.getDailyFortune());
		
		//getting values from properties file.
		System.out.println(theCoach1.getCaptain());
		System.out.println(theCoach1.getTeam());
		  
		//close context 
		context.close();
		 
		
		
		

	}

}

package com.app.springAnnotationDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// reading java config close
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		//retrieving beans from context
		
		  Coach theCoach = context.getBean("cricketCoach",Coach.class); Coach
		  alphaCoach = context.getBean("cricketCoach",Coach.class);
		  
		  //checking scope
		  
		  boolean flag = (theCoach==alphaCoach); System.out.println(theCoach);
		  System.out.println(alphaCoach); System.out.println(flag);
		  System.out.println(theCoach.getDailyFortune());
		  
		  //close context 
		  context.close();
		 
		
		
		

	}

}

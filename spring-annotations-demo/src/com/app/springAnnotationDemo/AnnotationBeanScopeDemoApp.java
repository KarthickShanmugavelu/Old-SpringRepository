package com.app.springAnnotationDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// creating app context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
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

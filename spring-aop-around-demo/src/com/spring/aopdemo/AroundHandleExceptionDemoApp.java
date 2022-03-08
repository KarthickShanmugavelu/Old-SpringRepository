package com.spring.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.aop.TargetClassAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//private static Logger myLogger2 = Logger.getLogger(AroundDemoApp.class.getName());
		
		//app config context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Inside Main App\n");
		
		myLogger.info("Calling get fortune Method\n");
		
		boolean tripWire=false;
		myLogger.info("Today's traffic fortune: "+theFortuneService.getFortune(tripWire)+"\n");
		
		myLogger.info("Finished main app excution");
		
		//close context
		context.close();
		
	}

}

package com.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;
@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() ||forServicePackage() ||forDaoPackage()")
	private void AppFlow() {}
	
	//add @Before advice
	@Before("AppFlow()")
	public void before(JoinPoint theJoinPoint){
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toString();
		myLogger.info(" =====> Inside Method : "+theMethod+" <=====");
		
		//display its arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object param:args) {
			myLogger.info(" ======> Argumet passed for above Method : "+param+" <======");
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="AppFlow()",returning="theResult")
	public void after(JoinPoint theJoinPoint,Object theResult) {
		
		String method = theJoinPoint.getSignature().toString();
		myLogger.info(" =====>Method : '"+method+"' execution completed <=====");
		myLogger.info(" ======>The above method returned : '"+theResult+"' <======");
		
	}

}

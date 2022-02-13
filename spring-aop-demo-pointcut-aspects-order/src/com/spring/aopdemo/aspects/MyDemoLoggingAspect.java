package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	//create aspects for getters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	
	//create pointcut for setters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	//create pointcut for all methods in package except getters and setters
	@Pointcut("forDaoPackage() && !( getter() || setter() )")
	private void allMethodsExceptGettersAndSetters() {
		
	}
	
	
	
	@Before("allMethodsExceptGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>Executing @Before advice for public add*()<=====\n");
	}
	
	@Before("allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		System.out.println("====>Performing API analytics<====\n");
	}
	
	

}

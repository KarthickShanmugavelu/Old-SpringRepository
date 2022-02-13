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
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>Executing @Before advice for public add*()<=====\n");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		System.out.println("====>Performing API analytics<====\n");
	}

}

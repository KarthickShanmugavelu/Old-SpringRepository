package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("execution(* com.spring.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>Executing @Before advice for public add*()<=====\n");
	}

}

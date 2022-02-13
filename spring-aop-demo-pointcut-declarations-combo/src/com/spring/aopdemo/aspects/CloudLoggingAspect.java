package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudLoggingAspect {
	
	@Before("com.spring.aopdemo.aspects.AopExpressions.allMethodsExceptGettersAndSetters()")
	public void logToCloudAsync() {
		System.out.println("====>Logging to cloud in async fashion<====\n");
	}

}

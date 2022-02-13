package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {
	
	@Before("com.spring.aopdemo.aspects.AopExpressions.allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		System.out.println("====>Performing API analytics<====\n");
	}

}

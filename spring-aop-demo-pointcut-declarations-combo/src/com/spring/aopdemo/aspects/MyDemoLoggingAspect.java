package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	@Before("com.spring.aopdemo.aspects.AopExpressions.allMethodsExceptGettersAndSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>Executing @Before advice for methods<=====\n");
	}

}

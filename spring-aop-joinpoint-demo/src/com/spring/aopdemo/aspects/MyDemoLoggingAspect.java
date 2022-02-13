package com.spring.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

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
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("=====>Executing @Before advice for all methods except getter and setters*()<=====\n");
		
		//display method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature: "+theMethodSignature);
		
		//display method args
		int count=1;
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg:args) {
			System.out.println("Argument "+count+": "+tempArg);
			if(tempArg instanceof Account) {
				Account tempAcct = (Account) tempArg;
				System.out.println("Account name: "+tempAcct.getName());
				System.out.println("Account level: "+tempAcct.getLevel());
			}
		}
		
	}
	
	@Before("allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		System.out.println("====>Performing API analytics<====\n");
	}
	
	

}

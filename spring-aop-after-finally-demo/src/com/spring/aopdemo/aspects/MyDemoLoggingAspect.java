package com.spring.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	// create aspects for getters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	private void getter() {

	}

	// create pointcut for setters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	private void setter() {

	}

	// create pointcut for all methods in package except getters and setters
	@Pointcut("forDaoPackage() && !( getter() || setter() )")
	private void allMethodsExceptGettersAndSetters() {

	}

	@Before("allMethodsExceptGettersAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("=====>Executing @Before advice for all methods except getter and setters*()<=====\n");

		// display method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature: " + theMethodSignature);

		// display method args
		int count = 1;
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			System.out.println("Argument " + count + ": " + tempArg);
			if (tempArg instanceof Account) {
				Account tempAcct = (Account) tempArg;
				System.out.println("Account name: " + tempAcct.getName());
				System.out.println("Account level: " + tempAcct.getLevel());
			}
		}

	}

	@Before("allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		System.out.println("\n====>Performing API analytics<====\n");
	}

	// advice for after return
	@AfterReturning(pointcut = "execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningAdviceForFindAccounts(JoinPoint theJoinPoint, List<Account> result) {

		// print the method name which we are advising
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>Applying after returning advice to method: " + method+"=====>\n");

		// print results
		System.out.println("Before applying advice: " + result);

		convertAccountToUpperCase(result);

		System.out.println("After applying advice: " + result);

	}

	private void convertAccountToUpperCase(List<Account> result) {

		for (Account temp : result) {
			String acctName = temp.getName().toUpperCase();
			String tempLevel = temp.getLevel().toUpperCase();
			temp.setName(acctName);
			temp.setLevel(tempLevel);

		}

	}
	
	//aspect for afterthrow
	@AfterThrowing(pointcut="execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingAdviceForFindAccounts(JoinPoint theJoinPoint,Exception theExc) {
		
		System.out.println("\n=====>Applying AfterThrowing advice for method: "+theJoinPoint.getSignature().toShortString()+"=====>\n");
		
		System.out.println("Processing the exception '"+theExc+"' thrown inside advice");
		
	}
	
	@After("execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdviceForFindAccounts(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>Applying After(finally) advice for method: "+theJoinPoint.getSignature().toShortString()+"=====>\n");
		
	}
	
	
	  @Around("execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	  public void aroundAdviceForFindAccounts(JoinPoint theJoinPoint) {
	  
	  System.out.println("\n=====>Applying Around advice for method: "+theJoinPoint
	  .getSignature().toShortString()+"=====>\n");
	  
	  }
	 

}

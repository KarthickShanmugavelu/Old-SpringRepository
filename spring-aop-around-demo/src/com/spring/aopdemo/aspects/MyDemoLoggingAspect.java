package com.spring.aopdemo.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.spring.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundAdviceForGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print advising method
		myLogger.info("\n=====>Applying Around advice for method: "
				+ theProceedingJoinPoint.getSignature().toShortString() + "=====>\n");

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// continue executing method
		Object result;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {

			myLogger.warning(e.getMessage());

			// to handle exception
			// result = "Major Accident! but no worries your private helicopter is on the
			// way!!! :) ";

			//rethrowing it
			throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration
		long duration = end - begin;
		myLogger.info("Time taken for method execution: " + duration / 1000 + " seconds\n");

		return result;
	}

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
		myLogger.info("=====>Executing @Before advice for all methods except getter and setters*()<=====\n");

		// display method signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method Signature: " + theMethodSignature);

		// display method args
		int count = 1;
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			myLogger.info("Argument " + count + ": " + tempArg);
			if (tempArg instanceof Account) {
				Account tempAcct = (Account) tempArg;
				myLogger.info("Account name: " + tempAcct.getName());
				myLogger.info("Account level: " + tempAcct.getLevel());
			}
		}

	}

	@Before("allMethodsExceptGettersAndSetters()")
	public void performAPIAnalytics() {
		myLogger.info("\n====>Performing API analytics<====\n");
	}

	// advice for after return
	@AfterReturning(pointcut = "execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningAdviceForFindAccounts(JoinPoint theJoinPoint, List<Account> result) {

		// print the method name which we are advising
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>Applying after returning advice to method: " + method + "=====>\n");

		// print results
		myLogger.info("Before applying advice: " + result);

		convertAccountToUpperCase(result);

		myLogger.info("After applying advice: " + result);

	}

	private void convertAccountToUpperCase(List<Account> result) {

		for (Account temp : result) {
			String acctName = temp.getName().toUpperCase();
			String tempLevel = temp.getLevel().toUpperCase();
			temp.setName(acctName);
			temp.setLevel(tempLevel);

		}

	}

	// aspect for afterthrow
	@AfterThrowing(pointcut = "execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingAdviceForFindAccounts(JoinPoint theJoinPoint, Exception theExc) {

		myLogger.info("\n=====>Applying AfterThrowing advice for method: " + theJoinPoint.getSignature().toShortString()
				+ "=====>\n");

		myLogger.info("Processing the exception '" + theExc + "' thrown inside advice");

	}

	@After("execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdviceForFindAccounts(JoinPoint theJoinPoint) {

		myLogger.info("\n=====>Applying After(finally) advice for method: "
				+ theJoinPoint.getSignature().toShortString() + "=====>\n");

	}

	@Around("execution(*  com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void aroundAdviceForFindAccounts(JoinPoint theJoinPoint) {

		myLogger.info("\n=====>Applying Around advice for method: " + theJoinPoint.getSignature().toShortString()
				+ "=====>\n");

	}

}

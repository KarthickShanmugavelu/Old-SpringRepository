package com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	// create aspects for getters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	// create pointcut for setters
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	// create pointcut for all methods in package except getters and setters
	@Pointcut("forDaoPackage() && !( getter() || setter() )")
	public void allMethodsExceptGettersAndSetters() {

	}

}

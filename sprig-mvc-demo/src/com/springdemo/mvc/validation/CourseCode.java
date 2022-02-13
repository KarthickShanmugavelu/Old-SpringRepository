package com.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define attributes of annotation.
	
	//define default course code
	public String value() default "SK";
	
	//define default error message 
	public String message() default "Course code must start with SK";
	
	//define groups
	public Class<?>[] groups() default {};
	
	//define payloads
	public Class<? extends Payload>[] payload() default {};
	
	
	
	
}

package com.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=ProductCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductCode {
	
	public String[] codeValue() default {"PC"};
	
	public String message() default "Product code must start with PC or PDC or PDCTC or PDTC"; 
	
	//define groups
		public Class<?>[] groups() default {};
		
		//define payloads
		public Class<? extends Payload>[] payload() default {};

}

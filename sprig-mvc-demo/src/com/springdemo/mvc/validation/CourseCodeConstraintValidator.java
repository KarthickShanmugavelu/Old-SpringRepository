package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String courseCodePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		courseCodePrefix=courseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		/*the 1st param of isValid method holds the value passed by the user
		ConstraintValidatorContext can be used to give additional error messages.*/
		
		boolean result;
		
		if(theCode !=null) {
		result= theCode.startsWith(courseCodePrefix);
		return result;
		}
		else
			return true;
	}
	

}

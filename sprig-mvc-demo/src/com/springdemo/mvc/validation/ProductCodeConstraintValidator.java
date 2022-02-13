package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductCodeConstraintValidator implements ConstraintValidator<ProductCode, String>{
	
	public String[] pdctprefix;
	
	@Override
	public void initialize(ProductCode productCode) {
		
		pdctprefix = productCode.codeValue();
	}

	@Override
	public boolean isValid(String thepdctCode, ConstraintValidatorContext arg1) {
		
		boolean result=false;
		
		if(thepdctCode!=null) {
			for(String tempprefix:pdctprefix) {
				result=thepdctCode.startsWith(tempprefix);
				if(result)
					break;
			}
		}
		else
			return true;
		return result;

		
		
	}
	
	

}

package com.app.springAnnotationDemo;

import org.springframework.stereotype.Component;

@Component 
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Don't worry about others"; 
	}

}

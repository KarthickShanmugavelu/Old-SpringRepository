package com.app.springAnnotationDemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//@Override
	public String getFortune() {
		return "Peace be with you";
	}

}

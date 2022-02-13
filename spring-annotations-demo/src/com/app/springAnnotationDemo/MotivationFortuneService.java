package com.app.springAnnotationDemo;

public class MotivationFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Train Your Body Train Your Mind";
	}

}

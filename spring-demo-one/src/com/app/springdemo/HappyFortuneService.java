package com.app.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "This is your lucky day";
	}

}

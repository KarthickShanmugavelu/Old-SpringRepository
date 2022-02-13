package com.app.springdemo;

public class BatmintonCoach implements Coach {

	private RandomFortuneService randomFortuneService;

	public BatmintonCoach() {
		System.out.println("Default Constructor");
	}

	public BatmintonCoach(RandomFortuneService randomFortuneService) {
		this.randomFortuneService = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do a touch game for 20 mins";
	}

	@Override
	public String getDailyFortune() {
		return randomFortuneService.getFortune();
	}

}

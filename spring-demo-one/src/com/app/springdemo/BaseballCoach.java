package com.app.springdemo;

public class BaseballCoach implements Coach {

	//create a field for dependency 
	private FortuneService fortuneService;
	
	//constructor for constructor injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

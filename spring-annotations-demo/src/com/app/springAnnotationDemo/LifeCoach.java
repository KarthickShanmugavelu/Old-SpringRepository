package com.app.springAnnotationDemo;

import org.springframework.beans.factory.annotation.Value;

public class LifeCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${team}")
	private String team;
	
	@Value("${captain}")
	private String captain;
	
	public String getTeam() {
		return team;
	}

	public String getCaptain() {
		return captain;
	}

	public LifeCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWarmUp() {
		return "Meditate daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

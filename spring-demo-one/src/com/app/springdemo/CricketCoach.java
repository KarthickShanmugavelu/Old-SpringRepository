package com.app.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//create fields for injecting values
	private String team,emailAddress,captain,viceCaptain;

	// constructor

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getViceCaptain() {
		return viceCaptain;
	}

	public void setViceCaptain(String viceCaptain) {
		this.viceCaptain = viceCaptain;
	}

	public CricketCoach() {

		System.out.println("Inside Cricket Coach's constructor");
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside Cricket Coach Team's setter");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside Cricket Coach EmailAddress's setter");
		this.emailAddress = emailAddress;
	}



	// setter
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Cricket Coach FortuneService's setter");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do a net practice for Batting";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

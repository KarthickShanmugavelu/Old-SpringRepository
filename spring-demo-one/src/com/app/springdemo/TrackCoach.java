package com.app.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach,DisposableBean  {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do it "+fortuneService.getFortune();
	}
	
	//init method
	public void myCustomInitMethod() {
		System.out.println("Inside myCustomInitMethod()");
	}
	
	//destroy method
	/*
	 * public void myCustomDestroyMethod() {
	 * System.out.println("Inside myCustomDestroyMethod()"); }
	 */

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside DestroyMethod()");
		
	}

}

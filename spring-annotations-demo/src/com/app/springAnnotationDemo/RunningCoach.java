package com.app.springAnnotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RunningCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;
	FortuneService fortuneService1,fortuneService2;
	
	@Autowired
	@Qualifier("databaseFortuneService")
	FortuneService fortuneService3;
	
	@Value("${team}")
	String team;
	
	@Value("${captain}")
	String captain;
	/*
	 * //Construtor injection
	 * 
	 * @Autowired public
	 * RunningCoach(@Qualifier("happyFortuneService")FortuneService fortuneService)
	 * { System.out.println("Inside Running Coach's constructor");
	 * this.fortuneService = fortuneService; }
	 */
	
	//Setter Injection
	@Autowired
	@Qualifier("randomFortuneService")
	public void setRandomFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Running Coach's setter");
		fortuneService1 = fortuneService;
	}
	

	@Override
	public String getDailyWarmUp() {
		return "Do stretching and jog for 15 mins";
	}


	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getOtherFortune() {
		return fortuneService1.getFortune();
	}
	
	//method injection
	@Autowired
	@Qualifier("spanishFortuneService")
	public void methodInjectionExample(FortuneService fortuneService) {
		fortuneService2 = fortuneService;
	}
	
	public String getSpanishFortune() {
		return fortuneService2.getFortune();
	}
	
	public String getDatabaseFortuneService() {
		return fortuneService3.getFortune();
	}
}

package com.app.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	Random random;
	
	String randomFortune[]= {"You surely will see your best version",
							 "You are gonna win","You are gonna rock"};
	
	

	@Override
	public String getFortune() {
		random = new Random();
		int rand=random.nextInt(3);
		return randomFortune[rand];
	}

}

package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// simulate a delay
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return a string
		return "Expect heavy traffic in the morning";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire)
			throw new RuntimeException("Major accident highway is closed!!! :(");
		return getFortune();
	}

}

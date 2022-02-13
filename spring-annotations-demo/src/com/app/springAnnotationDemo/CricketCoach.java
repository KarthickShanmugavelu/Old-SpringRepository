package com.app.springAnnotationDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	ArrayList<String> fortunes = new ArrayList<>();
	@PostConstruct
	public void muCustomInit() throws FileNotFoundException {
		
		System.out.println("My Custom Init");
		File file = new File("src\\cricket.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			fortunes.add(sc.nextLine());
			}
		
	}
	
	@PreDestroy
	public void myCustomDestroy() {
		
		System.out.println("My Custom Destroy");
	}
	
	@Override
	public String getDailyWarmUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		Random rand = new Random();
		int n = rand.nextInt(4);
		return fortunes.get(n);
	}

}

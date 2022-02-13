package com.app.springAnnotationDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune()  {
		
		File file = new File("src\\fortunes.txt");
		String arr[] = new String[10];
		int count=0;
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
			arr[count]=sc.nextLine();
			count++;
			}
			sc.close();
		}
		catch(Exception e) {
			System.out.println("Exception occured");
		}
		Random random = new Random();
		int temp = random.nextInt(6);
		return arr[temp];
	}

}

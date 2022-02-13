package com.app.springAnnotationDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.app.springAnnotationDemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public FortuneService motivationFortuneService() {
		return new MotivationFortuneService();
	}
	
	@Bean
	public Coach lifeCoach() {
		
		return new LifeCoach(motivationFortuneService());
	}

}
